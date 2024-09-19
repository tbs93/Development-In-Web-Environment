package Model;

public class Cashier extends Employee {

	public Cashier() {
		this.options = new Option[] {};
	}

	public Cashier(int ID, int employeeNumber, String fullName, String phoneNumber, String accountNumber) {

		this.ID = ID;
		this.employeeNumber = employeeNumber;
		this.fullName = fullName;
		this.phoneNumber = phoneNumber;
		this.accountNumber = accountNumber;
		this.options = new Option[] {};
	}
}
