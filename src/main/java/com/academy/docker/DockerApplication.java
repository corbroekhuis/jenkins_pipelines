package com.academy.docker;

import com.academy.docker.model.Employee;
import com.academy.docker.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DockerApplication implements CommandLineRunner {

	@Autowired
	EmployeeService employeeService;

	//@Value("${server.port}")
	String port = "8443";

	public static void main(String[] args) {

		SpringApplication.run(DockerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		employeeService.save(new Employee( 0, "John Doe", 25, "john.doe@srv.org", 123456789, ""));
		employeeService.save(new Employee( 0, "Jane Doe", 23, "jane.doe@srv.org", 234567890, ""));
		employeeService.save(new Employee( 0, "Baby Doe", 1, "baby.doe@srv.org", 345678901, ""));

		System.out.println("http://localhost:" + port + "/swagger-ui/");

	}
}
