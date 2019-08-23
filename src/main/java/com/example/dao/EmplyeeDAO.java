package com.example.dao;

import com.example.app.model.Employee;

public interface EmplyeeDAO {
	
	public void createEmployee(Employee employee);
	public Employee getEmployeeById(Integer employeeId);
	public void updayeEmployeeById(Integer employeeId, String newEmail);
	public void deleteEmployeeById(Integer employeeId);
	

}
