package com.vcon.v1.apis.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessLocationTiming {
    private String name;
    private boolean open;
    private String openingTime;
    private String closingTime;

    // Getters and Setters
}
