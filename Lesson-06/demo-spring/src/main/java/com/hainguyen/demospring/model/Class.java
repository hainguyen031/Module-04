package com.hainguyen.demospring.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "class")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(fetch = FetchType.LAZY)
    private List<ClassUser> classUsers;
}
