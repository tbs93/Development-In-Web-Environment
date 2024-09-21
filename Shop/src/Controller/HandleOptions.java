package Controller;

import Model.*;

public class HandleOptions {

	public void executeOption(int option, Employee employee) {
		try {
			switch (option) {
			case 1:
				/*
				 * if (employee instanceof Cashier) { ((Cashier) employee).scanProduct(); } else
				 * if (employee instanceof Admin) { ((Admin) employee).scanProduct(); }
				 */
				employee.scanProduct();
				break;
			case 2:
				/*
				 * if (employee instanceof Cashier) { ((Cashier) employee).printReceipt(); }
				 * else if (employee instanceof Admin) { ((Admin) employee).printReceipt(); }
				 */
				employee.printReceipt();
				break;
			case 3:
				/*
				 * if (employee instanceof Cashier) { ((Cashier) employee).checkInventory(); }
				 * else if (employee instanceof Admin) { ((Admin) employee).checkInventory(); }
				 */
				employee.addProductToInventory();
				break;
			case 4:
				/*
				 * if (employee instanceof Admin) { ((Admin) employee).addProductToInventory();
				 * }
				 */
				employee.checkInventory();
				break;
			case 5:
				/*
				 * if (employee instanceof Admin) { ((Admin)
				 * employee).updateEmployeeInfo(employee, null, null); }
				 */
				employee.addEmployee(employee);
				break;
			case 6://TODO HOW TO GET THE NUMBER OF THHE EMPLOYEE
				int employeeNumber = 0;
				employee.removeEmployee(employeeNumber);
			default:
				System.out.println("Invalid option. Please try again.");
				break;
			}

		} catch (UnsupportedOperationException e) {
			System.out.println(e.getMessage()); // Inform the user
			// The loop continues here, allowing the user to select again.
		}
	}}
