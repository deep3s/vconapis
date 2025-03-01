package com.vcon.v1.apis.service;

import com.vcon.v1.apis.entity.Category;
import com.vcon.v1.apis.entity.Service;
import com.vcon.v1.apis.repository.CategoryRepository;
import com.vcon.v1.apis.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class ServicesService {

    @Autowired
    private ServiceRepository serviceRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    // Get all services
    public List<Service> getAllServices() {
        return serviceRepository.findAll();
    }

    // Create new service
    public Service createService(Service service) {
        /*// Ensure category exists before setting it on the service
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new IllegalArgumentException("Category not found"));

        // Set the category on the service object
        service.setCategory(category);*/

        // Save the service to the repository
        return serviceRepository.save(service);
    }

    // Get service by id
    public Optional<Service> getServiceById(Long id) {
        return serviceRepository.findById(id);
    }

    // Update service
    public Service updateService(Long id, Service serviceDetails) {
        Optional<Service> service = serviceRepository.findById(id);
        if (service.isPresent()) {
            service.get().setName(serviceDetails.getName());
            service.get().setDescription(serviceDetails.getDescription());
            service.get().setDuration(serviceDetails.getDuration());
            service.get().setPrice(serviceDetails.getPrice());
            return serviceRepository.save(service.get());
        }
        return null;
    }

    // Delete service
    public void deleteService(Long id) {
        serviceRepository.deleteById(id);
    }

}
