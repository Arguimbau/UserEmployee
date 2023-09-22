package kea.dk.useremployee.dto;

import kea.dk.useremployee.model.Employee;

public record UserDTO(int userId, String email, String password, EmployeeDTO employeeDTO) {

}
