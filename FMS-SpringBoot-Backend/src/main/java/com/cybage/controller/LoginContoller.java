package com.cybage.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cybage.model.Users;


import com.cybage.model.Users;
import com.cybage.util.JwtUtil;

@RestController
@CrossOrigin("*")
public class LoginContoller {

		@Autowired
		private RestTemplate restTemplate;
		
		@Autowired
		private JwtUtil jwtUtil;
		
		@Autowired
		private AuthenticationManager authenticationmanager;
		
		@GetMapping("/welcome")
		public String welcome()
		{
			return "Hello World!!!";
		}
	
		@PostMapping("/login")
		public String login(@RequestBody Users users)
		{
			String URL= "http://localhost:8080/login";
			HttpHeaders headers= new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			HttpEntity<Users> entity= new HttpEntity<>(users, headers);
			return restTemplate.exchange(URL, HttpMethod.POST, entity, String.class).getBody();
		}
		
		@PostMapping("/authenticate")
		public String generateToken(@RequestBody Users authRequest) throws Exception{
			try {
				System.out.println("authenticate ");
				System.out.println(authRequest.getEmailId());
				System.out.println(authRequest.getPassword());
				authenticationmanager.authenticate(
						new UsernamePasswordAuthenticationToken(authRequest.getEmailId(), authRequest.getPassword())
						);	
			}catch(Exception ex) {
				throw new Exception("Invalid Username or password");
			}
			return jwtUtil.generateToken(authRequest.getEmailId());
		}
}
