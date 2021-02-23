package com.spring.annotation.topic9.dao;

import org.springframework.stereotype.Repository;

@Repository
public class Topic9Dao {
    private String flag = "1";

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Topic9Dao{" +
                "flag='" + flag + '\'' +
                '}';
    }
}
