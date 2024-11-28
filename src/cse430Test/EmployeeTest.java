package cse430Test;

import cse430.Employee;
import org.junit.Assert;
import org.junit.Test;


public class EmployeeTest {
	
	Employee employee1 = new Employee(1,"John Cena","Food","Job_Title",100.00);
	
	@Test
	public void testSetAndGetId() {
		employee1.setId(3);
		Assert.assertEquals(3, employee1.getId());
	}
	
	@Test
	public void testSetAndGetName() {
		employee1.setName("Mr Wick");;
		Assert.assertEquals("Mr Wick", employee1.getName());
	}
	
	@Test
	public void testSetAndGetDepartment() {
		employee1.setDepartment("Drinks");
		Assert.assertEquals("Drinks", employee1.getDepartment());
	}
	
	@Test
	public void testSetAndGetJobTitle() {
		employee1.setJobTitle("CR");
		Assert.assertEquals("CR", employee1.getJobTitle());
	}
	
	@Test
	public void testSetAndGetSalary() {
		employee1.setSalary(150.00);;
		Assert.assertEquals(150.00, employee1.getSalary(), 0.01);
	}

}
