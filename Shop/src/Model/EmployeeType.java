package Model;

public enum EmployeeType {
	
	  ADMIN,
	  SALESPERSON,
	  CASHIER;
	  
	  public static EmployeeType fromString(String type) {
	        try {
	            return EmployeeType.valueOf(type.toUpperCase()); // Convert string to uppercase and match enum
	        } catch (IllegalArgumentException e) {
	            throw new IllegalArgumentException("Invalid employee type: " + type);
	        }
	    }
}
