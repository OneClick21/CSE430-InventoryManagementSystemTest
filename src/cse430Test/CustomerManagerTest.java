package cse430Test;

import cse430.Customer;
import cse430.CustomerManager;
import cse430.Product;
import cse430.CustomerStatus;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class CustomerManagerTest {

	CustomerManager customerManager = new CustomerManager();
	Customer customer1 = new Customer(1, "John Doe", "john.doe@example.com", "123 Street");
	Customer customer2 = new Customer(2, "Jane Smith", "jane.smith@example.com", "456 Avenue");

	@Test
	void testAddCustomer() {
		Customer customer3 = new Customer(3, "Sam Wilson", "sam.wilson@example.com", "789 Road");
		customerManager.addCustomer(customer1);
		customerManager.addCustomer(customer2);
		customerManager.addCustomer(customer3);
		Assert.assertEquals(3, customerManager.getTotalCustomers());
	}

	@Test
	void testRemoveCustomer() {
		Assert.assertTrue(customerManager.removeCustomer(1));
		Assert.assertEquals(1, customerManager.getTotalCustomers());
	}

	@Test
	void testFindCustomerById() {
		Assert.assertEquals(customer1, customerManager.findCustomerById(1));
	}

	@Test
	void testUpdateCustomerEmail() {
		Assert.assertTrue(customerManager.updateCustomerEmail(1, "new.email@example.com"));
		Assert.assertEquals("new.email@example.com", customer1.getEmail());
	}

	@Test
	void testUpdateCustomerAddress() {
		Assert.assertTrue(customerManager.updateCustomerAddress(1, "New Address"));
		Assert.assertEquals("New Address", customer1.getAddress());
	}

	@Test
	void testCalculateTotalCustomerBalance() {
		Assert.assertEquals(0.0, customerManager.calculateTotalCustomerBalance(), 0.001);
	}

	@Test
	void testFindCustomerWithHighestPurchaseAmount() {
		Assert.assertEquals(customer1, customerManager.findCustomerWithHighestPurchaseAmount());
	}

	@Test
	void testUpdateCustomerStatus() {
		customer1.setTotalPurchases(600);
		customerManager.updateCustomerStatus();
		Assert.assertEquals(CustomerStatus.PREMIUM, customer1.getStatus());
	}

	@Test
	void testRemoveInactiveCustomers() {
		customer1.setActive(false);
		customerManager.removeInactiveCustomers();
		Assert.assertEquals(1, customerManager.getTotalCustomers());
	}

	@Test
	void testCalculateAveragePurchaseAmount() {
		customer1.setTotalPurchases(500);
		customer2.setTotalPurchases(1500);
		Assert.assertEquals(1000.0, customerManager.calculateAveragePurchaseAmount(), 0.001);
	}
}
