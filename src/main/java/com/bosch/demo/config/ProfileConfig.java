package com.bosch.demo.config;

import com.bosch.demo.config.beans.DevBean;
import com.bosch.demo.config.beans.StgBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Created by Deepak Rai on 20/9/20.
 */
@Configuration
@Slf4j
public class ProfileConfig {

    @Bean
    @Profile("stg")
    StgBean stgBean() {
        log.info("this is staging environment");
        return new StgBean();
    }

    @Bean
    @Profile("dev")
    DevBean barBean() {
        log.info("this is development environment");
        return new DevBean();
    }
}
