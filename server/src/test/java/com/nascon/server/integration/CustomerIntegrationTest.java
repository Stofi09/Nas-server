package com.nascon.server.integration;

import com.nascon.server.dto.CustomerRequest;
import com.nascon.server.dto.CustomerResponse;
import com.nascon.server.model.Customer;
import com.nascon.server.repository.CustomerRepository;
import com.nascon.server.service.CustomerService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import java.net.URL;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerIntegrationTest {
    // bind the above RANDOM_PORT
    @LocalServerPort
    private int port;

    @Autowired
     TestRestTemplate restTemplate;


    @Test
    public void CustomerController() throws Exception {
        CustomerRequest request = new CustomerRequest("name");

        ResponseEntity<String> postResponse = restTemplate.postForEntity(new URL("http://localhost:" + port + "/api/v1/customer/").toURI(),request,String.class);
        assertEquals("201 CREATED", postResponse.getStatusCode().toString());

        ResponseEntity<List> response = restTemplate.getForEntity(new URL("http://localhost:" + port + "/api/v1/customer/getAll").toString(), List.class);
        assertEquals(1, response.getBody().size());
    }



}
