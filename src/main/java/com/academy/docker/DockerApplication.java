package com.academy.docker;

import com.academy.docker.model.Employee;
import com.academy.docker.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DockerApplication implements CommandLineRunner {

	@Autowired
	EmployeeService employeeService;

	public static void main(String[] args) {
		System.out.println("http://localhost:8080/swagger-ui/");
		SpringApplication.run(DockerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		employeeService.save(new Employee( 0, "John Doe", 25, "john.doe@srv.org"));
		employeeService.save(new Employee( 0, "Jane Doe", 23, "jane.doe@srv.org"));
		employeeService.save(new Employee( 0, "Baby Doe", 1, "baby.doe@srv.org"));



	}

}
