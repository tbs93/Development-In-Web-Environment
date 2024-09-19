package Model;

public abstract class Employee {
	
	protected int ID;
	protected int employeeNumber;
	protected String fullName;
	protected String phoneNumber;
	protected String accountNumber;
	protected Option[] options;
	//TODO employeeRole
	//TODO branch relation
	
	public Employee() {
		
	}
	
	public Employee(int ID, int employeeNumber, String fullName, String phoneNumber, String accountNumber) {
		
		this.ID = ID;
		this.employeeNumber = employeeNumber;
		this.fullName = fullName;
		this.phoneNumber = phoneNumber;
		this.accountNumber = accountNumber;
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
	
	
	
	
}
