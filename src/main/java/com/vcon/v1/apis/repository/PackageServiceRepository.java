package com.vcon.v1.apis.repository;

import com.vcon.v1.apis.entity.PackageServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PackageServiceRepository extends JpaRepository<PackageServiceEntity, Long> {
}
