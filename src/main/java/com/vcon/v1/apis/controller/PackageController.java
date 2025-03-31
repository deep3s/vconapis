package com.vcon.v1.apis.controller;

import com.vcon.v1.apis.entity.PackageEntity;
import com.vcon.v1.apis.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/packages")
public class PackageController {

    @Autowired
    private PackageService packageService;

    @GetMapping
    public List<PackageEntity> getAllPackages() {
        return packageService.getAllPackages();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PackageEntity> getPackageById(@PathVariable Long id) {
        Optional<PackageEntity> packageEntity = packageService.getPackageById(id);
        return packageEntity.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public PackageEntity createPackage(@RequestBody PackageEntity packageEntity) {
        return packageService.createPackage(packageEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PackageEntity> updatePackage(@PathVariable Long id, @RequestBody PackageEntity packageDetails) {
        return ResponseEntity.ok(packageService.updatePackage(id, packageDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePackage(@PathVariable Long id) {
        packageService.deletePackage(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{packageId}/services")
    public ResponseEntity<PackageEntity> addServicesToPackage(
            @PathVariable Long packageId,
            @RequestBody Set<Long> serviceIds) {

        PackageEntity updatedPackage = packageService.addServicesToPackage(packageId, serviceIds);
        return ResponseEntity.ok(updatedPackage);
    }
}

