package com.springdemo.rest;

import lombok.Data;

public @Data class CustomerErrorResponse {
    private int status;
    private String message;
    private long timeStamp;

    public CustomerErrorResponse(int status, String message, long timeStamp) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public CustomerErrorResponse(){}

}
