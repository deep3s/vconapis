package com.vcon.v1.apis.service;
import com.vcon.v1.apis.config.QueryConfig;
import com.vcon.v1.apis.entity.ServiceEntity;
import com.vcon.v1.apis.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceService {
    private final QueryConfig queryConfig;

    public ServiceService(QueryConfig queryConfig) {
        this.queryConfig = queryConfig;
    }

    @Autowired
    private ServiceRepository serviceRepository;

    public List<ServiceEntity> getAllServices() {
        return serviceRepository.findAll();
    }

    public Optional<ServiceEntity> getServiceById(Long id) {
        return serviceRepository.findById(id);
    }

    public ServiceEntity createService(ServiceEntity serviceEntity) {
        return serviceRepository.save(serviceEntity);
    }

    public ServiceEntity updateService(Long id, ServiceEntity serviceDetails) {
        return serviceRepository.findById(id).map(service -> {
            service.setName(serviceDetails.getName());
            service.setDescription(serviceDetails.getDescription());
            service.setCategory(serviceDetails.getCategory());
            return serviceRepository.save(service);
        }).orElseThrow(() -> new RuntimeException("Service not found"));
    }

    public void deleteService(Long id) {
        serviceRepository.deleteById(id);
    }

    public List<ServiceEntity> getAllServicesForCategory(Long categoryId) {
        String sqlQuery = queryConfig.getQueryMap().get("getAllServicesForCategory");

        return serviceRepository.findByCategoryId(sqlQuery);
    }
}
