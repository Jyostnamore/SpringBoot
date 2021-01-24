package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Manager;

public interface UserRepo extends JpaRepository<Manager, Long>{
//	public Manager findByUsername(String username);
	public Manager findUserByEmail(String email);

}
