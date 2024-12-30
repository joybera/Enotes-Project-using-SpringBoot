package com.joy.service;

import com.joy.entity.User;

public interface UserService {
	
	public User saveUser(User user);
	
	public boolean existEmailCheck(String email);
}
