package com.bugeverywhere.coffeemanagementapp.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Invoice {
    private int invoiceID;
    private int customerID;
    private int tableID;
    private String customerRole;
    private String paymentMethod;
    private double totalPrice;
    private LocalDateTime invoiceDate;
    private int discount;
    private double finalPrice;
}
