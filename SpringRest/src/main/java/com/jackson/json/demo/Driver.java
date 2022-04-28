package com.jackson.json.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.Arrays;

@Slf4j
public class Driver {
    public static void main(String[] args) {
        try{

            ObjectMapper mapper = new ObjectMapper();

            Student student = mapper.readValue(new File("data/sample-full.json"),Student.class);

            log.info("First Name: "+student.getFirstName());
            log.info("Last Name: "+student.getLastName());
            log.info("languages: "+ Arrays.toString(student.getLanguages()));
            log.info("{}",student);


        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
