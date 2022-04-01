package problem2.useCases;

import java.util.Scanner;

import problem2.Exceptions.EmployeeException;
import problem2.dao.EmployeeDao;
import problem2.dao.EmployeeDaoImpl;

public class deleteEmployee {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter the ID of employee you want to delete: ");
		int id= sc.nextInt();
		
		sc.close();
		
		EmployeeDao dao = new EmployeeDaoImpl();
		
		try{
			String result = dao.deleteEmployee(id);
			System.out.println(result);
		} catch (EmployeeException e) {
			System.out.println(e.getMessage());
		}
	}
}
