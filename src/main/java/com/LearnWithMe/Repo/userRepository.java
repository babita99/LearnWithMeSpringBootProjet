package com.LearnWithMe.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LearnWithMe.entity.User;

public interface userRepository extends JpaRepository<User, Long> {

	public User findByUserName(String userName);

}
