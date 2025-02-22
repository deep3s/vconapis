package com.vcon.v1.apis.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessLocationInfo {
    private String businessLocName;
    private String locContactLink;
    private String locEmailLink;

    // Getters and Setters
}
