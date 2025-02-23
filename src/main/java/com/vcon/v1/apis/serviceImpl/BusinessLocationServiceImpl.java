package com.vcon.v1.apis.serviceImpl;

import com.vcon.v1.apis.daoImpl.BusinessLocationRepository;
import com.vcon.v1.apis.model.BusinessLocationDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BusinessLocationServiceImpl {

    @Autowired
    private BusinessLocationRepository businessLocationRepository;

    // Get a Business Details by ID
    public Optional<BusinessLocationDetails> getBusinessLocationDetailsById(String id) {
        return businessLocationRepository.findById(id);
    }
    public List<BusinessLocationDetails> getAllBusinessLocations() {
        return businessLocationRepository.findAll();
    }

    // Create a new business
    public BusinessLocationDetails createBusinessLocation(BusinessLocationDetails business) {
        return businessLocationRepository.save(business);
    }

    // Update an existing business
    public BusinessLocationDetails updateBusinessLocation(String id, BusinessLocationDetails business) {
        if (businessLocationRepository.existsById(id)) {
            business.setId(id);
            return businessLocationRepository.save(business);
        }
        return null;
    }

    // Delete a business by ID
    public boolean deleteBusinessLocation(String id) {
        if (businessLocationRepository.existsById(id)) {
            businessLocationRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<BusinessLocationDetails> searchNearbyLocations(
            double latitude, double longitude, double radius) {
        List<BusinessLocationDetails> locations = businessLocationRepository.findAll();
        List<BusinessLocationDetails> nearbyLocations = new ArrayList<>();

        for (BusinessLocationDetails location : locations) {
            double distance = haversine(latitude, longitude,
                    location.getLocationAddress().getLat(),
                    location.getLocationAddress().getLng());

            if (distance <= radius) {
                nearbyLocations.add(location);
            }
        }

        return nearbyLocations;
    }

    private double haversine(double lat1, double lon1, double lat2, double lon2) {
        final int R = 6371; // Radius of the earth in km
        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c; // convert to kilometers
        return distance;
    }

}
