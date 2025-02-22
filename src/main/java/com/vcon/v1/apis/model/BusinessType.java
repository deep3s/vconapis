package com.vcon.v1.apis.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessType {
    private String typeId;
    private String name;
    private String icon;

    // Getters and Setters
}
