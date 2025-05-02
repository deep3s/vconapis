package com.vcon.v1.apis.service;

import com.vcon.v1.apis.entity.Location;
import java.util.List;
import java.util.Optional;

public interface LocationService {
    List<Location> getAllLocations();
    Optional<Location> getLocationById(Long id);
    Location createLocation(Location location);
    Location updateLocation(Long id, Location location);
    void deleteLocation(Long id);
    List<Location> getLocationsByBusinessId(Long businessId);
}

