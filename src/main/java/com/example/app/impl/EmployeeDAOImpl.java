package com.example.app.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.app.model.Employee;
import com.example.dao.EmplyeeDAO;

@Repository
public class EmployeeDAOImpl implements EmplyeeDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void createEmployee(Employee employee) {
		String CERATE_EMPLOYEE_SQL = "insert into employee_table (employee_id,employee_name,email,salary) values(?,?,?,?)";
		//to insert or create ,update ,delete a record always use update() method 
		int update = jdbcTemplate.update(CERATE_EMPLOYEE_SQL, employee.getEmployeeId(), employee.getEmployeeName(),
				employee.getEmail(), employee.getSalary());
		if (update == 1) {
			System.out.println("employee is created");
		}
	}

	@Override
	public Employee getEmployeeById(Integer employeeId) {
		String GET_EMPLOYEE_SQL ="select * from employee_table where employee_id=?";
		Employee employee =jdbcTemplate.queryForObject(GET_EMPLOYEE_SQL, new EmployeeRowMapper(), employeeId);
		return employee;
	}

	@Override
	public void updayeEmployeeById(Integer employeeId, String newEmail) {
		String UPDATE_EMPLOYEE_SQL ="UPDATE employee_table set email=? where employee_id=?";
		int update=jdbcTemplate.update(UPDATE_EMPLOYEE_SQL, newEmail,employeeId);
		if (update == 1) {
			System.out.println("employee email is updated....");
		}
	}

	@Override
	public void deleteEmployeeById(Integer employeeId) {
		String DELETE_EMPLOYEE_SQL ="DELETE from employee_table where employee_id=?";
		int update=jdbcTemplate.update(DELETE_EMPLOYEE_SQL,employeeId);
		if (update == 1) {
			System.out.println("employee  is deleted....");
		}
	}

}
