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
@Document(collection = "businessLocations") // MongoDB collection name
public class BusinessLocationDetails {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Id
    private String id;
    private BusinessLocationInfo locationInfo;
    private List<BusinessType> mainBusinessType;
    private List<BusinessType> secondaryBusinessTypes;
    private BusinessLocationAddress locationAddress;
    private BusinessLocationBillingDetails locationBillingDetails;
    private List<BusinessLocationTiming> locationTimings;

    public BusinessLocationAddress getLocationAddress() {
        return locationAddress;
    }
}