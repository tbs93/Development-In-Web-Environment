package Model;

import java.util.ArrayList;

public class Category {
	
	private int ID;
	private ArrayList<Product> prodcuts;
	private String name;
	private String description;
	
	public Category() {
		
	}
	
	public Category(int ID, ArrayList<Product> products, String name, String description) {
		this.ID = ID;
		this.prodcuts = products;
		this.name = name;
		this.description = description;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public ArrayList<Product> getProdcuts() {
		return prodcuts;
	}

	public void setProdcuts(ArrayList<Product> prodcuts) {
		this.prodcuts = prodcuts;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
