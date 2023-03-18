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
	/*
	 * class EmployeeRowMapper implements RowMapper<Map<String,Employee>> {
	 * 
	 * @Override public Employee mapRow(ResultSet rs, int rowNum) throws
	 * SQLException { Employee employee = new Employee();
	 * employee.setId(rs.getLong("id"));
	 * employee.setFirstName(rs.getString("first_name"));
	 * employee.setLastName(rs.getString("last_name"));
	 * employee.setEmailId(rs.getString("email_address")); return employee; } }
	 */
	/*
	 * public List<Map<String,Employee>> getQueryReport(String query) { return
	 * jdbcTemplate.query(query, new EmployeeRowMapper());
	 * 
	 * }
	 */
	
	
	public List<Map<String, Object>> getQueryReport(String query){
		
		List<Map<String,Object>>result=jdbcTemplate.queryForList(query);
		
		return result;
	}

}
