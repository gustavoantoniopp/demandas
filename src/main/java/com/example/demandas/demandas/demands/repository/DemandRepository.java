package com.example.demandas.demandas.demands.repository;

import com.example.demandas.demandas.demands.model.Demand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DemandRepository extends JpaRepository<Demand, Long> {
    Optional<Demand> findByObjetoContaining(String objeto);
}

