package Model;

import Services.IDGenerator;

public class SalesPerson extends Employee{

	 public SalesPerson(IDGenerator idGenerator, int employeeNumber,String password, String fullName, String phoneNumber, String accountNumber, Branch branch) {
	        super(idGenerator, employeeNumber,password, fullName, phoneNumber, accountNumber, branch,EmployeeType.SALESPERSON);
	}

	@Override
	public void showDetails() {
		System.out.println("SalesPerson Details:");
        System.out.println("Employee Number: " + getEmployeeNumber());
        System.out.println("Full Name: " + getFullName());
        System.out.println("Phone: " + getPhoneNumber());
        System.out.println("Account: " + getAccountNumber());
        System.out.println("Branch: " + branch.getBranchName());
	}
}
