package com.hainguyen.demospring.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "student_id")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentId {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String MSSV;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
