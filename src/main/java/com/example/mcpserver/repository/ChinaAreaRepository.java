package com.example.mcpserver.repository;

import com.example.mcpserver.entity.ChinaArea;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChinaAreaRepository extends JpaRepository<ChinaArea, Integer> {

  List<ChinaArea> findByInitials(String initials);

  Optional<ChinaArea> findByZipCode(String code);

  List<ChinaArea> findByPinyin(String pinyin);
}
