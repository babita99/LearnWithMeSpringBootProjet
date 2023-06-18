package com.LearnWithMe.Service;

import java.util.Set;

import com.LearnWithMe.entity.User;
import com.LearnWithMe.entity.UserRole;

public interface userService {
	
	//creating user
	public User createUser(User user, Set<UserRole> userRoles);
	public User findByUserName(String userName);
	public  void deleteByUserId(Long userId);


}
