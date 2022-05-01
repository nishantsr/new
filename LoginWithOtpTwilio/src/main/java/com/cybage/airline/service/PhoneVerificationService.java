package com.cybage.airline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.airline.entity.VerificationResult;
import com.cybage.airline.properties.TwilioProperties;
import com.twilio.exception.ApiException;
import com.twilio.rest.verify.v2.service.Verification;
import com.twilio.rest.verify.v2.service.VerificationCheck;



@Service
public class PhoneVerificationService {

	private final TwilioProperties twilioproperties;

	@Autowired
	public PhoneVerificationService(TwilioProperties twilioProperties) {
		this.twilioproperties=twilioProperties;
	}
	
	
	//method to send otp
    public VerificationResult startVerification(String phone) {
        try {
            Verification verification = Verification.creator(twilioproperties.getServiceId(), phone, "sms").create();
            if("approved".equals(verification.getStatus())|| "pending".equals(verification.getStatus())) {
			return new VerificationResult(verification.getSid());
			}
        } catch (ApiException exception) {
            return new VerificationResult(new String[] {exception.getMessage()});
        }
        return null;
    }

    //method to verify the otp
    public VerificationResult checkverification(String phone, String code) {
        try {
            VerificationCheck verification = VerificationCheck.creator(twilioproperties.getServiceId(), code).setTo(phone).create();
            if("approved".equals(verification.getStatus())) {
                return new VerificationResult(verification.getSid());
            }
            return new VerificationResult(new String[]{"Invalid code."});
        } catch (ApiException exception) {
            return new VerificationResult(new String[]{exception.getMessage()});
        }
    }
	
}
