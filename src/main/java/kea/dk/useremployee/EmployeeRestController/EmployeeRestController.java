package kea.dk.useremployee.EmployeeRestController;

import kea.dk.useremployee.dto.EmployeeConverter;
import kea.dk.useremployee.dto.EmployeeDTO;
import kea.dk.useremployee.dto.UserConverter;
import kea.dk.useremployee.model.Employee;
import kea.dk.useremployee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeRestController
{
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeConverter employeeConverter;
    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees(){
    List<Employee> employeeList = employeeRepository.findAll();
    List<EmployeeDTO> employeeDTOList = new ArrayList<>();
    employeeList.forEach(employee -> {
        employeeDTOList.add(employeeConverter.toDTO(employee));
    });
        return ResponseEntity.ok(employeeDTOList);
    }

    @PostMapping("/employee")
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeDTO postEmployee(@RequestBody EmployeeDTO employeeDTO){
        Employee employee = employeeConverter.toEntity(employeeDTO);
        System.out.println(employee);
        return employeeConverter.toDTO(employee);
    }


    @PutMapping("/employee/{id}")
    public ResponseEntity<EmployeeDTO> putStudent(@PathVariable ("id") int id,
                                              @RequestBody EmployeeDTO employeeDTO){
        Optional<Employee> optionalStudent = employeeRepository.findById(id);
        if(optionalStudent.isPresent()){
            Employee employee = employeeConverter.toEntity(employeeDTO);
            employee.setId(id);
            employeeRepository.save(employee);
            //return new ResponseEntity<>(student, HttpStatus.OK);
            return ResponseEntity.ok(employeeConverter.toDTO(employee)); //Samme som linjen over
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

