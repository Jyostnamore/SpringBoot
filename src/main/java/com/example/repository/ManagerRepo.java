package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Manager;

@Repository
public interface ManagerRepo extends JpaRepository<Manager,String>{
	public Manager findUserByEmail(String email);
}
