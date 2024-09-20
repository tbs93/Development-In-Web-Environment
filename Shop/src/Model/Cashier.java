package Model;

import Services.IDGenerator;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Cashier extends Employee {

    public Cashier(IDGenerator idGenerator, int employeeNumber, String password, String fullName, String phoneNumber, String accountNumber, Branch branch) {
        super(idGenerator, employeeNumber, password, fullName, phoneNumber, accountNumber, branch, EmployeeType.CASHIER);
        // Initialize available options for Cashier
        availableOptions = new HashSet<>();
        availableOptions.add(Option.SCAN_PRODUCT);
        availableOptions.add(Option.PRINT_RECEIPT);
        availableOptions.add(Option.CHECK_INVENTORY);
    }

    @Override
    public void setBranch(Branch branch) {
        throw new UnsupportedOperationException("Cashiers cannot change the branch.");
    }
    
    @Override
    public void showDetails() {
        System.out.println("Cashier Details:");
        System.out.println("Employee Number: " + getEmployeeNumber());
        System.out.println("Full Name: " + getFullName());
        System.out.println("Phone: " + getPhoneNumber());
        System.out.println("Account: " + getAccountNumber());
        if (branch != null) {
            System.out.println("Branch: " + branch.getBranchName());
        } else {
            System.out.println("Branch: None");
        }
    }

    @Override
    public void scanProduct() {
    	if (canPerform(Option.SCAN_PRODUCT)) {
            System.out.println("Cashier is performing a scan.");
        } else {
            throw new UnsupportedOperationException("This action is not available for Cashier.");
        }
    }

    @Override
    public void printReceipt() {
    	if (canPerform(Option.PRINT_RECEIPT)) {
            System.out.println("Cashier is generating a receipt.");
        } else {
            throw new UnsupportedOperationException("This action is not available for Cashier.");
        }
    }
    
    @Override
    public void checkInventory() {
    	if (canPerform(Option.CHECK_INVENTORY)) {
            System.out.println("Cashier is checking the inventory...");
        } else {
            throw new UnsupportedOperationException("This action is not available for Cashier.");
        }
    }
    
    @Override
    public void addProductToInventory() {
    	throw new UnsupportedOperationException("Cashiers cannot add product to inventory.");
        }
    
    @Override
    public void addEmployee(Employee employee) {
        throw new UnsupportedOperationException("Cashiers cannot add employees.");
    }

    @Override
    public void removeEmployee(int employeeNumber) {
        throw new UnsupportedOperationException("Cashiers cannot remove employees.");
    }

    @Override
    public void updateEmployeeInfo(Employee employee, Map<String, String> updates, Branch branch) {
        throw new UnsupportedOperationException("Cashiers cannot update employee info.");
    }
}
       
