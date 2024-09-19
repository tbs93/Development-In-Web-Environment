package Model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import Services.IDGenerator;
import Services.FileConstants;

public class Receipt {
	
	private Employee cashier;
	private double change;
	private int ID;
	private double paid;
	private String payment;
	private ArrayList<Product> products;
	private double total;
	private LocalDateTime date;
	

	public Receipt(IDGenerator idGenerator, Employee cashier, ArrayList<Product> products, double total, String payment, double paid, LocalDateTime date)
	{
		this.ID = IDGenerator.getNextID(FileConstants.RECEIPTS_FILE_NAME);
		System.out.println("Generated Receipt ID: " + this.ID); // Debugging line
		this.cashier = cashier;
		this.products = products;
		this.total = total;
		this.payment = payment;
		this.paid = paid;
		this.change = calculateChange();
		this.date = date;
	}

	public Employee getCashier() {
		return cashier;
	}

	public void setCashier(Employee cashier) {
		this.cashier = cashier;
	}

	public double getChange() {
		return change;
	}

	public void setChange(double change) {
		this.change = change;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		this.ID = iD;
	}

	public double getPaid() {
		return paid;
	}

	public void setPaid(double paid) {
		this.paid = paid;
		this.change = calculateChange();
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public ArrayList<Product> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	

	public LocalDateTime getDate() {
		return date;
	}
	

	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	
	public double calculateChange()
	{
		return paid - total;
	}
}
