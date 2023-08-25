package kea.dk.useremployee.config;

import kea.dk.useremployee.model.Employee;
import kea.dk.useremployee.model.Gender;
import kea.dk.useremployee.model.User;
import kea.dk.useremployee.repository.EmployeeRepository;
import kea.dk.useremployee.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class initData implements CommandLineRunner
{
    @Autowired
    UserRepository userRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public void run(String... args) throws Exception
    {
        User us1 = userRepository.save(new User("dummy@dummy.com", "Anna"));
        userRepository.save(new User("dummy1@dummy.com", "dummy2"));
        userRepository.save(new User("dummy2@dummy.com", "dummy3"));

        Employee emp1 = new Employee();
        emp1.setName("Anna");
        emp1.setGender(Gender.FEMALE);
        emp1.setVegetarian(false);
        emp1.setBorn(LocalDateTime.of(2000, 1,1,7,55,0));
        emp1.setUser(us1);
        employeeRepository.save(emp1);
    }
}
