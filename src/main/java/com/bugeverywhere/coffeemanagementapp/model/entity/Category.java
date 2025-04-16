package com.bugeverywhere.coffeemanagementapp.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    private int categoryID;
    private String categoryName;
}
