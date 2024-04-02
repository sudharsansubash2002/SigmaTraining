package com.example.sigmademo.model.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.sigmademo.model.Employee;

public class EmployeeRowMapper implements RowMapper<Employee>{
	@Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee employee = new Employee();
		employee.setEmpId(rs.getInt("emp_id"));
		employee.setFirstName(rs.getString("first_name"));
		employee.setLastName(rs.getString("last_name"));
		employee.setEmailId(rs.getString("email_id"));
        return employee;
    }
}
