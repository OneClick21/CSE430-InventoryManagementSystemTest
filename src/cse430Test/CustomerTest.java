package cse430Test;

import cse430.Customer;
import cse430.Product;
import cse430.CustomerStatus;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Map;

public class CustomerTest {
    
	Customer customer = new Customer(1, "John Doe", "john@example.com", "123 Main St");
	Product product1 = new Product(1, "Gun", 100.00, 1, "Toy", LocalDate.of(2024, 12, 31));
	Product product2 = new Product(2, "Car", 80.00, 1, "Toy", LocalDate.of(2024, 12, 31));


    @Test
    public void testPurchaseItem() {
        customer.purchaseItem(product1, 2);
        Map<Product, Integer> items = customer.getPurchasedItems();
        Assert.assertTrue(items.containsKey(product1));
        Assert.assertEquals(2, (int) items.get(product1));
    }

    @Test
    public void testReturnItem() {
        customer.purchaseItem(product1, 3);
        customer.returnItem(product1, 1);
        Map<Product, Integer> items = customer.getPurchasedItems();
        Assert.assertEquals(2, (int) items.get(product1));
    }

    @Test
    public void testGetTotalItemsPurchased() {
        customer.purchaseItem(product1, 5);
        customer.purchaseItem(product2, 4);
        Assert.assertEquals(9, customer.getTotalItemsPurchased());
    }

    @Test
    public void testGetTotalAmountSpent() {
        customer.purchaseItem(product1, 4);
        customer.purchaseItem(product2, 2);
        double expected = (4 * product1.getPrice()) + (2 * product2.getPrice());
        Assert.assertEquals(expected, customer.getTotalAmountSpent(), 0.01);
    }

    @Test
    public void testHasPurchasedItem() {
        customer.purchaseItem(product1, 2);
        Assert.assertTrue(customer.hasPurchasedItem(product1));
//        Assert.assertFalse(customer.hasPurchasedItem(product2));
    }

    @Test
    public void testIsFrequentShopper() {
        customer.purchaseItem(new Product(3, "Product3", 10.0, 1, "Toy", LocalDate.of(2024, 12, 31)), 1);
        customer.purchaseItem(new Product(4, "Product4", 10.0, 1, "Toy", LocalDate.of(2024, 12, 31)), 1);
//        customer.purchaseItem(new Product(5, "Product5", 10.0), 1);
//        customer.purchaseItem(new Product(6, "Product6", 10.0), 1);
//        customer.purchaseItem(new Product(7, "Product7", 10.0), 1);
        Assert.assertFalse(customer.isFrequentShopper());
    }

    @Test
    public void testCalculateAveragePurchaseQuantity() {
        customer.purchaseItem(product1, 2);
        customer.purchaseItem(product2, 4);
        double expected = (2 + 4) / 2.0;
        Assert.assertEquals(expected, customer.calculateAveragePurchaseQuantity(), 0.01);
    }

    @Test
    public void testHasHighSpending() {
        customer.purchaseItem(product1, 10);
        Assert.assertTrue(customer.hasHighSpending());
    }
    
    @Test
    public void testAddBalance() {
        customer.addBalance(100.0);
        Assert.assertEquals(100.0, customer.getBalance(), 0.01);
    }
    
    @Test
    public void testRemoveBalance() {
        customer.addBalance(100.0);
        customer.removeBalance(50.0);
        Assert.assertEquals(50.0, customer.getBalance(), 0.01);
    }

    @Test
    public void testSetStatus() {
    	customer.setStatus(CustomerStatus.ACTIVE);
        Assert.assertTrue(customer.isActive());
    }
}
