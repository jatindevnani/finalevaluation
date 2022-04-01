package problem2.useCases;

import java.util.Scanner;

import problem2.beans.Employee;
import problem2.dao.EmployeeDao;
import problem2.dao.EmployeeDaoImpl;

public class SaveEmployeeDetails {
	public static void main(String[] args) {
		//Getting the instance of EmployeeDaoImpl
		EmployeeDao dao = new EmployeeDaoImpl();
		
		
		
		//Getting the employee details from the user
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter details of the new Employee: ");
		
		System.out.print("Employee ID: ");
		int id = Integer.valueOf(scanner.nextLine());
		
		System.out.print("Employee Name: ");
		String name = scanner.nextLine();
		
		System.out.print("Employee Address: ");
		String address = scanner.nextLine();
		
		System.out.print("Employee Salary: ");
		int salary = Integer.valueOf(scanner.nextLine());
		
		scanner.close();
		
		
		
		Employee employee = new Employee(id, name, address, salary);
		
		String status = dao.saveEmployeeDetails(employee);
		
		System.out.println(status);
	}
}
