package Main;

import java.time.LocalDateTime;
import java.util.ArrayList;

import Controller.Menu;
import Model.Admin;
import Model.Branch;
import Model.Cashier;
import Model.Employee;
import Model.EmployeeType;
import Model.Product;
import Model.Receipt;
import Services.CreateEmployee;
import Services.FileReceiptWriter;
import Services.IDGenerator;
import Services.ReceiptIDGenerator;

public class Main {
    public static void main(String[] args) {

		/*
		 * cashier = new Cashier(idGenerator, 124, "Valentine K", "123-426-7890",
		 * "ARR#33", branch); // Replace with actual Employee instance
		 * ArrayList<Product> products = new ArrayList<>(); products.add(new Product(66,
		 * "Product66", "Description66", 10.0, 2)); products.add(new Product(16,
		 * "Product16", "Description16", 5.0, 1)); double total = 29.0; String payment =
		 * "Credit Card"; double paid = 45.0; LocalDateTime date = LocalDateTime.now();
		 * 
		 * // Create a new receipt Receipt receipt = new Receipt(idGenerator, cashier,
		 * products, total, payment, paid, date);
		 * 
		 * // Write the receipt to the file receiptWriter.writeReceipt(receipt);
		 */    
    	Menu menu = new Menu();

    	// Display the menu
    	menu.display();
    }
}
