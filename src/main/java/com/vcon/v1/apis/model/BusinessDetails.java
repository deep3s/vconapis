package com.vcon.v1.apis.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "businesses") // MongoDB collection name
public class BusinessDetails {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Id
    private String id;
    private String businessName;
    private String businessOwner;
    private String businessEmail;
    private String businessPhone;
    private String note;
    private String facebookLink;
    private String instaLink;
    private String twitterLink;
    private String websiteLink;
    private String createdDate;
    private String modifiedDate;
}