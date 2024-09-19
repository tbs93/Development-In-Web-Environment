package Services;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import Model.Branch;
import Model.Employee;

public class CreateEmployee {
    private String fileName; 

    public CreateEmployee(Employee employee) {
        this.fileName = FileConstants.EMPLOYEES_FILE_NAME;

        // Validate employee details before writing
        if (isEmployeeValid(employee)) {
            writeEmployeeToFile(employee);
        } else {
            System.out.println("Employee creation failed: Duplicate details found.");
        }
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
            // This is an issue related to file access, not validation logic
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
