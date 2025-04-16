package com.bugeverywhere.coffeemanagementapp.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Table {
    private int tableID;
    private String tableName;
    private String tablePosition;
}
