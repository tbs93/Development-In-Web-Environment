package Model;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import Services.FileConstants;
import Services.IDGenerator;

public abstract class Employee {

	protected int ID;
	protected int employeeNumber;
	protected String fullName;
	protected String phoneNumber;
	protected String accountNumber;
	protected Set<Option> availableOptions;
	protected Branch branch;
	protected String password;
	protected EmployeeType employeeType;

	public Employee() {
		this.availableOptions = new HashSet<>();
	}

	public Employee(IDGenerator idGenerator, int employeeNumber,String password, String fullName, String phoneNumber, String accountNumber, Branch branch, EmployeeType employeeType) {

		this.ID = IDGenerator.getNextID(FileConstants.EMPLOYEES_FILE_NAME);
		this.employeeNumber = employeeNumber;
		this.fullName = fullName;
		this.phoneNumber = phoneNumber;
		this.accountNumber = accountNumber;
		this.branch = branch;
		this.password = password;
		this.employeeType = employeeType;
		this.availableOptions = new HashSet<>();
	}

	public Branch getBranch() {
		return branch;
	}

	public abstract void setBranch(Branch branch);

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public EmployeeType getEmployeeType() {
		return employeeType;
	}

	public Set<Option> getAvailableOptions() {
		return availableOptions;
	}

	public boolean canPerform(Option option) {
		return availableOptions.contains(option);
	}

	public abstract void showDetails();

	public abstract void scanProduct();
	public abstract void printReceipt();
	public abstract void addProductToInventory();
	public abstract void checkInventory();
	public abstract void addEmployee(Employee employee);
	public abstract void removeEmployee(int employeeNumber);
	public abstract void updateEmployeeInfo(Employee employee, Map<String, String> updates, Branch branch);

}
