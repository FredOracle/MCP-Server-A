package com.example.mcpserver.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "china_area")
public class ChinaArea {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Integer id;

  @Column(name = "pid")
  private Integer pid;

  @Column(name = "shortname", length = 100)
  private String shortname;

  @Column(name = "name", length = 100)
  private String name;

  @Column(name = "mergename")
  private String mergename;

  @Column(name = "level")
  private Byte level;

  @Column(name = "pinyin", length = 100)
  private String pinyin;

  @Column(name = "code", length = 100)
  private String code;

  @Column(name = "zip", length = 100)
  private String zip;

  @Column(name = "first", length = 50)
  private String first;

  @Column(name = "lng", length = 100)
  private String lng;

  @Column(name = "lat", length = 100)
  private String lat;

}