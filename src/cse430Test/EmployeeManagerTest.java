package cse430Test;

import cse430.Employee;
import cse430.EmployeeManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

public class EmployeeManagerTest {
	private EmployeeManager employeeManager;
	private Employee employee1;
	private Employee employee2;
	private Employee employee3;

	@Before
	public void setUp() {
		employeeManager = new EmployeeManager();
		employee1 = new Employee(1, "Alice Smith", "Engineering", "Engineer", 80000);
		employee2 = new Employee(2, "Bob Brown", "HR", "HR Manager", 75000);
		employee3 = new Employee(3, "Charlie Johnson", "Engineering", "Senior Engineer", 90000);
		employeeManager.addEmployee(employee1);
		employeeManager.addEmployee(employee2);
		employeeManager.addEmployee(employee3);
	}

	@Test
	public void testAddEmployee() {
		Employee newEmployee = new Employee(4, "David Wilson", "Finance", "Accountant", 70000);
		employeeManager.addEmployee(newEmployee);
		Assert.assertEquals(4, employeeManager.getEmployees().size());
	}

	@Test
	public void testRemoveEmployee() {
		boolean removed = employeeManager.removeEmployee(2);
		Assert.assertTrue(removed);
		Assert.assertNull(employeeManager.findEmployeeById(2));
	}

	@Test
	public void testFindEmployeeById() {
		Employee foundEmployee = employeeManager.findEmployeeById(1);
		Assert.assertNotNull(foundEmployee);
		Assert.assertEquals("Alice Smith", foundEmployee.getName());
	}

	@Test
	public void testFindEmployeesByDepartment() {
		List<Employee> engineeringEmployees = employeeManager.findEmployeesByDepartment("Engineering");
		Assert.assertEquals(2, engineeringEmployees.size());
		Assert.assertTrue(engineeringEmployees.contains(employee1));
		Assert.assertTrue(engineeringEmployees.contains(employee3));
	}

	@Test
	public void testCalculateTotalSalary() {
		double totalSalary = employeeManager.calculateTotalSalary();
		Assert.assertEquals(245000, totalSalary, 0);
	}

	@Test
	public void testGetEmployeesWithHighestSalary() {
		List<Employee> highestPaidEmployees = employeeManager.getEmployeesWithHighestSalary();
		Assert.assertEquals(1, highestPaidEmployees.size());
		Assert.assertEquals(employee3, highestPaidEmployees.get(0));
	}

	@Test
	public void testFindEmployeesByJobTitle() {
		List<Employee> engineers = employeeManager.findEmployeesByJobTitle("Engineer");
		Assert.assertEquals(1, engineers.size());
		Assert.assertEquals(employee1, engineers.get(0));
	}
}
