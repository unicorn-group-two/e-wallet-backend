package com.africa.semicolon.ewallet.controllers;
import com.africa.semicolon.ewallet.dtos.request.ResetPasswordRequest;
import com.africa.semicolon.ewallet.dtos.request.SendOTPRequest;
import com.africa.semicolon.ewallet.dtos.request.VerifyOTPRequest;
import com.africa.semicolon.ewallet.services.resetpassword.ResetPasswordService;
import com.africa.semicolon.ewallet.utils.ApiResponse;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;

@RestController
@RequestMapping("api/v1/forgot-password")
public class ForgotPasswordController {
    @Autowired
    ResetPasswordService resetPasswordService;
    @PostMapping()
    public ResponseEntity<?> forgotPassword(@RequestBody SendOTPRequest sendOTPRequest,
                                            HttpServletRequest httpServletRequest) throws MessagingException {
        String response = resetPasswordService.emailOTP(sendOTPRequest);
        ApiResponse apiResponse = ApiResponse.builder()
                .timeStamp(ZonedDateTime.now())
                .data(response)
                .path(httpServletRequest.getRequestURI())
                .statusCode(HttpStatus.OK.value())
                .isSuccessful(true)
                .build();

        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PostMapping("/verify-otp")
    public ResponseEntity<?> verifyOTP(@RequestBody VerifyOTPRequest verifyOTPRequest,
                                       HttpServletRequest httpServletRequest){
        String response = resetPasswordService.verifyOTP(verifyOTPRequest);
        ApiResponse apiResponse = ApiResponse.builder()
                .timeStamp(ZonedDateTime.now())
                .data(response)
                .path(httpServletRequest.getRequestURI())
                .statusCode(HttpStatus.OK.value())
                .isSuccessful(true)
                .build();

        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
    @PutMapping("/reset-password/{emailAddress}")
    public ResponseEntity<?> resetPassword(@PathVariable("emailAddress") String emailAddress, ResetPasswordRequest resetPasswordRequest,
                                            HttpServletRequest httpServletRequest){
        String response = resetPasswordService.resetPassword(emailAddress,resetPasswordRequest);
        ApiResponse apiResponse = ApiResponse.builder()
                .timeStamp(ZonedDateTime.now())
                .data(response)
                .path(httpServletRequest.getRequestURI())
                .statusCode(HttpStatus.OK.value())
                .isSuccessful(true)
                .build();

        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
