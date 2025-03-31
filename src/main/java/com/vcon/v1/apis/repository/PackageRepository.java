package com.vcon.v1.apis.repository;

import com.vcon.v1.apis.entity.PackageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PackageRepository extends JpaRepository<PackageEntity, Long> {
}
