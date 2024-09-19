package Main;

import java.time.LocalDateTime;
import java.util.ArrayList;

import Model.Cashier;
import Model.Employee;
import Model.Product;
import Model.Receipt;
import Services.FileReceiptWriter;
import Services.ReceiptIDGenerator;

public class Main {
    public static void main(String[] args) {
        // Initialize the ID generator and receipt writer
        ReceiptIDGenerator idGenerator = new ReceiptIDGenerator();
        FileReceiptWriter receiptWriter = new FileReceiptWriter();
        
        // Sample data
        Cashier cashier = new Cashier(3, 123, "Tzvi Shalmiev", "123-426-7890", "ARR#33"); // Replace with actual Employee instance
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(11, "Product11", "Description11", 10.0, 2));
        products.add(new Product(3, "Product3", "Description3", 5.0, 1));
        double total = 42.0;
        String payment = "Credit Card";
        double paid = 45.0;
        LocalDateTime date = LocalDateTime.now();

        // Create a new receipt
        Receipt receipt = new Receipt(idGenerator, cashier, products, total, payment, paid, date);

        // Write the receipt to the file
        receiptWriter.writeReceipt(receipt);

        // Print a confirmation message
        System.out.println("Receipt written to file. Receipt ID: " + receipt.getID());
    }
}
