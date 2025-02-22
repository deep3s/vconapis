package com.vcon.v1.apis.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessLocationAddress {
    private String address;
    private String district;
    private String city;
    private String subDivision;
    private String state;
    private String postCode;
    private String country;
    private String description;

    // Getters and Setters
}
