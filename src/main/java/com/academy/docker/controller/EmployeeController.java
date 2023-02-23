package com.academy.docker.controller;

import java.util.Collections;

import com.academy.docker.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import com.academy.docker.model.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    protected static final Logger logger = LogManager.getLogger();

    EmployeeService employeeService;
    String version;
    
    @Autowired
    public EmployeeController(EmployeeService employeeService, @Value("${version}") String version){
        this.employeeService = employeeService;
        this.version = version;
    }

    // http://localhost:9991/api/getversion
    @GetMapping("/getversion")
    public ResponseEntity<String> getVersion() {

        logger.info("Inside 'getVersion'");

        return ResponseEntity.ok( version);

    }

    @PostMapping(value = "/employee", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Employee> saveEmployee( @RequestBody final Employee employee) {

        logger.info("Inside 'saveEmployeeById'");

        employeeService.save(employee);
        return ResponseEntity.ok(employee) ;

    }

    // http://localhost:9991/api/employee/2
    @GetMapping(value = "/employee/{id}", produces = "application/json")
    public ResponseEntity<Employee> getEmployeeById( @PathVariable final Long id) {

        logger.info("Inside 'getEmployeeById'");

        try {
            Employee employee = employeeService.findById(id).orElse(null);
            return ResponseEntity.ok( employee);
        } catch (Exception e) {
            return ResponseEntity.ok( null);
        }

    }

    @GetMapping(value = "/employee", produces = "application/json")
    public ResponseEntity<Iterable<Employee>> getAllEmployees() {

        logger.info("Inside 'getAllEmployees'");

        try {
            Iterable<Employee> employees = employeeService.findAll();
            return ResponseEntity.ok( employees);
        } catch (Exception e) {
            return ResponseEntity.ok( null); // Collections.emptyList()
        }

    }

    @DeleteMapping(value = "/employee/{id}", produces = "text/plain")
    public ResponseEntity<String> deleteEmployeeById( @PathVariable final Long id) {

        logger.info("Inside 'deleteEmployeeById'");

        try {
            employeeService.deleteById(id);
            return ResponseEntity.ok( "Item with id: " + id + " is deleted");
        } catch (Exception e) {
            return ResponseEntity.ok( "Item with id: " + id + " may NOT be deleted");
        }

    }

}

