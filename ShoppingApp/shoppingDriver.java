package com.shoppingApp.in;
import java.util.*;

public class shoppingDriver {
	static List<Customer> customers = new ArrayList<>();
	//d.	Each Product will have a different price and name assigned to it.
	// in addition i can add, productType like cosmetics, stationary, blah blah.... and accordingly i can filter
	static List<Product> products = new ArrayList<>();
	//the below stores all the items you choose to order; just store the productID's
	static List<Order> checkOutList = new ArrayList<>();
	
	//the below static block, behaves like a database.
	static {
		//add products of your choice.
		//I'm adding 15 products all together;
		//but in main method, I'm initially loading 5 products 
		//ask question want to load more products-> loadproducts seperate method 
		//each time it loads 5 products each; keep a counter to keep track 1,2,3; 
		//it will be helpful to generate next 5, 10, 15 products likewise
		//in main method, keep a while loop so that in one shot we can add many products; don't have to ask, 
		//want to order another blah blah....
		
		//ADDING PRODUCTS
		//books and stationary
		products.add(new Product(1, "Classmate Premium 6 Subject Notebook - A4", 118.0f));
		products.add(new Product(2, "Power of Now, Ekhart Tolle", 699.0f));
		products.add(new Product(3, "Faber-Castell Textliner - Pack of 5", 92.0f));
		products.add(new Product(4, "Post It Cubes, 200 Sheets,Pink, 3 x 3 inches", 112.0f));
		products.add(new Product(5, "Reynolds Trimax 2 ct Pouch - 1 Blue, 1 Black Gel", 92.0f));
		
		//cosmetics
		products.add(new Product(6, "SUGAR Cosmetics Smudge Me Not Liquid Mini Lipstick", 759.0f));
		products.add(new Product(7, "Maybelline New York Hypercurl Mascara Waterproof", 349.0f));
		products.add(new Product(8, "Himalaya Purifying Neem Face Wash 400ML", 695.0f));
		products.add(new Product(9, "MyGlamm POPXO MINI NAIL KIT", 194.0f));
		products.add(new Product(10, "Maybelline New York Liquid Foundation", 259.0f));
		
		//electronics
		products.add(new Product(11, "boAt Airdopes 141 True Wireless Earbuds", 1098.0f));
		products.add(new Product(12, "New Fastrack Reflex Vybe Smart Watch", 2994.0f));
		products.add(new Product(13, "Samsung Galaxy Z Fold3 5G", 119999.0f));
		products.add(new Product(14, "2020 Apple MacBook Air Laptop", 89990.0f));
		products.add(new Product(15, "Logitech K230 Wireless Keyboard", 1095.0f));

		//clothing
		products.add(new Product(16, "AKA CHIC Women's Regular Jeans", 829.0f));
		products.add(new Product(17, "GoSriKi Women's Cotton Blend Kurta Set", 799.0f));
		products.add(new Product(18, "Levi's Women's Tijuana Sneakers", 1106.0f));
		products.add(new Product(19, "Inc.5 womens 100774 Heeled Sandal", 1095.0f));
		products.add(new Product(20, "FUNDAY FASHION Women's Crepe A-Line Maxi Dress", 416.0f));

		//ADDING CUSTOMERS
		customers.add(new Customer("sultana@gmail.com", "Xypfgios$3p23"));
	}
	//porduct class -> productId, productName, price
	
	public static String loginSignUp() {
		char user;
		String email = "", password;
		Scanner sc = new Scanner(System.in);
		System.out.println("Are you a new user?\n Press y/n");
		user = sc.next().charAt(0);
		System.out.println("Enter your Email-ID.");
		email = sc.next();
		System.out.println("Enter your password");
		password = sc.next();
		if(user == 'y' || user == 'Y') {
			//create new user ask all details and reconfirm the pwd and all
			String tempPassword;
			System.out.println("Re-confirm your password!!");
			tempPassword = sc.next();
			if(password.equals(tempPassword)) {
				customers.add(new Customer(email, password));
				System.out.println("***********************************");
				System.out.println("\n\nWelome to the shopping app!!!\n\n");
				System.out.println("***********************************");
			}
			else {
				System.out.println("The passwords did not match!!!");
				return null; //in this case run this method again ;addCustomer!!
			}
		}
		else if(user == 'n' || user == 'N') {			
			for(Customer c: customers) {
				if(c.getEmailID().equals(email)) {
					if(c.Login(password)) {
						email = c.getEmailID();
					}
					else {
						System.out.println("Password Incorrect");
						return null;
					}
				}
			}
		}
		return email;
	}

