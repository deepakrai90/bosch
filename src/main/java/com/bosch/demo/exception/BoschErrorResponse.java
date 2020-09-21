package com.bosch.demo.exception;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by Deepak Rai on 19/9/20.
 */
@Setter
@Getter
public class BoschErrorResponse {

    private String message;
    private List<String> details;

    public BoschErrorResponse(String message, List<String> details) {
        super();
        this.message = message;
        this.details = details;
    }
}
