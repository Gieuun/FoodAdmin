package com.sds.foodadmin.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DashBoardCounter {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Cacheable("visitorCount")
    public int countVisitors() {
	String sql = "SELECT COUNT(*) FROM visitorLog";
	return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    @Cacheable("countMember")
    public int countMembers() {
	String sql = "SELECT COUNT(*) FROM member";
	return jdbcTemplate.queryForObject(sql, Integer.class);
    }

}
