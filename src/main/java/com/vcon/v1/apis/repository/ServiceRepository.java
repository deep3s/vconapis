package com.vcon.v1.apis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vcon.v1.apis.entity.Service;

public interface ServiceRepository extends JpaRepository<Service, Long> {
}
