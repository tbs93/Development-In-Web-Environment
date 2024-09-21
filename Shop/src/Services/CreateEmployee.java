package Services;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import Model.Admin;
import Model.Branch;
import Model.Cashier;
import Model.Employee;
import Model.EmployeeType;
import Model.SalesPerson;

public class CreateEmployee {
    private String fileName;

    public CreateEmployee() {
        this.fileName = FileConstants.EMPLOYEES_FILE_NAME;
    }

    public void addEmployeeFromInput() {
    	 
        Scanner scanner = new Scanner(System.in);

        // Prompt for employee details
        System.out.print("Employee Number: ");
        String employeeNumber = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        System.out.print("Full Name: ");
        String fullName = scanner.nextLine();

        System.out.print("Phone Number: ");
        String phoneNumber = scanner.nextLine();

        // Assuming Account Number can be null or a string
        System.out.print("Account Number: ");
        String accountNumber = scanner.nextLine();
        if (accountNumber.isEmpty()) {
            accountNumber = null; // Handle null as needed
        }

        System.out.print("Branch ID: ");
        int branchID = Integer.parseInt(scanner.nextLine());

        System.out.print("Branch Name: ");
        String branchName = scanner.nextLine();

        System.out.print("Branch City: ");
        String branchCity = scanner.nextLine();

        System.out.print("Branch Address: ");
        String branchAddress = scanner.nextLine();

        System.out.print("Employee Type (CASHIER, SALESPERSON, ADMIN): ");
        String employeeTypeInput = scanner.nextLine();
        EmployeeType employeeType = EmployeeType.valueOf(employeeTypeInput.toUpperCase()); // Assuming EmployeeType is an enum

        // Create the Employee object
        Branch branch = new Branch(branchID, branchName, branchCity, branchAddress,null ,null);
        //Employee employee = new Employee(employeeNumber, password, fullName, phoneNumber, accountNumber, branch, employeeType);
        // Create the specific Employee type based on user input
        Employee employee;
        IDGenerator idGenerator = null;
        int empNumber = Integer.parseInt(employeeNumber);
        switch (employeeType) {
        	
            case CASHIER:
                employee = new Cashier(idGenerator,empNumber, password, fullName, phoneNumber, accountNumber, branch);
                break;
            case SALESPERSON:
                employee = new SalesPerson(idGenerator,empNumber, password, fullName, phoneNumber, accountNumber, branch);
                break;
            case ADMIN:
                employee = new Admin(idGenerator,empNumber, password, fullName, phoneNumber, accountNumber, branch);
                break;
            default:
                System.out.println("Invalid employee type.");
                scanner.close();
                return; // Exit if the type is invalid
        }
        // Validate and create the employee in the file
        if (isEmployeeValid(employee)) {
            writeEmployeeToFile(employee);
            System.out.println("Employee created successfully!");
        } else {
            System.out.println("Failed to create employee: Duplicate details found.");
        }

        scanner.close();
    }

    private boolean isEmployeeValid(Employee employee) {
        // Try to read the employee file and check for duplicates
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("Employee Number: " + employee.getEmployeeNumber())) {
                    System.out.println("Employee creation failed: Duplicate Employee Number found.");
                    return false; // Duplicate Employee Number found
                }
                if (line.contains("Phone Number: " + employee.getPhoneNumber())) {
                    System.out.println("Employee creation failed: Duplicate Phone Number found.");
                    return false; // Duplicate Phone Number found
                }
                if (line.contains("Account Number: " + employee.getAccountNumber())) {
                    System.out.println("Employee creation failed: Duplicate Account Number found.");
                    return false; // Duplicate Account Number found
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the employee file: " + e.getMessage());
            return false; // Assume employee is not valid if file access fails
        }
        return true; // No duplicates found, employee is valid
    }

    private void writeEmployeeToFile(Employee employee) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write("Employee ID: " + employee.getID() + "\n");
            writer.write("Employee Number: " + employee.getEmployeeNumber() + "\n");
            writer.write("Password: " + employee.getPassword() + "\n");
            writer.write("Full Name: " + employee.getFullName() + "\n");
            writer.write("Phone Number: " + employee.getPhoneNumber() + "\n");
            writer.write("Account Number: " + employee.getAccountNumber() + "\n");
            // Writing branch details
            Branch branch = employee.getBranch();
            if (branch != null) {
                writer.write("Branch ID: " + branch.getID() + "\n");
                writer.write("Branch Name: " + branch.getBranchName() + "\n");
                writer.write("Branch City: " + branch.getBranchCity() + "\n");
                writer.write("Branch Address: " + branch.getBranchAdress() + "\n");
            } else {
                writer.write("Branch: None\n");
            }

            writer.write("Employee Type: " + employee.getEmployeeType().name() + "\n");
            writer.write("===================================\n");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
}
