package problem2.useCases;

import java.util.Scanner;

import problem2.Exceptions.EmployeeException;
import problem2.beans.Employee;
import problem2.dao.EmployeeDao;
import problem2.dao.EmployeeDaoImpl;



public class getEmployeeById {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter the ID: ");
		int id= sc.nextInt();
		
		sc.close();
		
		EmployeeDao dao = new EmployeeDaoImpl();
		
		try{
			Employee emp = dao.getEmployeeById(id);
			System.out.println(emp);
		} catch (EmployeeException e) {
			System.out.println(e.getMessage());
		}
	}
}
