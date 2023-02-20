package com.nascon.server.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;



@Builder
@Data
@Entity
public class Item {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private String name;
    private int amount;
    private boolean isAvailable;
    @ManyToOne
    private Invoice invoice;

    public Item(Long id, String name, int amount, boolean isAvailable, Invoice invoice) {
        Id = id;
        this.name = name;
        this.amount = amount;
        this.isAvailable = isAvailable;
        this.invoice = invoice;
    }

    public Item(Long id, String name, int amount, boolean isAvailable) {
        Id = id;
        this.name = name;
        this.amount = amount;
        this.isAvailable = isAvailable;
    }
    public Item(){}

    public void addInvoice(Invoice invoice){
        this.invoice = invoice;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }


}
