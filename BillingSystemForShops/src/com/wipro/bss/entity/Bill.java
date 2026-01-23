package com.wipro.bss.entity;
import java.util.ArrayList;
public class Bill {
	private String billId;
	private String userId;
	private ArrayList<BillItem>items;
	private double totalAmount;
	public Bill() {
    }
	public Bill(String billId, String userId, ArrayList<BillItem> items, double totalAmount) {
		super();
		this.billId = billId;
		this.userId = userId;
		this.items = items;
		this.totalAmount = totalAmount;
	}
	public String getBillId() {
		return billId;
	}
	public void setBillId(String billId) {
		this.billId = billId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public ArrayList<BillItem> getItems() {
		return items;
	}
	public void setItems(ArrayList<BillItem> items) {
		this.items = items;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
}
