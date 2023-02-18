package com.nascon.server.integration;

import com.nascon.server.dto.CustomerRequest;
import com.nascon.server.dto.ItemRequest;
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
public class ItemIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    TestRestTemplate restTemplate;
    private static ItemRequest request;
    @BeforeAll
    static void setup(){
        request= new ItemRequest("name",2,true);
    }
    @Test
    public void ItemController() throws Exception {
        ResponseEntity<String> postResponse = restTemplate.postForEntity(new URL("http://localhost:" + port + "/api/v1/item/").toURI(),request,String.class);
        assertEquals("name", postResponse.getBody());

        ResponseEntity<List> response = restTemplate.getForEntity(new URL("http://localhost:" + port + "/api/v1/item/getAll").toString(), List.class);
        assertEquals(1, response.getBody().size());
    }



}
