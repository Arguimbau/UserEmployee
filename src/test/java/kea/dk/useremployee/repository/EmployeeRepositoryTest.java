package kea.dk.useremployee.repository;

import kea.dk.useremployee.model.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeRepositoryTest
{
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    UserRepository userRepository;
    @Test
    void testDeleteEmployee(){
        List<Employee> lst = employeeRepository.findEmployeeByName("Anna");
        assertTrue(lst.size()>0);
    }

    @Test
    void deleteEmployee(){
        List<Employee> lst = employeeRepository.findEmployeeByName("Anna");
        Employee emp1 = lst.get(0);
        //userRepository.delete(emp1.getUser());
        assertThrows(DataIntegrityViolationException.class, () -> userRepository.delete(emp1.getUser()));
    }
}