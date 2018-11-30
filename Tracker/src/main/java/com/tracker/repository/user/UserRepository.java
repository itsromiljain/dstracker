package com.tracker.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tracker.model.user.UserDetails;

public interface UserRepository extends JpaRepository<UserDetails, Long> {
} 
	
