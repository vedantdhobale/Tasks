package com;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;




@Service
public class QueryService {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	
	public List<Map<String, Object>> getQueryReport(String query){
		
		List<Map<String,Object>>result=jdbcTemplate.queryForList(query);
		
		return result;
	}

}
