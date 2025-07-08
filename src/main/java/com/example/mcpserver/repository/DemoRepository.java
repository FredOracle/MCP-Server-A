package com.example.mcpserver.repository;

import com.example.mcpserver.entity.Demo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemoRepository extends JpaRepository<Demo, String> {
}
