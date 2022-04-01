package problem2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import problem2.Exceptions.EmployeeException;
import problem2.beans.Employee;
import problem2.utilities.DatabaseConnection;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public String saveEmployeeDetails(Employee employee) {
		String message = "Record not entered...";
		try(Connection conn = DatabaseConnection.provideConnection()) {
						//Preparing a query
			PreparedStatement ps = conn.prepareStatement("insert into Employee values(?, ?, ?, ?)");
			
			ps.setInt(1, employee.getEmpID());
			ps.setString(2, employee.getName());
			ps.setString(3, employee.getAddress());
			ps.setInt(4, employee.getSalary());
			
			//Result will contain value > 0 if the entry was successful
			int result = ps.executeUpdate();
			
			if(result > 0) {
				message = "Record entered successfully...";
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return message;
	}

	@Override
	public Employee getEmployeeById(int empId) throws EmployeeException {
		
		Employee employee = new Employee();
		
		try(Connection conn = DatabaseConnection.provideConnection()) {
			//Preparing a query
			PreparedStatement ps = conn.prepareStatement("select * from employee WHERE empId=?");

			ps.setInt(1, empId);

			ResultSet rs = ps.executeQuery();

			if(rs.next()) {
				int id = rs.getInt("empId");
				String name = rs.getString("name");
				String address = rs.getString("address");
				int salary = rs.getInt("salary");
				
				employee.setEmpID(id);
				employee.setName(name);
				employee.setAddress(address);
				employee.setSalary(salary);
				} else {
					throw new EmployeeException("No employee with ID " + empId + " in the records.");
				}

		} catch(SQLException e) {
			throw new EmployeeException(e.getMessage());
		}
		return employee;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<>();
		try(Connection conn = DatabaseConnection.provideConnection()) {
			//Preparing a query
			PreparedStatement ps = conn.prepareStatement("select * from employee");
			
			ResultSet rs = ps.executeQuery();

			  while(rs.next()) {
				int id = rs.getInt("empId");
				String name = rs.getString("name");
				String address = rs.getString("address");
				int salary = rs.getInt("salary");
				
				Employee employee = new Employee();
				
					employee.setEmpID(id);
					employee.setName(name);
					employee.setAddress(address);
					employee.setSalary(salary);
					
					employees.add(employee);
				} 
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}

	@Override
	public String deleteEmployee(int empId) throws EmployeeException {
		String message = "Record with ID " + empId + " doesn't exist in the database";
		try(Connection conn = DatabaseConnection.provideConnection()) {
						//Preparing a query
			PreparedStatement ps = conn.prepareStatement("delete from Employee where empId=?");
			
			ps.setInt(1, empId);
			
			//Result will contain value > 0 if the entry was successful
			int result = ps.executeUpdate();
			
			if(result > 0) {
				message = "Record Delete Succesfully...";
			} else {
				throw new EmployeeException(message);
			}
			
		} catch(SQLException e) {
			throw new EmployeeException(e.getMessage());
		}
		return message;
	}

}
