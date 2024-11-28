package cse430Test;

import cse430.Customer;
import cse430.CustomerManager;
import cse430.CustomerStatus;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

public class CustomerManagerTest {
	
	CustomerManager customerManager;
	Customer customer1;
	Customer customer2;
	Customer customer3;

	@Before
	public void setUp() {
		customerManager = new CustomerManager();
		customer1 = new Customer(1, "John Doe", "john@example.com", "123 Street");
		customer2 = new Customer(2, "Jane Doe", "jane@example.com", "456 Avenue");
		customerManager.addCustomer(customer1);
		customerManager.addCustomer(customer2);
	}

	@Test
	public void testAddCustomer() {
		customer3 = new Customer(3, "Jim Beam", "jim@example.com", "789 Boulevard");
		customerManager.addCustomer(customer1);
		customerManager.addCustomer(customer2);
		customerManager.addCustomer(customer3);
		Assert.assertEquals(3, customerManager.getTotalCustomers());
	}

	@Test
	public void testRemoveCustomer() {
		customerManager.addCustomer(customer1);
		customerManager.addCustomer(customer2);
		Assert.assertTrue(customerManager.removeCustomer(1));
		Assert.assertEquals(1, customerManager.getTotalCustomers());
	}

	@Test
	public void testFindCustomerById() {
		Assert.assertEquals(customer1, customerManager.findCustomerById(1));
	}

	@Test
	public void testUpdateCustomerEmail() {
		Assert.assertTrue(customerManager.updateCustomerEmail(1, "new.email@example.com"));
		Assert.assertEquals("new.email@example.com", customer1.getEmail());
	}

	@Test
	public void testUpdateCustomerAddress() {
		Assert.assertTrue(customerManager.updateCustomerAddress(1, "New Address"));
		Assert.assertEquals("New Address", customer1.getAddress());
	}

	@Test
	public void testCalculateTotalCustomerBalance() {
		Assert.assertEquals(0.0, customerManager.calculateTotalCustomerBalance(), 0.001);
	}

//	@Test
//	public void testFindCustomerWithHighestPurchaseAmount() {
//		Assert.assertEquals(customer1, customerManager.findCustomerWithHighestPurchaseAmount());
//	}

//	@Test
//	public void testUpdateCustomerStatus() {
//		customer1.setTotalPurchases(600);
//		customerManager.updateCustomerStatus();
//		Assert.assertEquals(CustomerStatus.PREMIUM, customer1.getStatus());
//	}

//	@Test
//	public void testRemoveInactiveCustomers() {
//		customer1.isInactive();
//		customerManager.removeInactiveCustomers();
//		Assert.assertEquals(1, customerManager.getTotalCustomers());
//	}

//	@Test
//	public void testCalculateAveragePurchaseAmount() {
//		customer1.setTotalPurchases(500);
//		customer2.setTotalPurchases(1500);
//		Assert.assertEquals(1000.0, customerManager.calculateAveragePurchaseAmount(), 0.001);
//	}
}
