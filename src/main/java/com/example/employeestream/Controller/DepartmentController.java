package com.example.employeestream.Controller;

import com.example.employeestream.Employee.Employee;
import com.example.employeestream.Service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService  departmentService) {
        this.departmentService =departmentService;
    }

    @GetMapping(path = "/max-salary")
    public Employee findEmployeeWithMaxSalaryByDepartment(@RequestParam("departmentId") Integer departmentId) {

        return departmentService.employeeWithMaxSalaryByDepartment(departmentId);
    }

   @GetMapping(path = "/min-salary")
    public Employee findEmployeeWithMinSalaryByDepartment(@RequestParam("departmentId") Integer departmentId) {

        return departmentService.employeeWithMinSalaryByDepartment(departmentId);
    }

    @GetMapping(path = "/all")
    public Map <Integer, List <Employee>> printAllEmployeesByDepartment (@RequestParam (name = "departmentId", required = false) Integer department) {
        return departmentService.printAllByDepartments(department);
    }


}
