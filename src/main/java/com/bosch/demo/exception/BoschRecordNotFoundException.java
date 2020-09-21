package com.bosch.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Deepak Rai on 19/9/20.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class BoschRecordNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public BoschRecordNotFoundException(String message) {
        super(message);
    }
}