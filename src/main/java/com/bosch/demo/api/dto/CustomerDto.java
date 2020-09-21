package com.bosch.demo.api.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * Created by Deepak Rai on 19/9/20.
 */
@Getter
@Builder
@Setter
public class CustomerDto {
    private Long id;
    @Min(value = 3, message = "name should be 3 or more then characters")
    @Max(value = 50, message = "name should be 50 or less then characters")
    private String name;
    @NotEmpty(message = "Email must not be empty")
    @Email(message = "Email must be a valid email address")
    private String email;

    private List<AddressDto> addressDto;

}
