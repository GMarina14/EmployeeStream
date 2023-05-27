package com.example.employeestream.Service;

import com.example.employeestream.Employee.Employee;
import com.example.employeestream.EmployeeExceptions.EmployeeAlreadyAddedException;
import com.example.employeestream.EmployeeExceptions.EmployeeNotFoundException;
import com.example.employeestream.EmployeeExceptions.EmployeeStorageIsFullException;
import com.example.employeestream.EmployeeExceptions.IncorrectData;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class EmployeeStreamServiceImpl implements EmployeeStreamService {
    private final int SIZE = 5;
    Map<String, Employee> employees = new HashMap<>(Map.of());

    @Override
    public Employee addNewEmployee(String firstName, String lastName, int department, int salary) {
        checkData(firstName, lastName);
        String employeeKey = getEmployeeKey(StringUtils.capitalize(firstName.toLowerCase()), StringUtils.capitalize(lastName.toLowerCase()));
        if (employees.containsKey(employeeKey)) {
            throw new EmployeeAlreadyAddedException("An employee with the same full name already was added");
        } else if (SIZE == employees.size()) {
            throw new EmployeeStorageIsFullException("Can not hire more employees");
        } else {
            Employee employee = new Employee(firstName, lastName, department, salary);
            employees.put(employeeKey, employee);
            System.out.println(employee);
        }


        return employees.get(employeeKey);

    }

    @Override
    public void removeEmployee(String firstName, String lastName) {
        String employeeKey = getEmployeeKey(firstName, lastName);
        if (!employees.containsKey(employeeKey)) {
            throw new EmployeeNotFoundException("Employee not found");
        } else {
            employees.remove(employeeKey);
        }
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        String employeeKey = getEmployeeKey(firstName, lastName);
        if (!employees.containsKey(employeeKey)) {
            throw new EmployeeNotFoundException("Employee not found");
        } else {
            return employees.get(employeeKey);
        }
    }

    @Override
    public Map<String, Employee> getAllEmployees() {
        return employees;
    }

    private String getEmployeeKey(String firstName, String lastName) {
        return firstName + ' ' + lastName;
    }

    private void checkData(String firstName, String lastName) throws IncorrectData {
        if (!((StringUtils.isAlpha(firstName)) && StringUtils.isAlpha(lastName))) {
            throw new IncorrectData("Invalid data");
        }
    }

}
