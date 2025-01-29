package com.vcon.v1.apis.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalonService {
    private String name;
    private List<SalonServiceType> types;

}
