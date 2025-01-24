package learn.spring.boot.springdata.controller;

import learn.spring.boot.springdata.entity.Employee;
import learn.spring.boot.springdata.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService service;

    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable("id") int employeeId) {
        return service.fetchEmployee(employeeId);
    }

    @PostMapping("/employee")
    public Employee onboardEmployee(@RequestBody Employee employee) {
        return service.storeEmployeeDate(employee);
    }


}
