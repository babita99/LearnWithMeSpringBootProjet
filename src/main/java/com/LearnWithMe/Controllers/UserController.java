package com.LearnWithMe.Controllers;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.LearnWithMe.Service.userService;
import com.LearnWithMe.entity.Role;
import com.LearnWithMe.entity.User;
import com.LearnWithMe.entity.UserRole;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
	@Autowired
	private userService userService;
	
	
// 1. for Create user 
	@PostMapping("/")
	public User createUser(@RequestBody User user)
	{
		Set<UserRole> roles=new HashSet<>();
		Role r=new Role();
		r.setRole("Normal User");
		
	    UserRole userRole=new UserRole();
		userRole.setUser(user);
		userRole.setRole(r);
		roles.add(userRole);
		System.out.println(user);
		return this.userService.createUser(user,roles);
		}
	
	// 1. for get user 
	@GetMapping("/{userName}")
	public User getUserDetails(@PathVariable("userName") String userName)
	{
		
		return this.userService.findByUserName(userName);
	}
	
	// 1. for delete user 
	
	@DeleteMapping("/{userId}")
	public void deleteUserDetails(@PathVariable("userId") Long userId)
	{
		this.userService.deleteByUserId(userId);
	}
	
	

}
