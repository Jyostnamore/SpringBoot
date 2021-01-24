package com.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.config.MySecurityConfig;
import com.example.exception.ResourceNotFoundException;
import com.example.model.Employee;
import com.example.repository.EmployeeRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200" ,maxAge=3600)
@RequestMapping("/api/v1/")
public class EmployeeController {
	Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	@Autowired
	private EmployeeRepository emp;
	
	//display all employee
	@RequestMapping(value = "/employees",method = {RequestMethod.GET})
	public List<Employee> getAllEmployees()
	{
		logger.info("display list of all employee");
		return emp.findAll();
		
	}
	//create employee
	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee)
	{
		logger.info("create employee");
		return emp.save(employee);
	}
	
	//serach employee by id
	
	@GetMapping("/employees/{id}")
	
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id)
	{
		logger.info("Serach employee by id");
		Employee employee=emp.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee not exist with id:"+id));
		return ResponseEntity.ok(employee);
		
	}
	
	//update
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,@RequestBody Employee empdetails)
	{
		logger.info("Update employee");
		Employee employee=emp.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee not exist with id:"+id));
		employee.setFirstname(empdetails.getFirstname());
		employee.setLastname(empdetails.getLastname());
		employee.setEmail(empdetails.getEmail());;
		Employee updateEmployee=emp.save(employee);
		return ResponseEntity.ok(updateEmployee);
	}
	
	//Delete
	@DeleteMapping("/employees/{id}")
	@CrossOrigin
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
		logger.info("delete employee by id");
		Employee employee = emp.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		
		emp.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
