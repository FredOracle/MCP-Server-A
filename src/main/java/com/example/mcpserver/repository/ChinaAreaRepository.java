package com.example.mcpserver.repository;

import com.example.mcpserver.entity.ChinaArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChinaAreaRepository extends JpaRepository<ChinaArea, Integer> {

}
