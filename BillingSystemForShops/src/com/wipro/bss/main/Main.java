package com.wipro.bss.main;
import java.util.ArrayList; 
import com.wipro.bss.entity.*; 
import com.wipro.bss.service.BillingService; 
import com.wipro.bss.util.*;
public class Main {
	  public static void main(String[] args) { 
	        ArrayList<User> users = new ArrayList<>(); 
	        users.add(new User("U001", "Rahul", "9876543210")); 
	        users.add(new User("U002", "Sana", "9123456780")); 
	 
	        ArrayList<Product> products = new ArrayList<>(); 
	        products.add(new Product("P101", "Rice Bag", 1200.0, 30)); 
	        products.add(new Product("P202", "Cooking Oil", 170.0, 50)); 
	 
	        ArrayList<Bill> bills = new ArrayList<>(); 
	 
	        BillingService service = new BillingService(users, products, bills); 
	 
	        try { 
	            ArrayList<BillItem> items = new ArrayList<>(); 
	            items.add(new BillItem("P101", 1)); 
	            items.add(new BillItem("P202", 3)); 
	 
	            Bill b1 = service.generateBill("U001", items); 
	            System.out.println("Bill Generated: " + b1.getBillId()); 
	 
	            System.out.println("\n--- Customer Bills (U001) ---"); 
	            service.printUserBills("U001"); 
	 
	            System.out.println("\nCancelling Bill..."); 
	            service.cancelBill(b1.getBillId()); 
	            System.out.println("Bill Cancelled!"); 
	 
	        } catch (InvalidUserException | ProductNotFoundException | 
	                 OutOfStockException | BillNotFoundException | 
	                 BillingOperationException ex) { 
	            System.out.println(ex); 
	        } 
	        catch (Exception ex) { 
	            System.out.println("Unexpected Error: " + ex); 
	        } 
	    }

}
