package com.bosch.demo.api.dto;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;

/**
 * Created by Deepak Rai on 19/9/20.
 */
@Getter
@Builder
public class AddressDto {
    private Long id;

    private CityDto cityDto;

    @NotEmpty(message = "Please mention your address")
    private String address;
}
