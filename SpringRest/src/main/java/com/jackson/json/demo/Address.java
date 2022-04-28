package com.jackson.json.demo;

import lombok.Data;

public @Data class Address {

    private String street;
    private String city;
    private String state;
    private String zip;
    private String country;

    public Address() {}

}
