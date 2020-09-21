package com.bosch.demo.core.repositories;

import com.bosch.demo.core.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Deepak Rai on 20/9/20.
 */
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByUsername(String userName);
}
