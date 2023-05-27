package com.example.employeestream.EmployeeExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IncorrectData extends RuntimeException {
    public IncorrectData(String message) {
        super(message);
    }

}
