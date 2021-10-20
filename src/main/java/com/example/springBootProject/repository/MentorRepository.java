package com.example.springBootProject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springBootProject.entity.Mentor;

public interface MentorRepository extends JpaRepository<Mentor,Integer> {

	Mentor findByName(String name);

	Optional<Mentor> findById(Optional<Mentor> id);

}
