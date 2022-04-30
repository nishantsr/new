package com.cybage.controllers;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cybage.models.Feedback;
import com.cybage.models.Users;

@RestController
public class FeedbackController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping("/feedback/{id}")
	public String feedback(@PathVariable int id)
	{
		String URL= "http://localhost:9090/getFeedback/{id}";
		HttpHeaders headers= new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Users> entity= new HttpEntity<>( headers);
		return restTemplate.exchange(URL, HttpMethod.POST, entity, String.class).getBody();
	}
}
