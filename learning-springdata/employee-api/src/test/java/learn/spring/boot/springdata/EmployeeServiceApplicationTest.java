package learn.spring.boot.springdata;

import jakarta.transaction.Transactional;
import learn.spring.boot.springdata.entity.Employee;
import learn.spring.boot.springdata.repository.EmployeeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@Transactional
@SpringBootTest(classes = EmployeeServiceApplication.class)
class EmployeeServiceApplicationTest {

	@Autowired
	EmployeeRepository repository;

	@Test
	void testEmployeeCreation() {
		Employee employee = prepareEmployee(101, "josh");
		repository.save(employee);
		Employee fromDB = repository.findById(101).get();
		Assertions.assertEquals(employee.getEmployeeId(), fromDB.getEmployeeId());
	}

	@Test
	void testEmployeeFetchByName() {
		Employee employee = prepareEmployee(101, "josh");
		repository.save(employee);
		Employee fromDB = repository.findByEmployeeName("josh").get(0);
		Assertions.assertEquals(employee.getEmployeeId(), fromDB.getEmployeeId());
	}

	private Employee prepareEmployee(int id, String name) {
		Employee employee = new Employee();
		employee.setEmployeeId(id);
		employee.setEmployeeName(name);
		return employee;
	}

}
