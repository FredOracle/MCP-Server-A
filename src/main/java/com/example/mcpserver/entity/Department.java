package com.example.mcpserver.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "department", schema = "demo")
public class Department {
    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "description")
    private String description;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Department parent;

}