package Services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import Model.Branch;
import Model.Employee;
import Model.EmployeeType;
import Model.Admin; // Import your specific employee classes
import Model.SalesPerson;
import Model.Cashier;

public class EmployeeService {
	private String employeesDB;

	public EmployeeService(String employeesDB) {
		this.employeesDB = employeesDB;
	}

	public Employee getEmployeeByNumber(int employeeNumber) {
		try (BufferedReader reader = new BufferedReader(new FileReader(employeesDB))) {
			String line;
			Employee employee = null;

			while ((line = reader.readLine()) != null) {
				// Check for the employee number
				if (line.contains("Employee Number: " + employeeNumber)) {
					// Read all the relevant details for this employee
					line = reader.readLine(); // Password
					System.out.println("Reading Password from line: " + line); //DEBUG PRINT
					String password = line.split(": ")[1];
					line = reader.readLine(); // Full Name
					System.out.println("Reading Full Name from line: " + line);//DEBUG PRINT
					String fullName = line.split(": ")[1];
					line = reader.readLine(); // Phone Number
					System.out.println("Reading Phone Number from line: " + line);//DEBUG PRINT
					String phoneNumber = line.split(": ")[1];
					line = reader.readLine(); // Account Number
					System.out.println("Reading Account Number from line: " + line);//DEBUG PRINT
					String accountNumber = line.split(": ")[1];

					// Read branch details
					Branch branch = null;
					line = reader.readLine();
					if (!line.contains("None")) 
					{
						try {
							System.out.println("Reading branch ID from line: " + line);//DEBUG PRINT
							int branchId = Integer.parseInt(line.split(": ")[1].trim()); // Ensure this line has the correct format

							line = reader.readLine(); // Expected to be Branch Name
							System.out.println("Reading branch name from line: " + line);//DEBUG PRINT
							String branchName = line.split(": ")[1].trim();

							line = reader.readLine(); // Expected to be Branch City
							System.out.println("Reading branch city from line: " + line);//DEBUG PRINT
							String branchCity = line.split(": ")[1].trim();

							line = reader.readLine(); // Expected to be Branch Address
							System.out.println("Reading branch address from line: " + line);//DEBUG PRINT
							String branchAddress = line.split(": ")[1].trim();

							branch = new Branch(branchId, branchName, branchCity, branchAddress, null, null); // Adjust as needed
						} catch (NumberFormatException e) {
							System.out.println("Error parsing branch ID from line: " + line + " - " + e.getMessage());
						} catch (ArrayIndexOutOfBoundsException e) {
							System.out.println("Error reading branch details from line: " + line + " - " + e.getMessage());
						}
					}

					// Read employee type
					line = reader.readLine(); // Employee Type
					System.out.println("Reading Employee Type from line: " + line);
					String typeString = line.split(": ")[1]; // Get the employee type string

					try {
					    EmployeeType employeeType = EmployeeType.valueOf(typeString); // Convert the string to enum
					    // Create the appropriate employee type
					    if (employeeType == EmployeeType.ADMIN) {
					        employee = new Admin(new IDGenerator(), employeeNumber, password, fullName, phoneNumber, accountNumber, branch);
					    } else if (employeeType == EmployeeType.SALESPERSON) {
					        employee = new SalesPerson(new IDGenerator(), employeeNumber, password, fullName, phoneNumber, accountNumber, branch);
					    } else if (employeeType == EmployeeType.CASHIER) {
					        employee = new Cashier(new IDGenerator(), employeeNumber, password, fullName, phoneNumber, accountNumber, branch);
					    }
					} catch (IllegalArgumentException e) {
					    System.out.println("Invalid employee type: " + typeString); // Handle incorrect data
					}
					
					return employee; // Return the created employee object		
				}
				
			}
		} catch (IOException e) {
		System.out.println("An error occurred while reading the file: " + e.getMessage());
		} catch (NumberFormatException e) {
		System.out.println("Error parsing number from file: " + e.getMessage());
	}

	return null; // Return null if the employee wasn't found or an error occurred
}
}
