package com.LearnWithMe.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.LearnWithMe.Repo.userRepository;
import com.LearnWithMe.entity.User;
import com.LearnWithMe.entity.UserRole;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private userRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	User user=this.repository.findByUserName(username);
	if(user==null)
	{
		System.out.println("user not found");
		throw new  UsernameNotFoundException("not found");
	}
		
		return user;
	}

}
