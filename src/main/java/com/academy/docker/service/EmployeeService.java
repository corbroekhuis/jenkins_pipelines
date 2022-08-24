package com.academy.docker.service;

import com.academy.docker.model.Employee;

import java.util.Optional;

public interface EmployeeService {

    public Employee save(Employee employee);

    public Iterable<Employee> saveAll(Iterable<Employee> employees);

    public Optional<Employee> findById(Long id);

    public boolean existsById(Long id);

    public Iterable<Employee> findAll();

    public Iterable<Employee> findAllById(Iterable<Long> ids);

    public long count();

    public void deleteById(Long id);

    public void delete(Employee employee);

    public void deleteAll(Iterable<? extends Employee> employees);

    public void deleteAll();

}

