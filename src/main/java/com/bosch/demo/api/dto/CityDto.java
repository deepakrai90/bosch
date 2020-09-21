package com.bosch.demo.api.dto;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;

/**
 * Created by Deepak Rai on 19/9/20.
 */
@Getter
@Builder
public class CityDto {
    private Long id;
    @NotEmpty(message = "Please select city")
    private String name;
}
