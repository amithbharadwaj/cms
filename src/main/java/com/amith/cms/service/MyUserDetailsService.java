package com.amith.cms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.xml.sax.SAXException;

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
		user.orElseThrow(() -> new UsernameNotFoundException("User Not found ID: " + userId));
		
        return user.get();
	}
	
	public List<User> getUser(User user) throws UsernameNotFoundException {
		Optional<User> user1 = null;
		List<User> users = new ArrayList<>();
		if (user.getId() > 0) {
			user1 = userRepository.findById(user.getId());
			user1.orElseThrow(() -> new UsernameNotFoundException("User Not found.."));
			users.add(user1.get());
		} else if (!StringUtils.isEmpty(user.getUsername())) {
			user1 = userRepository.findByUsername(user.getUsername());
			user1.orElseThrow(() -> new UsernameNotFoundException("User Not found.."));
			users.add(user1.get());
		} else if (!StringUtils.isEmpty(user.getFirstName()) && !StringUtils.isEmpty(user.getLastName())) {
			users = userRepository.findByFirstNameAndLastNameIgnoreCase(user.getFirstName(), user.getLastName());
		} else if (!StringUtils.isEmpty(user.getFirstName())) {
			users = userRepository.findByFirstNameIgnoreCase(user.getFirstName());
		} else if (!StringUtils.isEmpty(user.getLastName())) {
			users = userRepository.findByLastNameIgnoreCase(user.getLastName());
		}
		
		ListIterator<User> itr = (ListIterator<User>) users.listIterator();
		User listUser = null;
		while (itr.hasNext()) {
			listUser = itr.next();
			if (!listUser.getRoles().equalsIgnoreCase("ROLE_USER")) {
				itr.remove();
			}
		}
		
		if (users.isEmpty()) {
			throw new UsernameNotFoundException("User Not found..");
		}
        return users;
	}
	

}
