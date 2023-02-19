package com.nascon.server.unit;

import com.nascon.server.model.Customer;
import com.nascon.server.model.Invoice;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CustomerUnitTest {

    private static Customer customer;
    @BeforeAll
    static void setup() {
        List<Invoice> invoices = new ArrayList<>();
        customer = new Customer(1L,"name",invoices);
    }
    @Test
    void CustomerName(){
        assertEquals("name",customer.getName());
    }

    @Test
    void CustomerId(){
        assertEquals(1L,customer.getId());
    }




}
