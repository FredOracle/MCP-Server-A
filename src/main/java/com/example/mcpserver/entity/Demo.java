package com.example.mcpserver.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "demo", schema = "demo")
public class Demo {
    @Id
    @Column(name = "id", nullable = false, length = 50)
    private String id;

    @Column(name = "password")
    private String password;

    @Column(name = "user_name")
    private String userName;

    private String message;

}