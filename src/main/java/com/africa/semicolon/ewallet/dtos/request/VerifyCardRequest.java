package com.africa.semicolon.ewallet.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class VerifyCardRequest {

    private String cardNumber;
    private String cardName;
    private String expiryDate;
    private String cvv;
}
