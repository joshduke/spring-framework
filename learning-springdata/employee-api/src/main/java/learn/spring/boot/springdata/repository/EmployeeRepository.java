package learn.spring.boot.springdata.repository;

import learn.spring.boot.springdata.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    public List<Employee> findByEmployeeName(String name);

}
