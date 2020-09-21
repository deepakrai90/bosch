package com.bosch.demo.api.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Deepak Rai on 20/9/20.
 */
@Getter
@Setter
public class AuthTokenDto {
    private String token;

    public AuthTokenDto(String token) {
        this.token = token;
    }
}
