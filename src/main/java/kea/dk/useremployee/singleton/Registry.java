package kea.dk.useremployee.singleton;

import jakarta.annotation.PostConstruct;
import kea.dk.useremployee.dto.EmployeeConverter;
import kea.dk.useremployee.dto.UserConverter;
import kea.dk.useremployee.dto.UserEmployeeConverter;
import kea.dk.useremployee.repository.EmployeeRepository;
import kea.dk.useremployee.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Registry {
    @Autowired
    public UserRepository _userRepository;

    @Autowired
    public EmployeeRepository _employeeRepository;
    public static UserRepository userRepository;
    public static EmployeeRepository employeeRepository;
    public static UserConverter userConverter = new UserConverter();
    public static EmployeeConverter employeeConverter = new EmployeeConverter();

    public static UserEmployeeConverter userEmployeeConverter = new UserEmployeeConverter();

    @PostConstruct
    private void init() {
        userRepository = this._userRepository;
        employeeRepository = this._employeeRepository;
    }
}
