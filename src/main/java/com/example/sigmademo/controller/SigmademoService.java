package com.example.sigmademo.controller;

import java.util.List;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.sigmademo.model.CalculationRequest;
import com.example.sigmademo.model.Employee;
import com.example.sigmademo.model.db.EmployeePersistence;

@RestController
public class SigmademoService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger("com.example.sigmademo.controller.SigmademoService");
	@Autowired
	private JdbcTemplate jdbcTemplate;

	// GET method
    @GetMapping(value = "/getExample")
    public ResponseEntity<String> getExample() {
        return new ResponseEntity<>("Hi this is Sigma Demo ", HttpStatus.OK);
    }
    
	 // POST method
	  @PostMapping(value = "/postExample")
	  public ResponseEntity<Integer> postExample(@RequestBody CalculationRequest request) {
	      int result;
	      switch (request.getOperator()) {
	          case "+":
	              result = request.getOperand1() + request.getOperand2();
	              break;
	          case "-":
	              result = request.getOperand1() - request.getOperand2();
	              break;
	          case "*":
	              result = request.getOperand1() * request.getOperand2();
	              break;
	          case "/":
	              if (request.getOperand2() == 0) {
	                  return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	              }
	              result = request.getOperand1() / request.getOperand2();
	              break;
	          default:
	              return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	      }
	      return new ResponseEntity<>(result, HttpStatus.OK);
	  }
	  
	  
	  //Post method MySQL
	  @PostMapping(value = "/v1/employeeprofile")
		public ResponseEntity<String> generateEmployee(@RequestBody Employee employee) throws Exception {
			try {
				JSONObject responseJson = new JSONObject();
				EmployeePersistence employeePersistence = new EmployeePersistence();
				int insertCount = employeePersistence.createEmployee(employee, jdbcTemplate);
				if (insertCount == 1)
					responseJson.put("result", "User Create / Update Successful !");
				else
					responseJson.put("result", "User Create / Update Failed !");
				return new ResponseEntity<>(responseJson.toString(), HttpStatus.OK);
			} catch (Exception exception) {
				LOGGER.error("Error while getting the location risk result.", exception);
				throw new Exception("Error while getting the location risk result");
			}
		}

		@PutMapping(value = "/v1/employee")
		public ResponseEntity<String> updateEmployee(@RequestBody Employee employee) throws Exception {
			try {
				JSONObject responseJson = new JSONObject();
				EmployeePersistence employeePersistence = new EmployeePersistence();
				int insertCount = employeePersistence.updateEmployee(employee, jdbcTemplate);
				if (insertCount == 1)
					responseJson.put("result", "User Create / Update Successful !");
				else
					responseJson.put("result", "User Create / Update Failed !");
				return new ResponseEntity<>(responseJson.toString(), HttpStatus.OK);
			} catch (Exception exception) {
				LOGGER.error("Error while getting the location risk result.", exception);
				throw new Exception("Error while getting the location risk result");
			}
		}
//		
		@GetMapping(value = "/v1/employee/{id}")
		public ResponseEntity<Employee> getEmployee(@PathVariable("id") int id) throws Exception {
			try {
				EmployeePersistence employeePersistence = new EmployeePersistence();
				Employee employee = employeePersistence.getEmployeeById(jdbcTemplate, id);
				return new ResponseEntity<>(employee, HttpStatus.OK);
			} catch (Exception exception) {
				LOGGER.error("Error while getting the location risk result.", exception);
				throw new Exception("Error while getting the location risk result");
			}
		}
		
		@GetMapping(value = "/v1/employees")
		public ResponseEntity<List<Employee>> getEmployees() throws Exception {
			try {
				EmployeePersistence employeePersistence = new EmployeePersistence();
				List<Employee> employees = employeePersistence.getEmployee(jdbcTemplate);
				return new ResponseEntity<>(employees, HttpStatus.OK);
			} catch (Exception exception) {
				LOGGER.error("Error while getting the location risk result.", exception);
				throw new Exception("Error while getting the location risk result");
			}
		}
	  
    
}
