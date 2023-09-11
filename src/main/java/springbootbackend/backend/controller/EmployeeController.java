// Building Get All Employees REST API
package springbootbackend.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springbootbackend.backend.exception.ResourceNotFoundException;
import springbootbackend.backend.model.Employee;
import springbootbackend.backend.repositoy.EmployeeRepository;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")

public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;
    @GetMapping
    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();

    }
    //build create employee rest api
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }
    //build get employee by id REST API
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeId( @PathVariable long id){
    Employee employee= employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id:" +id));
    return ResponseEntity.ok(employee);
    }


    //BUILD UPDATE EMPLOYEE REST API
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id,@RequestBody Employee employeeDetails){
        Employee updateEmployee = employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id:"+id));
        updateEmployee.setFirstName(employeeDetails.getFirstName());
        updateEmployee.setLastName(employeeDetails.getLastName());
        updateEmployee.setEmailId(employeeDetails.getEmailId());

        employeeRepository.save(updateEmployee);
        return  ResponseEntity.ok(updateEmployee);


    }
    //BUILD DELETE EMPLOYEE REST API
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id){

        Employee employee= employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id:"+id));
        employeeRepository.delete(employee);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
