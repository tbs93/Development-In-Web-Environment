package Model;

public class ReturnedBuyer extends Buyer 
{
	public ReturnedBuyer(String fullName, String id, String phoneNumber) {
        super(fullName, id, phoneNumber, 5); // 5% discount for returned buyers
    }

    @Override
    public void displayPurchaseProgram() {
        System.out.println(fullName + " is a Returned Buyer with a 5% discount.");
    }
}
