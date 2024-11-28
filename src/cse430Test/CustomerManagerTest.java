package cse430Test;

import cse430.Customer;
import cse430.CustomerManager;
import cse430.CustomerStatus;
import cse430.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.time.LocalDate;

public class CustomerManagerTest {
	private CustomerManager customerManager;
	private Customer customer1;
	private Customer customer2;

	@Before
	public void setUp() {
		customerManager = new CustomerManager();
		customer1 = new Customer(1, "John Doe", "john.doe@example.com", "123 Main St");
		customer2 = new Customer(2, "Jane Smith", "jane.smith@example.com", "456 Oak St");
		customerManager.addCustomer(customer1);
		customerManager.addCustomer(customer2);
	}

	@Test
	public void testAddCustomer() {
		Customer newCustomer = new Customer(3, "Alice Johnson", "alice.johnson@example.com", "789 Pine St");
		customerManager.addCustomer(newCustomer);
		Assert.assertEquals(3, customerManager.getTotalCustomers());
	}

	@Test
	public void testRemoveCustomer() {
		boolean removed = customerManager.removeCustomer(1);
		Assert.assertTrue(removed);
		Assert.assertNull(customerManager.findCustomerById(1));
		Assert.assertEquals(1, customerManager.getTotalCustomers());
	}

	@Test
	public void testFindCustomerById() {
		Customer foundCustomer = customerManager.findCustomerById(1);
		Assert.assertNotNull(foundCustomer);
		Assert.assertEquals(1, foundCustomer.getId());
	}

	@Test
	public void testUpdateCustomerEmail() {
		boolean updated = customerManager.updateCustomerEmail(1, "new.email@example.com");
		Assert.assertTrue(updated);
		Assert.assertEquals("new.email@example.com", customerManager.findCustomerById(1).getEmail());
	}

	@Test
	public void testUpdateCustomerAddress() {
		boolean updated = customerManager.updateCustomerAddress(1, "321 New Address");
		Assert.assertTrue(updated);
		Assert.assertEquals("321 New Address", customerManager.findCustomerById(1).getAddress());
	}

	@Test
	public void testGetTotalCustomers() {
		Assert.assertEquals(2, customerManager.getTotalCustomers());
	}

//	@Test
//	public void testIsPreferredCustomer() {
//		customer1.addBalance(1000);
//		Assert.assertTrue(customerManager.isPreferredCustomer(1));
//	}

	@Test
	public void testCalculateTotalCustomerBalance() {
		customer1.addBalance(500);
		customer2.addBalance(300);
		Assert.assertEquals(800.0, customerManager.calculateTotalCustomerBalance(), 0);
	}

	@Test
	public void testFindCustomerWithHighestPurchaseAmount() {
		customer1.purchaseItem(new Product(101, "Laptop", 1000, 10, "Elc", LocalDate.of(2024, 12, 31)), 1);
		customer2.purchaseItem(new Product(102, "Phone", 500, 15, "Elc", LocalDate.of(2024, 12, 31)), 2);
		Customer highestSpendingCustomer = customerManager.findCustomerWithHighestPurchaseAmount();
		Assert.assertEquals(customer1, highestSpendingCustomer);
	}

	@Test
	public void testUpdateCustomerStatus() {
		customer1.addBalance(6000);
		customer2.addBalance(3000);
		customer1.purchaseItem(new Product(101, "Laptop", 1000, 10, "Elc", LocalDate.of(2024, 12, 31)), 1);
		customer2.purchaseItem(new Product(102, "Phone", 50, 15, "Elc", LocalDate.of(2024, 12, 31)), 2);
		customerManager.updateCustomerStatus();
		Assert.assertEquals(CustomerStatus.PREMIUM, customerManager.findCustomerById(1).getStatus());
		Assert.assertEquals(CustomerStatus.REGULAR, customerManager.findCustomerById(2).getStatus());
	}

//	@Test
//	public void testRemoveInactiveCustomers() {
//		customer1.setStatus(CustomerStatus.INACTIVE);
//		customerManager.removeInactiveCustomers();
//		Assert.assertEquals(1, customerManager.getTotalCustomers());
//	}

	@Test
	public void testCalculateAveragePurchaseAmount() {
		customer1.purchaseItem(new Product(101, "Laptop", 1000, 10, "Elc", LocalDate.of(2024, 12, 31)), 1);
		customer2.purchaseItem(new Product(102, "Phone", 500, 15, "Elc", LocalDate.of(2024, 12, 31)), 2);
		Assert.assertEquals(1000.0, customerManager.calculateAveragePurchaseAmount(), 0);
	}
}
