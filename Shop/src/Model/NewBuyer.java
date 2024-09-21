package Model;

public class NewBuyer extends Buyer{
	public NewBuyer(String fullName, String id, String phoneNumber) {
        super(fullName, id, phoneNumber, 0); // No discount for new buyers
    }

    @Override
    public void displayPurchaseProgram() {
        System.out.println(fullName + " is a New Buyer with a regular purchase program (no discounts).");
    }
}
