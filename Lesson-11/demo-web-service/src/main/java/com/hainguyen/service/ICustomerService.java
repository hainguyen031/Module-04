package com.hainguyen.service;

import com.hainguyen.dto.CustomerDto;
import com.hainguyen.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<CustomerDto> getAllCustomers();

    CustomerDto saveCustomer(CustomerDto customerDto);

    void deleteCustomer(Long id);

    CustomerDto getCustomerById(Long id);
}
