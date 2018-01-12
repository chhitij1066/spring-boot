package com.example.demo;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.DTO.Student;

@Controller
public class WelcomeController {

	// inject via application.properties
	@Value("${message:test}")
	private String message = "Hello World";
	
	@Autowired
	private Student student;

	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		model.put("message", this.message);
		model.put("student", this.populateStudent());
		return "welcome";
	}
	
	public Student populateStudent(){
		student.setFirstName("Zakir");
		student.setLastName("Syed");
		student.setStudentId(123);
		return student;
	}

}