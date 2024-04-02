package com.example.sigmademo.model.db;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.sigmademo.model.Employee;
import com.example.sigmademo.model.db.EmployeeRowMapper;

public class EmployeePersistence {
	
	private static final Logger LOGGER = LoggerFactory.getLogger("com.example.sigmademo.model.db.EmployeePersistence");
	
	static final String INSERT_EMPLOYEE_SQL = "INSERT INTO employee "
			+ "(first_name, last_name, email_id) VALUES (?,?,?)";
	
	static final String EMPLOYEE_UPDATE = "UPDATE employee SET first_name= ?, "
			+ "last_name = ? , email_id = ? WHERE emp_id = ? ";
	
	public List<Employee> getEmployee(JdbcTemplate jdbcTemplate) {
		try {
			//List<UserProfile> userList = new ArrayList<UserProfile>();
			String query = "SELECT * FROM employee";
			List<Employee> employees = jdbcTemplate.query(query, new EmployeeRowMapper());
			if(employees == null || employees.isEmpty())
				return new ArrayList<Employee>();		
		return employees;
		}catch(Exception exception) {
			LOGGER.error("UserPersistence.getNFTAsset() ", exception);
			return new ArrayList<Employee>();
		}
	}
	
	public Employee getEmployeeById(JdbcTemplate jdbcTemplate, int id) {
		try {
			//List<UserProfile> userList = new ArrayList<UserProfile>();
			String query = "SELECT * FROM employee WHERE emp_id= ?";
			Employee employee = jdbcTemplate.queryForObject(query, new EmployeeRowMapper(), new Object[] { id });		
		return employee;
		}catch(Exception exception) {
			LOGGER.error("EmployeePersistence.getById() ", exception);
			return null;
		}
	}
	
	public int createEmployee(Employee employee, JdbcTemplate jdbcTemplate) {
		int insert = 0;
		try {
			
			insert = jdbcTemplate.update(INSERT_EMPLOYEE_SQL,
					employee.getFirstName(), employee.getLastName(), employee.getEmailId());			
			return insert;			
		} catch (Exception exception) {
			LOGGER.error("Error EmployeePersistence.createEmployee() profile", employee, exception);
			return insert;
		}
	}
	
	public int updateEmployee(Employee employee, JdbcTemplate jdbcTemplate) {
		int update=0;
		try {
			int empId= employee.getEmpId();
			if(empId == 0 )
				return 0;			
			update = jdbcTemplate.update(EMPLOYEE_UPDATE, employee.getFirstName(), 
					employee.getLastName(), employee.getEmailId(),
					employee.getEmpId());				
				return update;
		}catch(Exception exception) {
			LOGGER.error("Error EmployeePersistence.updateUser() profile", employee, exception);
			return update;
		}
		}	

}
