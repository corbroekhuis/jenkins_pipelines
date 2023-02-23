package com.academy.docker.service;

import com.academy.docker.repository.EmployeeRepository;
import com.academy.docker.model.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    EmployeeRepository employeeRepository;
    ImageUrlService imageUrlService;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ImageUrlService imageUrlService){
        this.employeeRepository = employeeRepository;
        this.imageUrlService = imageUrlService;
    }

    @Override
    public Employee save(Employee employee){
        // Business logic uitvoeren
        return employeeRepository.save(employee);
    }

    @Override
    public Iterable<Employee> saveAll(Iterable<Employee> employees){
        return employeeRepository.saveAll(employees);
    }

    @Override
    public Optional<Employee> findById(Long id){
        String imageUrl = imageUrlService.getUrl( id);
        Employee employee = employeeRepository.findById(id).get();
        employee.setImageUrl( imageUrl);
        return Optional.of(employee);
    }

    @Override
    public boolean existsById(Long id){
        return employeeRepository.existsById(id);
    }

    @Override
    public Iterable<Employee> findAll(){
        return employeeRepository.findAll();
    }

    @Override
    public Iterable<Employee> findAllById(Iterable<Long> ids){
        return employeeRepository.findAllById(ids);
    }

    @Override
    public long count(){
        return employeeRepository.count();
    }

    @Override
    public void deleteById(Long id){
        employeeRepository.deleteById(id);
    }

    @Override
    public void delete(Employee employee){
        employeeRepository.delete(employee);
    }

    @Override
    public void deleteAll(Iterable<? extends Employee> employees){
        employeeRepository.deleteAll(employees);
    }

    @Override
    public void deleteAll(){
        employeeRepository.deleteAll();
    }

}

