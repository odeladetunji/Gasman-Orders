package com.models;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Payment {

    public Long id;

    @JsonProperty("ccv")
    public int ccv;

    @JsonProperty("card_number")
    public Long cardNumber;

    @JsonProperty("pin")
    public int pin;


}
