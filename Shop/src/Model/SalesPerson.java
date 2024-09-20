package Model;

import java.util.HashSet;
import java.util.Map;

import Services.IDGenerator;

public class SalesPerson extends Employee{

	public SalesPerson(IDGenerator idGenerator, int employeeNumber,String password, String fullName, String phoneNumber, String accountNumber, Branch branch) {
	        super(idGenerator, employeeNumber,password, fullName, phoneNumber, accountNumber, branch,EmployeeType.SALESPERSON);
	        availableOptions = new HashSet<>();
	        availableOptions.add(Option.SCAN_PRODUCT);
	        availableOptions.add(Option.PRINT_RECEIPT);
	        availableOptions.add(Option.ADD_PRODUCT_TO_INVENTORY);
	        availableOptions.add(Option.CHECK_INVENTORY);
	 }
	
	@Override
    public void setBranch(Branch branch) {
        throw new UnsupportedOperationException("SalesPerson cannot change the branch.");
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
 
	@Override    
 	public void scanProduct() {
        if (canPerform(Option.SCAN_PRODUCT)) {
            System.out.println("Salesperson is performing a scan.");
        }
    }

    @Override
    public void printReceipt() {
        if (canPerform(Option.PRINT_RECEIPT)) {
            System.out.println("Salesperson is generating a receipt.");
        }
    }

    @Override
    public void addProductToInventory() {
        if (canPerform(Option.ADD_PRODUCT_TO_INVENTORY)) {
            System.out.println("Salesperson is adding product to inventory.");
        }
    }

    @Override
    public void checkInventory() {
        System.out.println("Salesperson is checking inventory.");
    }

    // Salesperson cannot manage employees
    @Override
    public void addEmployee(Employee employee) {
        throw new UnsupportedOperationException("Salesperson cannot add employees.");
    }

    @Override
    public void removeEmployee(int employeeNumber) {
        throw new UnsupportedOperationException("Salesperson cannot remove employees.");
    }

    @Override
    public void updateEmployeeInfo(Employee employee, Map<String, String> updates, Branch branch) {
        throw new UnsupportedOperationException("Salesperson cannot update employee info.");
	    }
}
