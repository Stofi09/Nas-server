package com.nascon.server.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Builder;


import java.util.ArrayList;
import java.util.List;

@Builder
@Entity
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private int orderNumber;
    @ManyToOne
    private Customer customer;

    @JsonBackReference
    @OneToMany(mappedBy = "invoice")
    private List<Item> Item;

    public Invoice(Long id, int orderNumber, Customer customer, List<com.nascon.server.model.Item> item) {
        Id = id;
        this.orderNumber = orderNumber;
        this.customer = customer;
        Item = item;
    }

    public Invoice(Long id, int orderNumber, Customer customer) {
        Id = id;
        this.orderNumber = orderNumber;
        this.customer = customer;
    }
    public Invoice(){}

    public Long getId() {
        return Id;
    }


    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Item> getItem() {
        return Item;
    }

    public void setItem(List<Item> item) {
        Item = item;
    }
}
