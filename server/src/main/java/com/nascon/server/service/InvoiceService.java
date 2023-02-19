package com.nascon.server.service;

import com.nascon.server.dto.InvoiceRequest;
import com.nascon.server.dto.InvoiceResponse;
import com.nascon.server.model.Customer;
import com.nascon.server.model.Invoice;
import com.nascon.server.repository.InvoiceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class InvoiceService {

    private final InvoiceRepository repository;

    @Autowired
    private CustomerService customerService;

    public InvoiceService(InvoiceRepository repository) {
        this.repository = repository;
    }
    public void createOrder(InvoiceRequest request) {
        Customer customer = customerService.getCustomerById(request.getCustomerId());
        Invoice invoice = Invoice.builder()
                .orderNumber(request.getOrderNumber())
                .customer(customer)
                .build();
        repository.save(invoice);
        log.info("Order is save: " + invoice.toString());
    }

    public List<InvoiceResponse> findAll() {
        List<Invoice> invoices = repository.findAll();
        return invoices.stream().map(this:: mapToOrderResponse).toList();
    }

    private InvoiceResponse mapToOrderResponse(Invoice invoice) {
        return InvoiceResponse.builder()
                .Id(invoice.getId())
                .orderNumber(invoice.getOrderNumber())
                .customer(invoice.getCustomer())
                .build();
    }
}
