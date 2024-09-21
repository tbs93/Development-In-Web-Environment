package Controller;

import java.util.Scanner;
import Model.*;
import Services.*;

public class Menu {

    private Scanner scanner;
    private DisplayOptions displayOptions;
    private HandleOptions handleOptions;

    public Menu() {
        scanner = new Scanner(System.in);
        displayOptions = new DisplayOptions();
        handleOptions = new HandleOptions();
    }

    public void display() {
        System.out.println("Welcome to the Employee Management System!");
        System.out.print("Enter your Employee Number: ");
        int employeeNumber = scanner.nextInt();
        System.out.print("Enter your Password: ");
        String password = scanner.next(); // You might want to use a secure method for passwords

        // Create a Login instance and validate login
        Login login = new Login(employeeNumber, password);
        if (login.validateLogin()) {
            Employee employee = login.getEmployee();
            System.out.println("Login successful! Welcome, " + employee.getFullName() + "!");
            employee.showDetails();

            // Display available options based on employee type
            displayOptions.showOptions(employee);
            int chosenOption = scanner.nextInt();

            // Handle the chosen option
            handleOptions.executeOption(chosenOption, employee);
        } else {
            System.out.println("Login failed. Please check your credentials.");
        }
    }
}
