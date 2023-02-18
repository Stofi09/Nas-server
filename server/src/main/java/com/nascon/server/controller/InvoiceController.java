package com.nascon.server.controller;

import com.nascon.server.dto.InvoiceRequest;
import com.nascon.server.dto.InvoiceResponse;
import com.nascon.server.service.InvoiceService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order")
public class InvoiceController {

    @RequestMapping("/test")
    public String testController() {
        return "sikerult";
    }
    private final InvoiceService service;

    public InvoiceController(InvoiceService service) {
        this.service = service;
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public String createOrder(@RequestBody InvoiceRequest invoiceRequest){
        service.createOrder(invoiceRequest);
        return "orderRequest.toString();";
    }

    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<InvoiceResponse> getAllOrders(){
        return service.findAll();
    }
}
