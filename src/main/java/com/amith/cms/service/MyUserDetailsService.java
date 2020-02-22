package com.amith.cms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.amith.cms.models.MyUserDetails;
import com.amith.cms.models.User;
import com.amith.cms.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
    private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Optional<User> user = userRepository.findByUsername(userName);

        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));

        return user.map(MyUserDetails::new).get();
	}
	
	public User registerUser(User user) {
		user.setActive(true);
		user.setRoles("ROLE_USER");
        return userRepository.save(user);
	}
	
	public User getUserByUserId(int userId) throws UsernameNotFoundException {
		Optional<User> user =  userRepository.findById(userId);
		user.orElseThrow(() -> new UsernameNotFoundException("Not found ID: " + userId));
		
        return user.get();
	}

}
