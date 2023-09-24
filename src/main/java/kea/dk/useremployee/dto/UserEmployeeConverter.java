package kea.dk.useremployee.dto;

import kea.dk.useremployee.model.User;
import kea.dk.useremployee.singleton.Registry;
import kea.dk.useremployee.model.Employee;

public class UserEmployeeConverter {
    public UserEmployeeDTO toUserEmployeeDTO(User user, int id ) {

        // GET
        return new UserEmployeeDTO(
                user.getId(),
                user.getEmail(),
                id

        );
    }
}