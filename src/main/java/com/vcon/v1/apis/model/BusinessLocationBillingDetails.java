package com.vcon.v1.apis.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessLocationBillingDetails {
    private String businessLocName;
    private String locContactLink;
    private String locEmailLink;
    private String address;
    private String city;
    private String state;
    private String postCode;

    // Getters and Setters
}
