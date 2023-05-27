package com.example.employeestream.Service;

import com.example.employeestream.Employee.Employee;
import com.example.employeestream.EmployeeExceptions.IncorrectData;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public interface EmployeeStreamService {
    Map<Integer, Employee> employees = new HashMap<>(Map.of());

    public Employee addNewEmployee(String firstName, String lastName, int department, int salary);

    public void removeEmployee(String firstName, String lastName);

    public Employee findEmployee(String firstName, String lastName);
    public Map<String, Employee> getAllEmployees();


}
