package com.nascon.server.unit;

import com.nascon.server.model.Customer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CustomerUnitTest {

    private static Customer customer;
    @BeforeAll
    static void setup() {
         customer = new Customer(2L,"name");
    }
    @Test
    void CustomerName(){
        assertEquals("name",customer.getName());
    }

    @Test
    void CustomerId(){
        assertEquals(2L,customer.getId());
    }

}
