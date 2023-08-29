package kea.dk.useremployee.EmployeeRestController;

import kea.dk.useremployee.model.Employee;
import kea.dk.useremployee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeRestController
{
    @Autowired
    EmployeeRepository employeeRepository;


    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    @PostMapping("/employee")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee postEmployee(@RequestBody Employee employee){
        System.out.println(employee);
        return employeeRepository.save(employee);
    }


    @PutMapping("/employee/{id}")
    public ResponseEntity<Employee> putStudent(@PathVariable ("id") int id,
                                              @RequestBody Employee employee){
        Optional<Employee> optionalStudent = employeeRepository.findById(id);
        if(optionalStudent.isPresent()){
            employee.setId(id);
            employeeRepository.save(employee);
            //return new ResponseEntity<>(student, HttpStatus.OK);
            return ResponseEntity.ok(employee); //Samme som linjen over
        }
        else {
            //return new ResponseEntity<>(new Student(), HttpStatus.NOT_FOUND);
            return ResponseEntity.notFound().build(); // Samme som linjen over
        }
    }
    @DeleteMapping("/employee/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable ("id") int id){
        Optional<Employee> optionalStudent = employeeRepository.findById(id);
        if(optionalStudent.isPresent()){
            employeeRepository.deleteById(id);
            return ResponseEntity.ok("Employee Deleted");
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found");
        }
    }


}

