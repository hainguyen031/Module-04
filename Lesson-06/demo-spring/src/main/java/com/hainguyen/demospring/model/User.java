package com.hainguyen.demospring.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Address> addressList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<ClassUser> classUsers;

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    private StudentId studentId;
}
