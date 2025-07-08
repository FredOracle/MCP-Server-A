package com.example.mcpserver.repository;

import com.example.mcpserver.entity.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DistrictRepository extends JpaRepository<District, Integer> {


    Optional<District> findByName(String name);

    Optional<District> findByCode(String code);

    Optional<District> findByInitials(String initials);

    Optional<District> findByPinyin(String pinyin);
}


