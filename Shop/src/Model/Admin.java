package Model;

public class Admin extends Employee {

	public Admin() {
		this.options = new Option[] {};
	}

	public Admin(int ID, int employeeNumber, String fullName, String phoneNumber, String accountNumber) {

		this.ID = ID;
		this.employeeNumber = employeeNumber;
		this.fullName = fullName;
		this.phoneNumber = phoneNumber;
		this.accountNumber = accountNumber;
		this.options = new Option[] {};
	}
}
