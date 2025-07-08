package com.example.mcpserver.repository;

import com.example.mcpserver.entity.ChinaArea;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChinaAreaRepository extends JpaRepository<ChinaArea, Integer> {

  Optional<ChinaArea> findByInitials(String initials);

  Optional<ChinaArea> findByCode(String code);

  Optional<ChinaArea> findByPinyin(String pinyin);
}
