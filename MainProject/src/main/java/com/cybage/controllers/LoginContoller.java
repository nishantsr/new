package com.cybage.controllers;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cybage.models.Users;

@RestController
@CrossOrigin("*")
public class LoginContoller {

		@Autowired
		private RestTemplate restTemplate;
		
		@PostMapping("/login")
		public String login(@RequestBody Users users)
		{
			String URL= "http://localhost:8080/login";
			HttpHeaders headers= new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			HttpEntity<Users> entity= new HttpEntity<>(users, headers);
			return restTemplate.exchange(URL, HttpMethod.POST, entity, String.class).getBody();
		}
}
