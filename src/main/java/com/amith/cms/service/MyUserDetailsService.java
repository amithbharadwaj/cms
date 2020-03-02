package com.amith.cms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.amith.cms.models.MyUserDetails;
import com.amith.cms.models.User;
import com.amith.cms.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	public UserRepository userRepository;

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
	
	public User getUser(User user) throws UsernameNotFoundException {
		Optional<User> user1 = null;
		if (user.getId() > 0) {
			user1 = userRepository.findById(user.getId());
		} else if (!StringUtils.isEmpty(user.getUsername())) {
			user1 = userRepository.findByUsername(user.getUsername());
		} else if (!StringUtils.isEmpty(user.getFirstName()) && !StringUtils.isEmpty(user.getLastName())) {
			user1 = userRepository.findByFirstNameAndLastName(user.getFirstName(), user.getLastName());
		} else if (!StringUtils.isEmpty(user.getFirstName())) {
			user1 = userRepository.findByFirstName(user.getFirstName());
		} else if (!StringUtils.isEmpty(user.getLastName())) {
			user1 = userRepository.findByLastName(user.getLastName());
		}
		user1.orElseThrow(() -> new UsernameNotFoundException("Not found ID: " + user.toString()));
		
        return user1.get();
	}
	

}
