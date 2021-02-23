package com.spring.annotation.topic13.servlet;

import com.spring.annotation.topic13.annotation.CustomController;
import com.spring.annotation.topic13.annotation.CustomQualifier;
import com.spring.annotation.topic13.annotation.CustomRequestMapping;
import com.spring.annotation.topic13.annotation.CustomService;
import com.spring.annotation.topic13.controller.Topic13Controller;
import com.spring.annotation.topic13.hander.HanderToolsService;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DispatcherServlet extends HttpServlet {
    /**
     * 存放class路径
     */
    List<String> classNames = new ArrayList<>();
    /**
     * 存放bean实例
     */
    Map<String, Object> beans = new HashMap<>();
    /**
     * 存放CustomRequestMapping路径
     */
    Map<String, Object> rmUrls = new HashMap<>();

    public DispatcherServlet(){
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        // 1.扫描哪些类需要被实例化
        doScanPackage("com.spring.annotation.topic13");
        for (String name:classNames) {
            System.out.println(name);
        }

        // 2.实例化classNames中所有bean全类名路径
        doInstance();

        // 3.依赖注入
        iocDi();

        // 4.建立URL与method的映射关系
        handlerMapper();
        for (Map.Entry<String, Object> url:rmUrls.entrySet()) {
            System.out.println(url.getKey() + ":" + url.getValue());
        }

        super.init();
    }

    /**
     * 建立映射关系
     */
    private void handlerMapper() {
        if (beans.entrySet().size() <= 0){
            System.out.println("类没有实例化.............");
            return;
        }

        for (Map.Entry<String, Object> bean:beans.entrySet()) {
            Object beanValue = bean.getValue();
            Class<?> clazz = beanValue.getClass();
            if (clazz.isAnnotationPresent(CustomController.class)) {
                // 获取路径 ---> 类上的
                CustomRequestMapping classMapping = clazz.getAnnotation(CustomRequestMapping.class);
                String classUrl = classMapping.value();

                // 获取路径 ---> 方法上的(多个)
                Method[] methods = clazz.getMethods();
                for (Method method:methods) {
                    if (method.isAnnotationPresent(CustomRequestMapping.class)) {
                        CustomRequestMapping methodMapping = method.getAnnotation(CustomRequestMapping.class);
                        String methodUrl = methodMapping.value();
                        rmUrls.put(classUrl + methodUrl, method);
                    }
                }
            }
        }
    }

    /**
     * 依赖注入
     */
    private void iocDi() {
        if (beans.entrySet().size() <= 0){
            System.out.println("类没有实例化.............");
            return;
        }

        for (Map.Entry<String, Object> bean:beans.entrySet()) {
            Object instance = bean.getValue();
            // 获取类声明了哪些注解
            Class<?> clazz = instance.getClass();
            if (clazz.isAnnotationPresent(CustomController.class)) {

                // 获取所有字段并依次设值
                Field[] fields = clazz.getDeclaredFields();
                for (Field field:fields) {
                    if (field.isAnnotationPresent(CustomQualifier.class)) {
                        CustomQualifier qualifier = field.getAnnotation(CustomQualifier.class);
                        String value = qualifier.value();

                        // 注入时要放开权限
                        field.setAccessible(true);
                        try {
                            // 第一个参数是对象,第二个参数是值,表示在这个对象中将当前field字段设置新值
                            // beans中存放的key就是注解的value值
                            field.set(instance, beans.get(value));
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    /**
     * 实例化类
     */
    private void doInstance() {
        if (classNames.size() <= 0) {
            System.out.println("扫描失败.............");
            return;
        }

        // 遍历扫描到的class全类名路径,通过反射进行创建对象
        // xxx.class --> xxx
        for (String className:classNames) {
            String name = className.replaceAll(".class", "");

            try {
                // 通过反射获取class类
                Class<?> clazz = Class.forName(name);

                // 如果在获取的class类上有CustomController注解,返回true
                if (clazz.isAnnotationPresent(CustomController.class)) {
                    // 获取注解实例
                    CustomController controller = clazz.getAnnotation(CustomController.class);
                    CustomRequestMapping requestMapping = clazz.getAnnotation(CustomRequestMapping.class);

                    // 地址是唯一的,作为key
                    String value = requestMapping.value();

                    // 获取实例化bean
                    Object instance = clazz.newInstance();

                    beans.put(value, instance);
                } else if (clazz.isAnnotationPresent(CustomService.class)) {
                    CustomService service = clazz.getAnnotation(CustomService.class);
                    Object instance = clazz.newInstance();
                    beans.put(service.value(), instance);
                }
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 扫描哪些类需要被实例化
     */
    private void doScanPackage(String basePackage) {
        // 获取当前对象的路径,根据当前路径扫描编译好的项目路径下的所有类,并且传入路径规则是 /../..
        URL url = this.getClass().getClassLoader().getResource("/" + basePackage.replaceAll("\\.", "/"));
        // 获取路径和文件名,带查询参数
        String filePath = url.getFile().replaceAll("%20", " ");
        // 根据文件名创建一个文件目录
        File file = new File(filePath);
        // 目录下所有文件和目录的文件名

        String[] fileList = file.list();
        for (String path:fileList) {
            File abFilePath = new File(filePath + path);
            // 如果是路径,就递归
            if (abFilePath.isDirectory()) {
                doScanPackage(basePackage + "." + path);
            } else {
                // com.spring.annotation.topic13.xxx.class
                classNames.add(basePackage + "." + abFilePath.getName());
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (rmUrls.entrySet().size() <= 0){
            System.out.println("没有路径.............");
            return;
        }
        // 获取访问路径地址(uri不带主机和端口号,但有项目名) ---> /项目名/topic13/customAnno
        String uri = req.getRequestURI();

        // 去掉项目名 ---> /topic13/customAnno
        String contextPath = req.getContextPath();
        String url = uri.replaceAll(contextPath, "");

        // 根据路径获取方法
        Method method = (Method) rmUrls.get(url);

        // 根据路径获取controller类 ---> / + topic13
        Topic13Controller controller = (Topic13Controller) beans.get("/" + url.split("/")[1]);

        // 获取方法参数
        HanderToolsService resolver = (HanderToolsService) beans.get("handerTools");
        Object[] args = resolver.hander(method, beans, req, resp);

        // invoke相当于执行对应调用方法的内部逻辑
        // 第一个参数：方法在哪个类中,第二个参数：方法的参数列表
        try {
            method.invoke(controller, args);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

    }

}
