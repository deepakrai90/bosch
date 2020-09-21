package com.bosch.demo.core.repositories;

import com.bosch.demo.core.entities.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by Deepak Rai on 19/9/20.
 */
@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {
    Optional<Address> findById(Long id);
}
