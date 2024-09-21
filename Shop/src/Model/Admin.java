package Model;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Map;
import Services.CreateEmployee;
import Services.EmployeeService;
import Services.FileConstants;
import Services.IDGenerator;

public class Admin extends Employee {


	public Admin(IDGenerator idGenerator, int employeeNumber,String password,
 String fullName, String phoneNumber, String accountNumber, Branch branch) {
	        super(idGenerator, employeeNumber,password, fullName, phoneNumber, accountNumber, branch,EmployeeType.ADMIN);
	        //availableOptions = new LinkedHashSet<>();
	        availableOptions = EnumSet.noneOf(Option.class);
	        availableOptions.add(Option.SCAN_PRODUCT);
	        availableOptions.add(Option.PRINT_RECEIPT);
	        availableOptions.add(Option.ADD_PRODUCT_TO_INVENTORY);
	        availableOptions.add(Option.CHECK_INVENTORY);
	        availableOptions.add(Option.ADD_EMPLOYEE);
	        availableOptions.add(Option.REMOVE_EMPLOYEE);
	        availableOptions.add(Option.UPDATE_EMPLOYEE_INFO);
	 }
	
	 @Override
	public void setBranch(Branch branch) {
	        this.branch = branch; // Assuming `branch` is a member of the Employee class
	    }
	 
	@Override
	public void showDetails() {
		System.out.println("Admin Details:");
        System.out.println("Employee Number: " + getEmployeeNumber());
        System.out.println("Full Name: " + getFullName());
        System.out.println("Phone: " + getPhoneNumber());
        System.out.println("Account: " + getAccountNumber());
        System.out.println("Branch: " + branch.getBranchName());
	}
	
	 @Override
    public void scanProduct() {
	        System.out.println("Admin is performing a scan.");
	    }

	    @Override
    public void printReceipt() {
        System.out.println("Admin is generating a receipt.");
    }

    @Override
    public void addProductToInventory() {
        System.out.println("Admin is adding product to inventory.");
    }

    @Override
    public void checkInventory() {
        System.out.println("Admin is checking inventory.");
    }

    @Override
    public void addEmployee(Employee employee) {
    	CreateEmployee createEmployeeService = new CreateEmployee();
        createEmployeeService.addEmployeeFromInput();
    	
    }

    @Override
    public void removeEmployee(int employeeNumber) {
        System.out.println("Admin is removing employee number " + employeeNumber);
    }

    @Override
    public void updateEmployeeInfo(Employee employee, Map<String, String> updates, Branch newBranch) {
        EmployeeService employeeService = new EmployeeService(FileConstants.EMPLOYEES_FILE_NAME);
        Employee existingEmployee = employeeService.getEmployeeByNumber(employee.getEmployeeNumber());

        if (existingEmployee != null) {
            // Update employee fields based on the updates map
            if (updates.containsKey("password")) {
                existingEmployee.setPassword(updates.get("password"));
            }
            if (updates.containsKey("fullName")) {
                existingEmployee.setFullName(updates.get("fullName"));
            }
            if (updates.containsKey("phoneNumber")) {
                existingEmployee.setPhoneNumber(updates.get("phoneNumber"));
            }
            if (updates.containsKey("accountNumber")) {
                existingEmployee.setAccountNumber(updates.get("accountNumber"));
            }
            if (newBranch != null) {
                existingEmployee.setBranch(newBranch); // Set the new branch
            }

            // Save the updated employee back to the file
            new CreateEmployee(existingEmployee); // This will handle validation as well
            System.out.println("Employee information updated successfully.");
        } else {
            System.out.println("Employee not found.");
        }
    }

}
