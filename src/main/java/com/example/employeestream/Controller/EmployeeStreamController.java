package com.example.employeestream.Controller;

import com.example.employeestream.Employee.Employee;
import com.example.employeestream.Service.EmployeeStreamService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeStreamController {
    private final EmployeeStreamService employeeStreamService;

    public EmployeeStreamController(EmployeeStreamService employeeStreamService) {
        this.employeeStreamService = employeeStreamService;
    }

    @GetMapping(path = "/add")
    public Employee addEmployee(@RequestParam("firstName") String firstName,
                                @RequestParam("lastName") String lastName,
                                @RequestParam ("department") int department,
                                @RequestParam("salary") int salary) {
        return employeeStreamService.addNewEmployee(firstName, lastName, department, salary);
    }

    @GetMapping(path = "/remove")
    public void removeEmployee(@RequestParam("firstName") String firstName,
                               @RequestParam("lastName") String lastName) {
        employeeStreamService.removeEmployee(firstName, lastName);
    }
    @GetMapping(path = "/find")
    public Employee findEmployee (@RequestParam("firstName") String firstName,
                                  @RequestParam("lastName") String lastName) {
        return employeeStreamService.findEmployee(firstName, lastName);
    }

    @GetMapping(path = "/printAll")
    public Map<String, Employee> printEmployees() {
        return employeeStreamService.getAllEmployees();
    }
}
