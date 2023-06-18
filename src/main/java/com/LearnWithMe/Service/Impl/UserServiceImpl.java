package com.LearnWithMe.Service.Impl;

import java.util.Set;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.LearnWithMe.Repo.roleRepository;
import com.LearnWithMe.Repo.userRepository;
import com.LearnWithMe.Service.userService;
import com.LearnWithMe.entity.User;
import com.LearnWithMe.entity.UserRole;

@Service
public class UserServiceImpl implements userService {
	
	@Autowired
	private userRepository userRepository;
	@Autowired
	private roleRepository roleRepository;

	

	@Override
	public User createUser(User user, Set<UserRole> userRoles) {
		User local=this.userRepository.findByUserName(user.getUserName());
		if(local !=null)
		{
			throw new ResponseStatusException(HttpStatus.ALREADY_REPORTED, "Username already exists!"+user.getUserName());
		}else {
			//create user
			for(UserRole ur:userRoles)
			{
				roleRepository.save(ur.getRole());
			}
			user.getUserRoles().addAll(userRoles);	
			 this.userRepository.save(user);
		}
	
		return this.userRepository.save(user);
	}

	@Override
	public User findByUserName(String userName) {
		
		return this.userRepository.findByUserName(userName);
	}

	
	@Override
	public void deleteByUserId(Long userId) {
		this.userRepository.deleteById(userId);
		
	}
	

}
