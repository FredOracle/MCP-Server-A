package com.example.mcpserver.repository;

import com.example.mcpserver.entity.CityLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CityLocationRepository extends JpaRepository<CityLocation, Integer> {

    Optional<CityLocation> findByCityName(String name);

    Optional<CityLocation> findByCode(String code);
}
