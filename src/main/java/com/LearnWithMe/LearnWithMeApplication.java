package com.LearnWithMe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.LearnWithMe.Service.userService;

@SpringBootApplication
public class LearnWithMeApplication {
	@Autowired
	private userService usService;

	public static void main(String[] args) {

		SpringApplication.run(LearnWithMeApplication.class, args);
		System.out.println("==************Welcome LearnwithMe app**************===========");
	
	}
//
//	@Override
//	public void run(String... args) throws Exception {
//		// TODO Auto-generated method stub
//
//		User user=new User();
//		
//		user.setEmail("admin@gmail.com");
//		user.setEnable(true);
//		user.setFirstName("Admin");
//		user.setLastName("user");
//		user.setPassword("abc");
//		user.setPhone("82872872");
//		user.setUserName("Test user2");
//		user.setProfile("abc.jpg");
//		
//		Role role=new Role();
//		role.setRole("Normaluser");
//				
//		Set<UserRole> userRolesSet=new HashSet<>();
//		UserRole userRole=new UserRole();
//		userRole.setRole(role);
//		userRole.setUser(user);
//		userRolesSet.add(userRole);
//		
//       User u=this.usService.createUser(user, userRolesSet);
//       System.out.println(u);
//		
//		
//	}

}
