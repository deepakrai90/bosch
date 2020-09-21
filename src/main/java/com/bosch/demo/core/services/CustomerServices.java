package com.bosch.demo.core.services;

import com.bosch.demo.api.dto.AddressDto;
import com.bosch.demo.api.dto.CustomerDto;
import com.bosch.demo.core.entities.Customer;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Deepak Rai on 19/9/20.
 */
public interface CustomerServices {
    CustomerDto getCustomerById(Long id);

    List<Customer> getUsers(Long id);

    void deleteCustomers(Long id);

    @Transactional
    CustomerDto save(CustomerDto customerDto);

    @Transactional
    void save(AddressDto addressDto, Long id);
}
