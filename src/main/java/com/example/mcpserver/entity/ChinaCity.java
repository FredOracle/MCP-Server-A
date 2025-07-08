package com.example.mcpserver.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "china_city")
public class ChinaCity {

  @Id
  @Column(name = "id", length = 50)
  private String id;

  @Column(name = "province", length = 50)
  private String province;

  @Column(name = "city", length = 50)
  private String city;

  @Column(name = "pinyin", length = 50)
  private String pinyin;

  @Column(name = "initials", length = 50)
  private String initials;

}