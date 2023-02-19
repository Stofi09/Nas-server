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
public class InvoiceUnitTest {

    private static Invoice invoice;
    @BeforeAll
    static void setup() {
        List<Invoice> invoices = new ArrayList<>();
        Customer customer = new Customer(1L,"name",invoices);
        invoice = new Invoice(2L,2,customer);
    }

    @Test
    void invoiceNumber(){
        assertEquals(2,invoice.getOrderNumber());
    }
    @Test
    void invoiceId(){
        assertEquals(2L,invoice.getId());
    }
    @Test
    void invoiceCustomer(){
        assertEquals("name",invoice.getCustomer().getName());
    }
}
