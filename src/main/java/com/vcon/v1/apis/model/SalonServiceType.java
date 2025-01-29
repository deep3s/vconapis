package com.vcon.v1.apis.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalonServiceType {
    private String name;
    private String duration;
    private double price;
}
