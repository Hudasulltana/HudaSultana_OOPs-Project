package com.shoppingApp.in;

public class Order {
	//customerEmail, productID, productName, productprice
	private String customerEmail, productName;
	private int productID;
	private float productPrice;
	
	Order(String customerEmail, int productID, String productName, float productPrice){
		this.customerEmail = customerEmail;
		this.productID = productID;
		this.productName = productName;
		this.productPrice = productPrice;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}
	//add all the amount
	public float getProductPrice() {
		return productPrice;
	}

	public int getProductID() {
		return productID;
	}
	
	//whenever the customerEmail is same, display that in checkout
	//just the product details that's it
	
}
