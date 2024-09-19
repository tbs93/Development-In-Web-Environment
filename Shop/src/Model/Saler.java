package Model;

public class Saler extends Employee{

	public Saler() {
		this.options = new Option[] {};
	}

	public Saler(int ID, int employeeNumber, String fullName, String phoneNumber, String accountNumber) {

		this.ID = ID;
		this.employeeNumber = employeeNumber;
		this.fullName = fullName;
		this.phoneNumber = phoneNumber;
		this.accountNumber = accountNumber;
		this.options = new Option[] {};
	}
}
