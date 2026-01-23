package com.wipro.bss.service;
import java.util.ArrayList;
import com.wipro.bss.entity.*;
import com.wipro.bss.util.*;
public class BillingService {
    ArrayList<User> users;
    ArrayList<Product> products;
    ArrayList<Bill> bills;
    int billNo = 1;
    public BillingService(ArrayList<User> users,ArrayList<Product> products,ArrayList<Bill> bills) {
        this.users = users;
        this.products = products;
        this.bills = bills;
    }
    public void validateUser(String userId) throws InvalidUserException {
        for (User u : users)
            if (u.getUserId().equals(userId)) return;
        throw new InvalidUserException();
    }
    public Product findProduct(String pid) throws ProductNotFoundException {
        for (Product p : products)
            if (p.getProductId().equals(pid)) return p;
        throw new ProductNotFoundException();
    }
    public Bill generateBill(String userId, ArrayList<BillItem> items)throws InvalidUserException, ProductNotFoundException,OutOfStockException, BillingOperationException {
        if (items == null || items.size() == 0)
            throw new BillingOperationException();
        validateUser(userId);
        double total = 0;
        for (BillItem i : items) {
            Product p = findProduct(i.getProductId());
            if (p.getStock() < i.getQuantity())
                throw new OutOfStockException();
            total += p.getPrice() * i.getQuantity();
            p.setStock(p.getStock() - i.getQuantity());
        }
        Bill b = new Bill();
        b.setBillId("B" + billNo++);
        b.setUserId(userId);
        b.setItems(items);
        b.setTotalAmount(total);
        bills.add(b);
        return b;
    }
    public void cancelBill(String billId) throws BillNotFoundException, ProductNotFoundException {
        for (Bill b : bills) {
            if (b.getBillId().equals(billId)) {
                for (BillItem i : b.getItems()) {
                    Product p = findProduct(i.getProductId());
                    p.setStock(p.getStock() + i.getQuantity());
                }
                bills.remove(b);
                return;
            }
        }
        throw new BillNotFoundException();
    }
    public void printUserBills(String userId) {
        for (Bill b : bills)
            if (b.getUserId().equals(userId))
                System.out.println(b.getBillId() + " : " + b.getTotalAmount());
    }
}
