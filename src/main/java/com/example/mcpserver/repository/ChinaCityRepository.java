package com.example.mcpserver.repository;

import com.example.mcpserver.entity.ChinaCity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChinaCityRepository extends JpaRepository<ChinaCity, String> {

  ChinaCity findByCity(String name);
}
