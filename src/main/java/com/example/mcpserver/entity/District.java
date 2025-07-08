package com.example.mcpserver.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "district")
@Builder
public class District implements Serializable {

  // 标识主键
  @Id
  private Integer id;

  // 父级ID
  private Integer parentId;

  // 名称
  private String name;

  // 编码
  private String code;

  // 初始
  private String initial;

  // 初始字母
  private String initials;

  // 后缀
  private String suffix;

  // 拼音
  private String pinyin;

  // 级别
  private Integer level;

  // 邮编
  private String zip;

  // 简称
  private String shortName;

  // 合并名称
  private String mergeName;

  // 纬度
  private Double latitude;

  // 经度
  private Double longitude;

}
