package problem2.useCases;

import java.util.List;

import problem2.beans.Employee;
import problem2.dao.EmployeeDao;
import problem2.dao.EmployeeDaoImpl;



public class getAllEmployees {

	public static void main(String[] args) {
		EmployeeDao dao = new EmployeeDaoImpl();
		List<Employee> employees = dao.getAllEmployees();
		
		for(Employee emp: employees) {
			System.out.println(emp);
		}

	}

}
