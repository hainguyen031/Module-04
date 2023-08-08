package com.hainguyen.controller;

import com.hainguyen.dto.CustomerDto;
import com.hainguyen.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;

    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAll() {
        List<CustomerDto> customerDtoList = iCustomerService.getAllCustomers();
        return new ResponseEntity<>(customerDtoList, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable Long id) {
        CustomerDto customerDto = iCustomerService.getCustomerById(id);
        return ResponseEntity.ok().body(customerDto);
    }
    @PostMapping
    public ResponseEntity<CustomerDto> saveCustomer(@RequestBody CustomerDto customerDto) {
        return new ResponseEntity<>(iCustomerService.saveCustomer(customerDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CustomerDto> deleteCustomer(@PathVariable Long id) {
        CustomerDto customerDto = iCustomerService.getCustomerById(id);
        if(customerDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iCustomerService.deleteCustomer(id);
        return new ResponseEntity<>(customerDto, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDto> updateCustomer(@PathVariable Long id, @RequestBody CustomerDto customerDto) {
        CustomerDto customerDtoNew = iCustomerService.getCustomerById(id);
        if(customerDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        customerDto.setId(customerDtoNew.getId());
        return new ResponseEntity<>(iCustomerService.saveCustomer(customerDto), HttpStatus.OK);
    }
}
