package com.example.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.app.impl.EmployeeDAOImpl;
import com.example.app.model.Employee;
import com.example.dao.EmplyeeDAO;

@SpringBootApplication
public class SpringBootJdbcApplication implements CommandLineRunner {
	@Autowired
	private EmplyeeDAO employeedao;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJdbcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//createEmployee();
		//getEmployeeById();
		//employeedao.updayeEmployeeById(7896, "naveen321@gmail.com");
		employeedao.deleteEmployeeById(7896);
	}

	private void createEmployee() {
		Employee employee = new Employee();
		employee.setEmployeeId(7896);
		employee.setEmployeeName("naveen");
		employee.setEmail("naveen.monty@gmail.com");
		employee.setSalary((double) 40000);
		employeedao.createEmployee(employee);
	}
	private void getEmployeeById() {
		Employee employee = employeedao.getEmployeeById(7896);
		System.out.println(employee);
		
	}
}
