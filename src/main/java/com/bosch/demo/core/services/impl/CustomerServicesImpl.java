package com.bosch.demo.core.services.impl;

import com.bosch.demo.api.dto.AddressDto;
import com.bosch.demo.api.dto.CityDto;
import com.bosch.demo.api.dto.CustomerDto;
import com.bosch.demo.core.entities.Address;
import com.bosch.demo.core.entities.City;
import com.bosch.demo.core.entities.Customer;
import com.bosch.demo.core.repositories.AddressRepository;
import com.bosch.demo.core.repositories.CityRepository;
import com.bosch.demo.core.repositories.CustomerRepository;
import com.bosch.demo.core.services.CustomerServices;
import com.bosch.demo.exception.BoschRecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Deepak Rai on 19/9/20.
 */
@Service
public class CustomerServicesImpl implements CustomerServices {

    @Autowired
    private CustomerRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private CityRepository cityRepository;

    @Override
    public CustomerDto getCustomerById(Long id) {
        Optional<Customer> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            return getUserDto(userOptional.get());
        }
        throw new BoschRecordNotFoundException("Customer record does not have in database " + id);
    }

    @Override
    public List<Customer> getUsers(Long id) {
        return userRepository.findAll();
    }

    @Override
    public void deleteCustomers(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    @Transactional
    public CustomerDto save(CustomerDto customerDto) {
        return getUserDto(userRepository.save(getUser(customerDto)));
    }

    @Override
    @Transactional
    public void save(AddressDto addressDto, Long id) {
        Optional<Address> addressOptional = addressRepository.findById(id);
        if (addressOptional.isPresent()) {
            Address address = Address.builder()
                    .id(id)
                    .address(addressDto.getAddress())
                    .city(getCity(addressDto.getCityDto()))
                    .build();
            addressRepository.save(address);
        }

        throw new BoschRecordNotFoundException("No record found");
    }

    private Customer getUser(CustomerDto customerDto) {
        return Customer.builder()
                .email(customerDto.getEmail())
                .address(getAddress(customerDto.getAddressDto()))
                .name(customerDto.getName())
                .build();
    }

    private List<Address> getAddress(List<AddressDto> addressDto) {
        return addressDto.stream()
                .map(a -> Address.builder()
                        .address(a.getAddress())
                        .city(getCity(a.getCityDto()))
                        .build())
                .collect(Collectors.toList());
    }

    private City getCity(CityDto cityDto) {
        return City.builder()
                .name(cityDto.getName())
                .build();
    }

    private CustomerDto getUserDto(Customer user) {
        return CustomerDto.builder()
                .email(user.getEmail())
                .name(user.getName())
                .id(user.getId())
                .build();
    }


}
