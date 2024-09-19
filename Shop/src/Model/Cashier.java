package Model;

import Services.IDGenerator;

public class Cashier extends Employee {

    public Cashier(IDGenerator idGenerator, int employeeNumber, String password, String fullName, String phoneNumber, String accountNumber, Branch branch) {
        super(idGenerator, employeeNumber,password, fullName, phoneNumber, accountNumber, branch, EmployeeType.CASHIER);
    }

	@Override
	public void showDetails() {
		System.out.println("Cashier Details:");
        System.out.println("Employee Number: " + getEmployeeNumber());
        System.out.println("Full Name: " + getFullName());
        System.out.println("Phone: " + getPhoneNumber());
        System.out.println("Account: " + getAccountNumber());
        System.out.println("Branch: " + branch.getBranchName());
	}

}
