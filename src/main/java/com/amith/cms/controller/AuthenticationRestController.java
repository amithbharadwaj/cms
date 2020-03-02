package com.amith.cms.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.amith.cms.exception.ChannelNotFoundException;
import com.amith.cms.exception.UserNameExistsException;
import com.amith.cms.models.AuthenticationRequest;
import com.amith.cms.models.AuthenticationResponse;
import com.amith.cms.models.Channel;
import com.amith.cms.models.User;
import com.amith.cms.service.JwtUtil;
import com.amith.cms.service.MyUserDetailsService;

@RestController
public class AuthenticationRestController {
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;

	@Autowired
	private MyUserDetailsService userDetailsService;
	
	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(
			@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(
							authenticationRequest.getUsername(), 
							authenticationRequest.getPassword())
			);
		}
		catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}


		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String jwt = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
	
	@PostMapping("/register")
	public User addUser(@RequestBody User user) {
		Optional<User> optionalUser = userDetailsService.userRepository.findByUsername(user.getUsername());
		if (optionalUser.isPresent())
			throw new UserNameExistsException("UserName already taken, Please choose some other username");
		
		return userDetailsService.registerUser(user);
	}
	
}
