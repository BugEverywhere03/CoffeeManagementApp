package com.bugeverywhere.app.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Table {
    private int tableID;
    private String tableName;
    private String tablePosition;
    List<Product> products;
}
