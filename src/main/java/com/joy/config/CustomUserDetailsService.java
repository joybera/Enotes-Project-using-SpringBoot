package com.joy.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.joy.entity.User;
import com.joy.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User byEmail = userRepo.findByEmail(username);

		if (byEmail == null) {
			throw new UsernameNotFoundException("user not found");
		} else {
			return new CustomUser(byEmail);
		}

	}

}
