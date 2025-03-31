package com.vcon.v1.apis.service;

import com.vcon.v1.apis.entity.PackageEntity;
import com.vcon.v1.apis.entity.ServiceEntity;
import com.vcon.v1.apis.repository.PackageRepository;
import com.vcon.v1.apis.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PackageService {

    @Autowired
    private PackageRepository packageRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    public List<PackageEntity> getAllPackages() {
        return packageRepository.findAll();
    }

    public Optional<PackageEntity> getPackageById(Long id) {
        return packageRepository.findById(id);
    }

    public PackageEntity createPackage(PackageEntity packageEntity) {
        return packageRepository.save(packageEntity);
    }

    public PackageEntity updatePackage(Long id, PackageEntity packageDetails) {
        return packageRepository.findById(id).map(pkg -> {
            pkg.setName(packageDetails.getName());
            pkg.setDescription(packageDetails.getDescription());
            pkg.setPrice(packageDetails.getPrice());
            return packageRepository.save(pkg);
        }).orElseThrow(() -> new RuntimeException("Package not found"));
    }

    public void deletePackage(Long id) {
        packageRepository.deleteById(id);
    }

    public PackageEntity addServicesToPackage(Long packageId, Set<Long> serviceIds) {
        PackageEntity packageEntity = packageRepository.findById(packageId)
                .orElseThrow(() -> new RuntimeException("Package not found"));

        Set<ServiceEntity> services = serviceRepository.findAllById(serviceIds).stream().collect(java.util.stream.Collectors.toSet());

        packageEntity.setServices(services);
        return packageRepository.save(packageEntity);
    }
}
