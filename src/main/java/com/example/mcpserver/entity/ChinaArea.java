package com.example.mcpserver.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "china_area")
public class ChinaArea {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Integer id;

  @Column(name = "pid")
  private Integer pid;

  @Column(name = "name", length = 100)
  private String name;

  @Column(name = "short_name", length = 100)
  private String shortName;

  @Column(name = "merge_name")
  private String mergeName;

  @Column(name = "level")
  private Byte level;

  @Column(name = "suffix", length = 50)
  private String suffix;

  @Column(name = "pinyin", length = 100)
  private String pinyin;

  @Column(name = "initial", length = 50)
  private String initial;

  @Column(name = "initials", length = 50)
  private String initials;

  @Column(name = "lng", length = 100)
  private String lng;

  @Column(name = "lat", length = 100)
  private String lat;

  @Column(name = "zip_code", length = 100)
  private String zipCode;

  @Column(name = "area_code", length = 100)
  private String areaCode;

  @Column(name = "region_code", length = 50)
  private String regionCode;

}