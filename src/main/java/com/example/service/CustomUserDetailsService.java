package com.example.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;

import com.example.model.Manager;
import com.example.model.ManagerDetails;
import com.example.repo.UserRepo;
import com.example.repository.ManagerRepo;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private ManagerRepo mangerepo;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
			Manager manger=this.mangerepo.findUserByEmail(email);
			if(manger==null)
			{
				throw new UsernameNotFoundException("user not found");
				
			}
			else
			{
				return new ManagerDetails(manger);
			}
		
		//		if(username.equals("jyostna"))
//		{
//			return new User("jyostna","1234",new ArrayList<>());
//		}
//		else
//		{
//			throw new UsernameNotFoundException("user not found");
//		}
//		
			
	}

}
