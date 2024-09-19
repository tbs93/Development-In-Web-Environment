package Model;

import Services.FileConstants;
import Services.IDGenerator;

public abstract class Employee {
	
	protected int ID;
	protected int employeeNumber;
	protected String fullName;
	protected String phoneNumber;
	protected String accountNumber;
	protected Option[] options; //the options available to the employee
	//TODO employeeRole
	protected Branch branch;
	protected String password;
	protected EmployeeType employeeType;
	
	public Employee() {
		
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
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

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

	/*
	 * public void setEmployeeType(EmployeeType employeeType) { this.employeeType =
	 * employeeType; }
	 */

	public abstract void showDetails();
	
	
}
