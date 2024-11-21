package cse430Test;

import cse430.*;
import org.junit.Assert;
import org.junit.Test;
import java.time.LocalDate;
import java.util.Map;

public class CustomerTest {
    
    
	Customer customer = new Customer(1, "John Doe", "john@example.com", "123 Main St");
	Product product = new Product(1, "Gun", 100.00, 1, "Toy", LocalDate.of(2024, 12, 31));


    @Test
    public void testPurchaseItem() {
        customer.purchaseItem(product, 2);
        Map<Product, Integer> items = customer.getPurchasedItems();
        Assert.assertTrue(items.containsKey(product));
        Assert.assertEquals(2, (int) items.get(product));
    }

//    @Test
//    public void testReturnItem() {
//        customer.purchaseItem(product1, 2);
//        customer.returnItem(product1, 1);
//        Map<Product, Integer> items = customer.getPurchasedItems();
//        Assert.assertEquals(1, (int) items.get(product1));
//    }
//
//    @Test
//    public void testGetTotalItemsPurchased() {
//        customer.purchaseItem(product1, 2);
//        customer.purchaseItem(product2, 3);
//        Assert.assertEquals(5, customer.getTotalItemsPurchased());
//    }
//
//    @Test
//    public void testGetTotalAmountSpent() {
//        customer.purchaseItem(product1, 2);
//        customer.purchaseItem(product2, 3);
//        double expected = (2 * product1.getPrice()) + (3 * product2.getPrice());
//        Assert.assertEquals(expected, customer.getTotalAmountSpent(), 0.01);
//    }
//
//    @Test
//    public void testHasPurchasedItem() {
//        customer.purchaseItem(product1, 2);
//        Assert.assertTrue(customer.hasPurchasedItem(product1));
//        Assert.assertFalse(customer.hasPurchasedItem(product2));
//    }
//
//    @Test
//    public void testIsFrequentShopper() {
//        customer.purchaseItem(new Product(3, "Product3", 10.0), 1);
//        customer.purchaseItem(new Product(4, "Product4", 10.0), 1);
//        customer.purchaseItem(new Product(5, "Product5", 10.0), 1);
//        customer.purchaseItem(new Product(6, "Product6", 10.0), 1);
//        customer.purchaseItem(new Product(7, "Product7", 10.0), 1);
//        Assert.assertTrue(customer.isFrequentShopper());
//    }
//
//    @Test
//    public void testCalculateAveragePurchaseQuantity() {
//        customer.purchaseItem(product1, 2);
//        customer.purchaseItem(product2, 4);
//        double expected = (2 + 4) / 2.0;
//        Assert.assertEquals(expected, customer.calculateAveragePurchaseQuantity(), 0.01);
//    }
//
//    @Test
//    public void testHasHighSpending() {
//        customer.purchaseItem(product1, 10);
//        Assert.assertTrue(customer.hasHighSpending());
//    }
//
//    @Test
//    public void testAddAndRemoveBalance() {
//        customer.addBalance(100.0);
//        Assert.assertEquals(100.0, customer.getBalance(), 0.01);
//        customer.removeBalance(50.0);
//        Assert.assertEquals(50.0, customer.getBalance(), 0.01);
//        customer.removeBalance(100.0); // Insufficient balance
//        Assert.assertEquals(50.0, customer.getBalance(), 0.01);
//    }
//
//    @Test
//    public void testSetStatus() {
//        customer.setStatus(CustomerStatus.ACTIVE);
//        Assert.assertTrue(customer.isActive());
//    }
}
