package com.springdemo.rest;

import com.springdemo.entity.Customer;
import com.springdemo.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class CustomerRestController {


    //need to inject a customer dao
    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> getCustomers(){

        log.info("{}",customerService.getCustomers());

        return customerService.getCustomers();
    }

    @GetMapping("/customers/{customerId}")
    public Customer getCustomer(@PathVariable int customerId){

        Customer customerById = customerService.getCustomer(customerId);

        if(customerById == null){
            throw new RuntimeException("CustomerId not Found "+ customerId);
        }

        return customerById;
    }


    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer theCustomer){

        //To make sure v r inserting
        theCustomer.setId(0);

        customerService.saveCustomer(theCustomer);

        return theCustomer;
    }

    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer theCustomer){

        customerService.saveCustomer(theCustomer);

        return theCustomer;
    }

    @DeleteMapping("/customers/{customerId}")
    public String updateCustomer(@PathVariable int customerId){

        Customer theCustomer = customerService.getCustomer(customerId);

        if(theCustomer==null){
            throw new CustomerNotFoundException("CustomerId Not Found: "+ customerId);
        }


        customerService.deleteCustomer(customerId);

        return "Deleted Customer wit Id: "+ customerId;
    }


}
