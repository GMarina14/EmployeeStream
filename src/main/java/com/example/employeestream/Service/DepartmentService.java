package com.example.employeestream.Service;

import com.example.employeestream.Employee.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface DepartmentService {
    public Employee employeeWithMaxSalaryByDepartment(Integer department);
    public Employee employeeWithMinSalaryByDepartment(Integer department);
    public Map<Integer, List<Employee>> printAllByDepartments(Integer department);



}
