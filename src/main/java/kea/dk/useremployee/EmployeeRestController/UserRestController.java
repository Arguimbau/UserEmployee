package kea.dk.useremployee.EmployeeRestController;

import kea.dk.useremployee.model.User;
import kea.dk.useremployee.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class UserRestController
{
    @Autowired
    UserRepository userRepository;

    @GetMapping("/user")
    public List<User> getAllUsers(){return userRepository.findAll();}


    @PostMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    public User postUser(@RequestBody User user){
        System.out.println(user);
        return userRepository.save(user);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<User> putStudent(@PathVariable ("id") int id,
                                           @RequestBody User user){
        Optional<User> optionalStudent = userRepository.findById(id);
        if(optionalStudent.isPresent()){
            user.setUserID(id);
            userRepository.save(user);
            //return new ResponseEntity<>(student, HttpStatus.OK);
            return ResponseEntity.ok(user); //Samme som linjen over
        }
        else {
            //return new ResponseEntity<>(new Student(), HttpStatus.NOT_FOUND);
            return ResponseEntity.notFound().build(); // Samme som linjen over
        }
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable ("id") int id){
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()){
            userRepository.deleteById(id);
            return ResponseEntity.ok("User Deleted");
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }

}
