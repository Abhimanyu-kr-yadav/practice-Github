package com.example.springBootProject.service;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.springBootProject.entity.Mentor;
import com.example.springBootProject.repository.MentorRepository;

@Service
public class MentorService {
	@Autowired
	private MentorRepository repository;
	
	@Transactional
	public Mentor saveMentor(Mentor mentor) {
		return repository.saveAndFlush(mentor);
	}
	
	 public List<Mentor> saveMentors(List<Mentor> mentors) {
	        return repository.saveAll(mentors);
	    }

	
	public List<Mentor> getMentors() {
		return repository.findAll();
	}
	
	public Mentor getMentorById(int id) {
		return repository.findById(id).get();
	}
	
	public Mentor getMentorByName(String name) {
		return repository.findByName(name);
	}
	
	public String deleteMentor(int id) {
		repository.deleteById(id);
		return "mentor removed !!"+id;
	}
	
	public Mentor updateMentor(Mentor mentor) {
		Mentor existingMentor = repository.findById(mentor.getId()).orElse(null);
		existingMentor.setName(mentor.getName());
		existingMentor.setEmail(mentor.getEmail());
		existingMentor.setPhone(mentor.getPhone());
		existingMentor.setAddress(mentor.getAddress());
		
		return repository.save(existingMentor);
	}
	 	

}
