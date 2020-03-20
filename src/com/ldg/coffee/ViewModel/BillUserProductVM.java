package com.ldg.coffee.ViewModel;

import com.ldg.coffee.Model.Bill;
import com.ldg.coffee.Model.Product;
import com.ldg.coffee.Model.User;

public class BillUserProductVM {
	private Bill bill;
	private User user;
	private Product product;
	
	
	public BillUserProductVM(Bill bill, User user, Product product) {
		this.bill = bill;
		this.user = user;
		this.product = product;
	}


	public Bill getBill() {
		return bill;
	}


	public void setBill(Bill bill) {
		this.bill = bill;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}
	
	

}
