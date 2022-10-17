package com.shoppingApp.in;

public class Product {
	private int productID; //globally given so that to assure unique productId for all
	private String productName;
	private float price;
	
	Product(int productID, String productName, float price){
		this.productID = productID;
		this.productName = productName;
		this.price = price;
	}

	public int getProductID() {
		return productID;
	}

	public String getProductName() {
		return productName;
	}

	public float getPrice() {
		return price;
	}	
	
}
