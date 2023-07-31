package com.hainguyen.demospring.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "class_user")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClassUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private Class aClass;
}
