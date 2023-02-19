package com.nascon.server.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String name;
    @JsonBackReference
    @OneToMany(mappedBy = "customer")
    private List<Invoice> invoiceList;

    public Customer(Long id, String name, List<Invoice> invoiceList) {
        Id = id;
        this.name = name;
        this.invoiceList = invoiceList;
    }

    public Customer(){};
    public Long getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Invoice> getInvoiceList() {
        return invoiceList;
    }

    public void setInvoiceList(List<Invoice> invoiceList) {
        this.invoiceList = invoiceList;
    }
}
