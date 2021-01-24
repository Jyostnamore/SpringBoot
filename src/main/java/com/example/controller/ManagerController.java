package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.model.Manager;
import com.example.repository.ManagerRepo;

@RestController
@CrossOrigin(origins = "http://localhost:4200" ,maxAge=3600)
@RequestMapping("/api/v2")
public class ManagerController {
	@Autowired
	private ManagerRepo mrepo;
	@GetMapping("/manager")
	public List<Manager> getAllEmployees()
	{
		return mrepo.findAll();
		
	}
	@PostMapping("/manager")
	public Manager createEmployee(@RequestBody Manager man)
	{
		return mrepo.save(man);
	}

	
	
}
