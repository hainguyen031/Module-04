package com.hainguyen.service;

import com.hainguyen.dto.CustomerDto;
import com.hainguyen.model.Customer;
import com.hainguyen.repository.ICustomerRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository iCustomerRepository;


    @Autowired
    private final ModelMapper mapper;

    public CustomerService(ModelMapper mapper) {
        this.mapper = mapper;
    }


    @Override
    public List<CustomerDto> getAllCustomers() {
        CustomerDto customerDto = new CustomerDto();
        List<Customer> customerList = iCustomerRepository.findAll();
        List<CustomerDto> customerDtoList = mapper.map(customerList, new TypeToken<List<CustomerDto>>(){} .getType());
        return customerDtoList;
    }

    @Override
    public CustomerDto saveCustomer(CustomerDto customerDto) {
        Customer customer = mapper.map(customerDto, Customer.class);
        Customer customerResult = iCustomerRepository.save(customer);
        return mapper.map(customerResult, CustomerDto.class);
    }

    @Override
    public void deleteCustomer(Long id) {
        iCustomerRepository.deleteById(id);
    }

    @Override
    public CustomerDto getCustomerById(Long id) {
        Customer customer = iCustomerRepository.findById(id).get();
        return mapper.map(customer, CustomerDto.class);
    }
}
