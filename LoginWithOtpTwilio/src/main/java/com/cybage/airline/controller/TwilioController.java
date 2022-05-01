package com.cybage.airline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cybage.airline.entity.Otp;
import com.cybage.airline.entity.VerificationResult;
import com.cybage.airline.service.PhoneVerificationService;

@RestController
@CrossOrigin("http://localhost:4200")
public class TwilioController {
	@Autowired
	PhoneVerificationService phoneSmsService;
	    
	@RequestMapping("/index")
	public ResponseEntity<?> homepage()
	{
		return ResponseEntity.ok("Index");
	}
	
	@PostMapping("/sendotp")
	public ResponseEntity<?> sendotp(@RequestBody String phone)
	{
	    VerificationResult result=phoneSmsService.startVerification(phone);
	    if(result.isValid())
	    {
	    	return new ResponseEntity<>(false,HttpStatus.OK);
	    }
		return new ResponseEntity<>(true,HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/verifyotp")
	public ResponseEntity<?> sendotp(@RequestBody Otp credential)
	{
	    VerificationResult result=phoneSmsService.checkverification(credential.getContact(),credential.getOtp());
	    if(result.isValid())
	    { 
	    	return new ResponseEntity<>(true,HttpStatus.OK);
	    }
		return new ResponseEntity<>(false,HttpStatus.BAD_REQUEST);
	}
	
	
}