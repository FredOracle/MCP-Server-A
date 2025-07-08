package com.example.mcpserver.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "city_location")
public class CityLocation implements Serializable {

    @Id
    private Integer id;
    private String cityName;
    private String code;
    private Double latitude;
    private Double longitude;

}
