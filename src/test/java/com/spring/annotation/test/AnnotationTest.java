package com.spring.annotation.test;


import com.spring.annotation.bean.Person;
import com.spring.annotation.bean.initbean.processor.CustomBeanDefinitionRegistryPostProcessor;
import com.spring.annotation.bean.initbean.processor.CustomBeanFactoryPostProcessor;
import com.spring.annotation.topic10.aop.Calculator;
import com.spring.annotation.topic10.config.AnnotationConfig10;
import com.spring.annotation.topic11.config.AnnotationConfig11;
import com.spring.annotation.topic11.service.Topic11Service;
import com.spring.annotation.topic12.config.AnnotationConfig12;
import com.spring.annotation.topic2.config.AnnotationConfig2;
import com.spring.annotation.topic3.config.AnnotationConfig3;
import com.spring.annotation.topic4.config.AnnotationConfig4;
import com.spring.annotation.topic5.config.AnnotationConfig5;
import com.spring.annotation.topic6.config.AnnotationConfig6;
import com.spring.annotation.topic7.config.AnnotationConfig7;
import com.spring.annotation.topic8.config.AnnotationConfig8;
import com.spring.annotation.topic9.config.AnnotationConfig901;
import com.spring.annotation.topic9.config.AnnotationConfig902;
import com.spring.annotation.topic9.service.Topic9Service;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.Callable;


public class AnnotationTest {

    /**
     * xml方式
     */
    @Test
    public void xmlTest(){
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person = (Person) app.getBean("person");
        System.out.println(person);
    }

    /**
     * 注解方式
     */
    @Test
    public void topic1Test(){
        ApplicationContext app = new AnnotationConfigApplicationContext(AnnotationConfig2.class);
        // 对应方法名获取bean
        Person person1 = (Person) app.getBean("person");
        // 对应类名获取bean
        Person person2 = app.getBean(Person.class);
        System.out.println(person1);
        System.out.println(person2);

        String[] namesForType = app.getBeanNamesForType(Person.class);
        for (String name : namesForType){
            System.out.println(name);
        }
    }

    /**
     * 注解包扫描方式
     */
    @Test
    public void topic2Test(){
        ApplicationContext app = new AnnotationConfigApplicationContext(AnnotationConfig2.class);
        // 有两个东西肯定会打印出来：1.被扫描的配置类  2.添加了@bean注解
        String[] names = app.getBeanDefinitionNames();
        for (String name : names){
            System.out.println(name);
        }
}

    /**
     * 判断单实例还是多实例
     */
    @Test
    public void topic3Test(){
        ApplicationContext app = new AnnotationConfigApplicationContext(AnnotationConfig3.class);
        // 有两个东西肯定会打印出来：1.被扫描的配置类  2.添加了@bean注解
        String[] names = app.getBeanDefinitionNames();
        for (String name : names){
            System.out.println(name);
        }
        Object singleton1 = app.getBean("personSingleton");
        Object singleton2 = app.getBean("personSingleton");
        System.out.println("personSingleton地址是否相同：" + (singleton1 == singleton2));

        Object multiInstance1 = app.getBean("personMultiInstance");
        Object multiInstance2 = app.getBean("personMultiInstance");
        System.out.println("personMultiInstance地址是否相同：" + (multiInstance1 == multiInstance2));
    }

    /**
     * 懒加载
     */
    @Test
    public void topic4Test(){
        ApplicationContext app = new AnnotationConfigApplicationContext(AnnotationConfig4.class);
        System.out.println("IOC容器创建完成");
        app.getBean("person");
    }

    /**
     * 按条件加载
     */
    @Test
    public void topic5Test(){
        ApplicationContext app = new AnnotationConfigApplicationContext(AnnotationConfig5.class);
        System.out.println("IOC容器创建完成");
    }

    /**
     * @Import 方式注入
     */
    @Test
    public void topic6Test(){
        ApplicationContext app = new AnnotationConfigApplicationContext(AnnotationConfig6.class);
        System.out.println("IOC容器创建完成");
        // 获取要创建的实例
        Object bean = app.getBean("factoryBean");
        // 获取FactoryBean实例
        Object bean1 = app.getBean("&factoryBean");
        System.out.println(bean);
        System.out.println(bean1);
        String[] names = app.getBeanDefinitionNames();
        for (String name : names){
            System.out.println(name);
        }
    }

    /**
     * 实例中定义bean生命周期
     */
    @Test
    public void topic7Test(){
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(AnnotationConfig7.class);
        System.out.println("IOC容器创建完成");
        app.close();
    }

    /**
     * @Value 直接使用和配置类使用
     */
    @Test
    public void topic8Test(){
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(AnnotationConfig8.class);
        System.out.println("IOC容器创建完成");
        String[] names = app.getBeanDefinitionNames();
        for (String name : names){
            System.out.println(name);
        }
        Person person = (Person) app.getBean("person");
        System.out.println(person);
        app.close();
    }

    /**
     * 基础注入注解
     */
    @Test
    public void topic9Test01(){
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(AnnotationConfig901.class);
        Topic9Service service = app.getBean(Topic9Service.class);
        service.topic9();
        // 当getBean的值传入的是类时,注入两个不同名的bean会报错,同名bean默认获取该类
//        Topic9Dao dao = (Topic9Dao) app.getBean(Topic9Dao.class);
//        System.out.println(dao);
        app.close();
    }

    /**
     * 获取bean的操作
     */
    @Test
    public void topic9Test02(){
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(AnnotationConfig902.class);
        app.close();
    }

    /**
     * AOP
     */
    @Test
    public void topic10Test(){
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(AnnotationConfig10.class);
        Calculator bean = app.getBean(Calculator.class);
        int div = bean.div(4, 2);
        System.out.println(div);
        app.close();
    }

    /**
     * 声明式事务
     */
    @Test
    public void topic11Test(){
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(AnnotationConfig11.class);
        Topic11Service bean = app.getBean(Topic11Service.class);
        bean.addOrder();
        app.close();
    }

    /**
     * 拦截BeanFactory
     */
    @Test
    public void topic12Test(){
        // 执行顺序：CustomBeanDefinitionRegistryPostProcessor.postProcessBeanDefinitionRegistry > CustomBeanDefinitionRegistryPostProcessor.postProcessBeanFactory > CustomBeanFactoryPostProcessor.postProcessBeanFactory
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(AnnotationConfig12.class);

        app.close();
    }

}
