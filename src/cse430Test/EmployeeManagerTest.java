package cse430Test;

import cse430.Employee;
import cse430.EmployeeManager;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

public class EmployeeManagerTest {
	
	EmployeeManager employeeManager;
	
	Employee employee1;
	Employee employee2;
	
	@Before
	public void setUp() {
		employee1 = new Employee(1,"John Cena","Food","Job_Title",100.00);
		employee2 = new Employee(2,"Mr Wick","Drinks","Job_Title",150.00);
		
		employeeManager.addEmployee(employee1);
		employeeManager.addEmployee(employee2);
	}
	
	@Test
	public void testAddEmployee() {
		employeeManager.addEmployee(employee1);
		employeeManager.addEmployee(employee2);
		Assert.assertEquals(2, employeeManager.getEmployees().size());
	}
	
//    @Test
//    public void testFindEmployeeById() {
//        Assert.assertEquals(employee1, employeeManager.findEmployeeById(1));
//    }

	
	

}
