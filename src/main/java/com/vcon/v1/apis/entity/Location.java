package com.vcon.v1.apis.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Locations")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id")
    private Long locationId;

    @Column(name = "business_id")
    private Long businessId;

    @Column(name = "location_name")
    private String locationName;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "zip_code")
    private String zipCode;

    @Column(name = "contact_phone")
    private String contactPhone;

    @Column(name = "opening_hours")
    private String openingHours;

    @Column(name = "other_location_details")
    private String otherLocationDetails;

    @Column(name = "location_type")
    private String locationType;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "image_urls")
    private String imageUrls; // Store as JSON string

    @Column(name = "primary_image_url")
    private String primaryImageUrl;

    // Constructors, getters, and setters
    public Location() {
    }

    public Location(Long businessId, String locationName, String address, String city, String state, String zipCode, String contactPhone, String openingHours, String otherLocationDetails, String locationType, Double latitude, Double longitude, String imageUrls, String primaryImageUrl) {
        this.businessId = businessId;
        this.locationName = locationName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.contactPhone = contactPhone;
        this.openingHours = openingHours;
        this.otherLocationDetails = otherLocationDetails;
        this.locationType = locationType;
        this.latitude = latitude;
        this.longitude = longitude;
        this.imageUrls = imageUrls;
        this.primaryImageUrl = primaryImageUrl;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public Long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Long businessId) {
        this.businessId = businessId;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
    }

    public String getOtherLocationDetails() {
        return otherLocationDetails;
    }

    public void setOtherLocationDetails(String otherLocationDetails) {
        this.otherLocationDetails = otherLocationDetails;
    }

    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(String imageUrls) {
        this.imageUrls = imageUrls;
    }

    public String getPrimaryImageUrl() {
        return primaryImageUrl;
    }

    public void setPrimaryImageUrl(String primaryImageUrl) {
        this.primaryImageUrl = primaryImageUrl;
    }
}

