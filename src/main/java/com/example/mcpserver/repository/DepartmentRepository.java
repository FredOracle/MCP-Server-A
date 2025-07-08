package com.example.mcpserver.repository;

import com.example.mcpserver.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, String> {
    String findByName(String name);
}