package com.example.employeestream.EmployeeExceptions;

public class EmployeeAlreadyAddedException extends RuntimeException {
    public EmployeeAlreadyAddedException(String message) {
        super(message);
    }
}
