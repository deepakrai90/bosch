package com.bosch.demo.api.controllers;

import com.bosch.demo.api.dto.AddressDto;
import com.bosch.demo.api.dto.CustomerDto;
import com.bosch.demo.core.services.CustomerServices;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

/**
 * Created by Deepak Rai on 19/9/20.
 */

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerServices customerServices;

    @ApiOperation(value = "Add's new Customer", notes = "To add a new Customer", response = CustomerDto.class)
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    ResponseEntity<CustomerDto> createCustomer(@Valid @RequestBody CustomerDto CustomerDto) {
        return ResponseEntity.ok(customerServices.save(CustomerDto));
    }

    @ApiOperation(value = "update Customer info", notes = "To update Customer", response = CustomerDto.class)
    @PreAuthorize("hasRole('USER')")
    @PutMapping("/update/{id}")
    ResponseEntity<CustomerDto> updateCustomer(@Valid @RequestBody CustomerDto CustomerDto,
                                               @PathVariable(name = "id") @NotBlank(message = "Please enter the valid id") Long id) {
        CustomerDto.setId(id);
        return ResponseEntity.ok(customerServices.save(CustomerDto));
    }

    @ApiOperation(value = "Customer info", notes = "To Get Customer", response = CustomerDto.class)
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/get/{id}")
    ResponseEntity<CustomerDto> getCustomer(@PathVariable(name = "id") @NotBlank(message = "Please enter the valid id") Long id) {
        return ResponseEntity.ok(customerServices.getCustomerById(id));
    }

    @ApiOperation(value = "Delete Customer info", notes = "To delete Customer", response = CustomerDto.class)
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    ResponseEntity<String> deleteCustomer(@PathVariable(name = "id") @NotBlank(message = "Please enter the valid id") Long id) {
        customerServices.deleteCustomers(id);
        return ResponseEntity.ok("Delete");
    }

    @ApiOperation(value = "update Customer Address info", notes = "To update Customer Address ", response = CustomerDto.class)
    @PreAuthorize("hasRole('USER')")
    @PatchMapping("/update/address/{id}")
    ResponseEntity<String> updateCustomerAddress(@Valid @RequestBody AddressDto addressDto,
                                                 @PathVariable(name = "id") @NotBlank(message = "Please enter the valid id") Long id) {
        customerServices.save(addressDto, id);
        return ResponseEntity.ok("Updated Address");
    }
}
