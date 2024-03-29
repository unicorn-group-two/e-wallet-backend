package com.africa.semicolon.ewallet.services.registration;


import com.africa.semicolon.ewallet.dtos.request.RegistrationRequest;
import com.africa.semicolon.ewallet.dtos.request.SendOTPRequest;
import com.africa.semicolon.ewallet.dtos.request.VerifyOTPRequest;
import jakarta.mail.MessagingException;

public interface RegistrationService {
    String register(RegistrationRequest registrationRequest) throws Exception;

    String verifyOTP(VerifyOTPRequest verifyOTPRequest);

    String resendVerificationOTP(SendOTPRequest sendOTPRequest) throws MessagingException;


}
