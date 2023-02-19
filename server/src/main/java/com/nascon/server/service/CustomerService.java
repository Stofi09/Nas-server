package com.nascon.server.service;

import com.nascon.server.dto.CustomerRequest;
import com.nascon.server.dto.CustomerResponse;
import com.nascon.server.model.Customer;
import com.nascon.server.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CustomerService {
    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }
    public void createProduct(CustomerRequest request) {
        Customer customer = Customer.builder()
                .name(request.getName())
                .build();
        repository.save(customer);
        log.info("Product is save: " + customer.toString());
    }

    public List<CustomerResponse> findAll() {
        List<Customer> customers = repository.findAll();
        return customers.stream().map(this:: mapToProductResponse).toList();
    }

    private CustomerResponse mapToProductResponse(Customer customer) {
        return CustomerResponse.builder()
                .Id(customer.getId())
                .name(customer.getName())
                .build();
    }
    public Customer getCustomerById(Long Id){
        return repository.getCustomerById(Id);
    }
}
