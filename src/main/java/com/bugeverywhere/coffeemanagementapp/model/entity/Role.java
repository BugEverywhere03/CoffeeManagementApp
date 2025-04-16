package com.bugeverywhere.coffeemanagementapp.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    private int roleID;
    private String roleName;
    private String roleDescription;
}
