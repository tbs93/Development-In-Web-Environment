package Model;

import java.util.ArrayList;

public class Branch {
		
	private int ID; 
	private String branchName;
	private String branchCity;
	private String branchAdress;  
	private ArrayList<Employee> employees;
	private ArrayList<Product> productsInventory;
	
	public Branch() {}
	public Branch(int ID, String branchName, String branchCity, String branchAdress, ArrayList<Employee> employees, ArrayList<Product> productsInventory)
	{
		this.ID = ID;
		this.branchName = branchName;
		this.branchCity = branchCity;
		this.branchAdress = branchAdress;
		this.employees = employees;
		this.productsInventory = productsInventory;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getBranchCity() {
		return branchCity;
	}
	public void setBranchCity(String branchCity) {
		this.branchCity = branchCity;
	}
	public String getBranchAdress() {
		return branchAdress;
	}
	public void setBranchAdress(String branchAdress) {
		this.branchAdress = branchAdress;
	}
	public ArrayList<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(ArrayList<Employee> employees) {
		this.employees = employees;
	}
	public ArrayList<Product> getProductsInventory() {
		return productsInventory;
	}
	public void setProductsInventory(ArrayList<Product> productsInventory) {
		this.productsInventory = productsInventory;
	}
	
}
