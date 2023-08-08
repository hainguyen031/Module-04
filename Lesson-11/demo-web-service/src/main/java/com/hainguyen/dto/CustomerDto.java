package com.hainguyen.dto;

import com.hainguyen.model.Customer;
import lombok.*;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerDto {
    private Long id;
    private String firstname;
    private String lastname;
//    private String phone;

//    public void loadFromEntity(Customer entity){
//        this.id = entity.getId();
//        this.firstname = entity.getFirstname();
//        this.lastname = entity.getLastname();
//    }
}