	public static void rules() {
		System.out.println("\n\n\nFollow the below steps to buy products of your choice.......\n");
		System.out.println("Specify the 'ProductID' of the item you want to purchase and press ENTER");
		System.out.println("After specifying the ProductID, proceed with any of the following options.");
		System.out.println("1. If you want to buy another item press 'i'");
		System.out.println("2. If you want to check the next page press 'n'");
		System.out.println("3. If you want to proceed towards checkout; press 'c'");
	}
	
	public static float createCheckOutList(String customerEmail, int productID, int globalCounter) {
		for(int i = globalCounter * 5 - 4; i<= globalCounter * 5; i++) {
			//Display the products in fashion....
			Product p = products.get(i - 1);
			if(productID == p.getProductID()) {
				//add details into checkout
				checkOutList.add(new Order(customerEmail, p.getProductID(), p.getProductName(), p.getPrice()));
				return p.getPrice();
			}
			else {
				System.out.println("Enter a valid ProductID as specified above!!!");
			}
		}
		return 0.0f;
	}
	
	public static void main(String[] args) {
		int globalCounter = 1, tempProductID; //re-assign the counter as 1 for new user
		String email = "";
		char proceedFurther = 'n';
		float totalPrice = 0.0f;
		Scanner sc = new Scanner(System.in);
		//*********************all the below code within the while loop
		email = loginSignUp();
		while(email == null) {
			System.out.println("Please re-enter your credentials!!");
			email = loginSignUp(); 
		}
		
		//display the items in amazon app
		while(globalCounter * 5 <= products.size() && (proceedFurther == 'n' || proceedFurther == 'N')) {
			//I'm adding 15 products all together;
			//but in main method, I'm initially loading 5 products 
			//ask question want to load more products-> *****load products seperate method******
			//each time it loads 5 products each; keep a counter to keep track 1,2,3; 
			//it will be helpful to generate next 5, 10, 15 products likewise
			System.out.println("\t\tProceed with your shopping.....\n\n\t\t\tHAPPY SHOPPING..... :)");
			System.out.println("\n\n \t\tProductID\t Product Name\t\t\t\t Price\n\n");
			for(int i = globalCounter * 5 - 4; i<= globalCounter * 5; i++) {
				//Display the products in fashion....
				Product p = products.get(i - 1);
				System.out.println("\t\t   "+p.getProductID()+"\t"+p.getProductName()+"  "+p.getPrice()+"\n");
			}

			//in main method, keep a while loop so that in one shot we can add many products; don't have to ask,
			proceedFurther = 'i';
			//want to order another blah blah....
			//give a while loop to consider the orders; multiple orders at a time
			while(proceedFurther == 'i' || proceedFurther == 'I') {
//				System.out.println("Do you want to buy an item?\n Type y/n as per your choice!!");
//				proceedFurther = sc.next().charAt(0);
				rules();
				tempProductID = sc.nextInt();
				//after taking the productID, we shall create checkoutList
				totalPrice = totalPrice + createCheckOutList(email, tempProductID, globalCounter);
				proceedFurther = sc.next().charAt(0);
			}
//			char proceedFurther = ' ';
			
//			proceedFurther = sc.next().charAt(0);
//			while(proceedFurther != 'n' || proceedFurther != 'N') { // 150-157
//				//take the productID and store it in a variable and add amount and 
//				//addition: to remove an item i can subtract the amount by looping it over the products using productID; 
//				//hence, having productid, customerid stored in the orderlist
////				tempProductID = sc.nextInt();
////				System.out.println("If you want to buy another item, press 'i'");
//				proceedFurther = sc.next().charAt(0);
//			}
			if(proceedFurther == 'c' || proceedFurther == 'C') {
				//break from the while loop of a login wala thing and then; move to the next customer;
				break;
			}
			globalCounter++;
		}
		System.out.println("Would you like to proceed with the CheckOut?\n Press y/n as per your choice!!!");
		char choice = sc.next().charAt(0);
		if(choice == 'y' || choice == 'Y') {
			//display the items you bought during checkout
			//loop over orderList get the productID, loop over products and display their names and prices
		}
		else if(choice == 'n' || choice == 'N'){
			//do you want to remove any prducts from the check out list?
			//take a y/n
			//then enter the productID from the checkout list that has to be removed.
			//addition: at checkout if i want to procced further/ remove any item as that question
			//for loop productID again; seperate method and do the operation
			//subtract from totalAmount and delete that from orderList
		}
		
		//then proceed to checkout. 
		//ask yes/no question;
		
		//if you checkout.
		
		//check for payment modes
		
		//payment modes: cash or card
		
		//card-> double the payment
		
		//once, checkout is done shows totalamount
		
		//confirm payment? if yes, then procced payment
		
		//order confirmed message!
		
		
		//optional: if you want to logout then, go with login... wala code!
		System.out.println("Logging you out of your account... Re-run the code for a new login/ to login again!!!");
	}

}
