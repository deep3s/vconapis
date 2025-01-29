package com.vcon.v1.apis.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "salons") // MongoDB collection name
public class SalonDetails {
    @Id
    private String id;
    private String name;
    private List<SalonReview> reviews;
    private String openUntil;
    private List<SalonService> services;
    private List<SalonTeam> team;
    private String about;
    private String additionalInfo;
    private List<SalonTimings> timings;
    private List<SalonVenues> venuesNearBy;
}