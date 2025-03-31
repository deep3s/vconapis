package com.vcon.v1.apis.repository;

import com.vcon.v1.apis.entity.ServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ServiceRepository extends JpaRepository<ServiceEntity, Long> {
    @Query(nativeQuery = true, value = ":sqlQuery")
    List<ServiceEntity> findByCategoryId(String sqlQuery);
}

