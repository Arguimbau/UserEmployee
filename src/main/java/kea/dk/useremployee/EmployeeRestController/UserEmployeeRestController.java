package kea.dk.useremployee.controller;

import kea.dk.useremployee.dto.UserEmployeeDTO;
import kea.dk.useremployee.model.User;
import kea.dk.useremployee.singleton.Registry;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserEmployeeRestController {

    @GetMapping("/useremployees")
    public ResponseEntity<List<UserEmployeeDTO>> getAllUserEmployees() {
        List<User> users = Registry.userRepository.findAll();
        List<UserEmployeeDTO> userEmployeeDTOS = new ArrayList<>();
        users.forEach( user -> {
            userEmployeeDTOS.add( Registry.userEmployeeConverter.toUserEmployeeDTO(
                    user, (user.getEmployee() != null ) ? user.getEmployee().getId() : 0 ) ); ;
        } );
        return ResponseEntity.ok( userEmployeeDTOS );
    }
}
