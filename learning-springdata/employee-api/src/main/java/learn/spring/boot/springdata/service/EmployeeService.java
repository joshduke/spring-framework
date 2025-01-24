package learn.spring.boot.springdata.service;

import learn.spring.boot.springdata.entity.Employee;
import learn.spring.boot.springdata.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public Employee fetchEmployee(int employeeId) {
        return repository.findById(employeeId).get();
    }

    public Employee storeEmployeeDate(Employee employee) {
        return repository.save(employee);
    }
}
