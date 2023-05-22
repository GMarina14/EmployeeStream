package com.example.employeestream.Service;

import com.example.employeestream.Employee.Employee;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeStreamService employeeStreamService;

    public DepartmentServiceImpl(EmployeeStreamService employeeStreamService) {
        this.employeeStreamService = employeeStreamService;
    }


    @Override
    public Employee employeeWithMaxSalaryByDepartment(Integer department) {

        return employeeStreamService.getAllEmployees().values().stream()
                .filter(e -> e.getDepartment() == department)
                .max(Comparator.comparingInt(employee -> employee.getSalary()))
                .orElse(null);
    }

    @Override
    public Employee employeeWithMinSalaryByDepartment(Integer department) {
        return employeeStreamService.getAllEmployees().values().stream()
                .filter(e -> e.getDepartment() == department)
                .min(Comparator.comparingInt(employee -> employee.getSalary()))
                .orElse(null);
    }

    @Override
    public Map<Integer, List<Employee>> printAllByDepartments(Integer department) {
        return employeeStreamService.getAllEmployees().values().stream()
                .filter(employee -> department == null || employee.getDepartment()==department)
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }

}
