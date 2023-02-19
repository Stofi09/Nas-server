package com.nascon.server.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Entity
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private int orderNumber;
    @ManyToOne
    private Customer customer;

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
}
