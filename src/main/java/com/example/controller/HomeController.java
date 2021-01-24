package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@Controller
@CrossOrigin(origins = "http://localhost:4200" ,maxAge=3600)
public class HomeController {
	
	@RequestMapping("/home")
	public String home()
	{
		String text="this is private";
		return text;
	}

}
