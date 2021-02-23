package com.spring.annotation.topic11.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class Topic11Dao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insert() {
        String sql = "insert into `order` (ordertime, ordermoney, orderstatus) values(?,?,?)";
        jdbcTemplate.update(sql, new Date(), 20, 0);
    }
}
