package com.nascon.server.controller;

import com.nascon.server.dto.CustomerRequest;
import com.nascon.server.dto.CustomerResponse;
import com.nascon.server.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void createCustomer(@RequestBody CustomerRequest customerRequest){
        service.createProduct(customerRequest);
    }

    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerResponse> getAllProducts(){
        return service.findAll();
    }

}
