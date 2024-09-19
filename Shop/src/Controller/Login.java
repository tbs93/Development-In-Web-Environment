package Controller;

import Services.EmployeeService;
import Services.FileConstants;
import Model.Employee;

public class Login {
    private int employeeNumber;
    private String password;
    private Employee employee;
    private EmployeeService employeeService;

    public Login(int employeeNumber, String password) {
        this.employeeNumber = employeeNumber;
        this.password = password;
        this.employeeService = new EmployeeService(FileConstants.EMPLOYEES_FILE_NAME);
    }

    public boolean validateLogin() {
        try {
            // Attempt to retrieve the existing employee
            Employee existingEmployee = employeeService.getEmployeeByNumber(employeeNumber);
            
            // Check if the employee exists
            if (existingEmployee == null) {
                System.out.println("Error: Employee number does not exist."); // Number doesn't exist
                return false;
            }

            // Validate the password
            if (existingEmployee.getPassword().equals(password)) {
                this.employee = existingEmployee; // Store the authenticated employee
                return true; // Login is valid
            } else {
                System.out.println("Error: Incorrect password."); // Incorrect password
                return false; // Invalid login: incorrect password
            }

        } catch (Exception e) {
            // Handle any unexpected exceptions
            System.out.println("An error occurred during login validation: " + e.getMessage());
            return false;
        }
    }

    public Employee getEmployee() {
        return employee;
    }
    
}
