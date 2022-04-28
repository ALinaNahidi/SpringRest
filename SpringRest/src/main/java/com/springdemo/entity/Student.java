package com.springdemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jackson.json.demo.Address;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
public @Data class Student {

//    private int id;
    private String firstName;
    private String lastName;

//    private boolean active;

//    private Address address;

//    private String[] languages;
    public Student() {
    }

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }



}
