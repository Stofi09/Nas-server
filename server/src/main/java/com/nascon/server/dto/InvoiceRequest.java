package com.nascon.server.dto;

import com.nascon.server.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceRequest {
    private int orderNumber;
    private Long customerId;
}
