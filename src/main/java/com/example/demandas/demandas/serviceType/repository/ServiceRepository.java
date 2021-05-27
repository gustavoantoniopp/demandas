package com.example.demandas.demandas.serviceType.repository;

import com.example.demandas.demandas.serviceType.model.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ServiceRepository extends JpaRepository<ServiceType, Long> {
    Optional<ServiceType> findByTypeContaining(String type);
}
