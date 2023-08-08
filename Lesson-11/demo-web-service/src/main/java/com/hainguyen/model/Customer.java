package com.hainguyen.model;

import com.hainguyen.dto.CustomerDto;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "customers")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstname;
    private String lastname;
//    private String phone;

//    public void loadFromDto(CustomerDto dto){
//        this.id = dto.getId();
//        this.firstname = dto.getFirstname();
//        this.lastname = dto.getLastname();
//    }
}
