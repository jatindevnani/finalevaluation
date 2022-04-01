package problem2.dao;

import java.util.List;

import problem2.Exceptions.EmployeeException;
import problem2.beans.Employee;

public interface EmployeeDao {
	public String saveEmployeeDetails(Employee employee);

	public Employee getEmployeeById(int empId) throws EmployeeException;

	public List<Employee> getAllEmployees();

	public String deleteEmployee(int empId)throws EmployeeException;

}
