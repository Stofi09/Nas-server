package com.nascon.server.unit;


import com.nascon.server.model.Customer;
import com.nascon.server.model.Invoice;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class InvoiceUnitTest {

    private static Invoice invoice;
    @BeforeAll
    static void setup() {
        invoice = new Invoice(2L,2,"name");
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
        assertEquals("name",invoice.getCustomer());
    }
}
