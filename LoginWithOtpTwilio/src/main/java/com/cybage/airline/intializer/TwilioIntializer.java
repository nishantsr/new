package com.cybage.airline.intializer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.cybage.airline.properties.TwilioProperties;
import com.twilio.Twilio;

@Configuration
public class TwilioIntializer {

	
	private final TwilioProperties twilioProperties;
	
	@Autowired
	public TwilioIntializer(TwilioProperties twilioProperties)
	{
		this.twilioProperties=twilioProperties;
		Twilio.init(twilioProperties.getAccountSid(), twilioProperties.getAuthToken());
		System.out.println("Twilio initialized with account-"+twilioProperties.getAccountSid());
	}
}