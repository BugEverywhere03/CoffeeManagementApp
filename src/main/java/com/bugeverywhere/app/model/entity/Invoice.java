package com.bugeverywhere.app.model.entity;

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
    private boolean inStore;
    private LocalDateTime invoiceDate;
}
