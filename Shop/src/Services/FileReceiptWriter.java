package Services;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import Model.Product;
import Model.Receipt;

public class FileReceiptWriter implements IReceiptWriter {

    private String fileName;
    
    public FileReceiptWriter() {
    	this.fileName = FileConstants.RECEIPTS_FILE_NAME;
    }

    public FileReceiptWriter(String fileName) throws IllegalArgumentException {
        if (fileName == null || fileName.trim().isEmpty()) {
            throw new IllegalArgumentException("File name cannot be null or empty");
        }
    	this.fileName = FileConstants.RECEIPTS_FILE_NAME;
    }

    @Override
    public void writeReceipt(Receipt receipt) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write("Receipt ID: " + receipt.getID() + "\n");
            writer.write("Cashier: " + receipt.getCashier().getFullName() + "\n");
            writer.write("Products: \n");

            for (Product product : receipt.getProducts()) {
                writer.write("- " + product.getName() + ": " + product.getPrice() + " x " + product.getQty() + "\n");
            }

            writer.write("Total: " + receipt.getTotal() + "\n");
            writer.write("Paid: " + receipt.getPaid() + "\n");
            writer.write("Change: " + receipt.getChange() + "\n");
            writer.write("Payment Method: " + receipt.getPayment() + "\n");
            writer.write("Date: " + receipt.getDate() + "\n");
            writer.write("=======================================\n");

        } catch (IOException e) {
            System.out.println("An error occurred while writing the receipt to file: " + e.getMessage());
        }
    }
}
