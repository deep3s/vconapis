package com.vcon.v1.apis.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalonVenues {
    private String images;
    private String name;
    private List<SalonReview> reviews;
    private List<String> locations;
}
