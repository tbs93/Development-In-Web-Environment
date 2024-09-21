package Model;

public class VipBuyer extends Buyer {
	public VipBuyer(String fullName, String id, String phoneNumber) {
        super(fullName, id, phoneNumber, 15); // 15% discount for VIP buyers
    }

    @Override
    public void displayPurchaseProgram() {
        System.out.println(fullName + " is a VIP Buyer with a 15% discount.");
    }

}
