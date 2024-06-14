package com.sds.foodadmin.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class VisitorCounter {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Cacheable("visitorCount")
    public int countVisitors() {
	String sql = "SELECT COUNT(*) FROM visitorLogs";
	return jdbcTemplate.queryForObject(sql, Integer.class);
    }

}
