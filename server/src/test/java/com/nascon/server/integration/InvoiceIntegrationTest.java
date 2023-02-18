package com.nascon.server.integration;

import com.nascon.server.dto.InvoiceRequest;
import com.nascon.server.dto.ItemRequest;
import com.nascon.server.model.Invoice;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import java.net.URL;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class InvoiceIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    TestRestTemplate restTemplate;
    private static InvoiceRequest request;
    @BeforeAll
    static void setup(){
        request= new InvoiceRequest(2,"customer");
    }
    @Test
    public void InvoiceController() throws Exception {
        ResponseEntity<String> postResponse = restTemplate.postForEntity(new URL("http://localhost:" + port + "/api/v1/invoice/").toURI(),request,String.class);
        assertEquals("2", postResponse.getBody().toString());

        ResponseEntity<List> response = restTemplate.getForEntity(new URL("http://localhost:" + port + "/api/v1/invoice/getAll").toString(), List.class);
        assertEquals(1, response.getBody().size());
    }

}
