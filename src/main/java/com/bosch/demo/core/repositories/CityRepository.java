package com.bosch.demo.core.repositories;

import com.bosch.demo.core.entities.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Deepak Rai on 19/9/20.
 */
@Repository
public interface CityRepository extends CrudRepository<City, Long> {
}
