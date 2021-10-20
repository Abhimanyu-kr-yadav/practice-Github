package com.example.springBootProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springBootProject.entity.Mentor;
import com.example.springBootProject.service.MentorService;

@RestController

public class MentorController {
	
	@Autowired
	private MentorService service;
	
	@PostMapping("/addMentor")
	public Mentor addMentor(@RequestBody Mentor mentor) {
		return service.saveMentor(mentor);	
	}
	
	@PostMapping("/addMentors")
	public List<Mentor> addMentors(@RequestBody List<Mentor> mentors){
		return service.saveMentors(mentors);
	}
	 
	@GetMapping("/mentors")
	public List<Mentor> findAllMentors(){
		return service.getMentors();
	}
	
	@GetMapping("/mentorById/{id}")
	public Mentor findMentorById(@PathVariable int id) {
		return service.getMentorById(id);
	}
	
	@GetMapping("/mentor/{name}")
	public Mentor findMentorByName(@PathVariable String name) {
		return service.getMentorByName(name);
	}
	
	@PutMapping("/update")
	public Mentor updateMentor(@RequestBody Mentor mentor) {
		return service.updateMentor(mentor);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteMentor(@PathVariable int id) {
		return service.deleteMentor(id);
	}

}
