package Model;

import java.io.*;
import java.util.Scanner;


public abstract class Buyer {
	protected String fullName;
    protected String id;
    protected String phoneNumber;
    protected double discount; // Discount or extra fees

    public Buyer(String fullName, String id, String phoneNumber, double discount) {
        this.fullName = fullName;
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.discount = discount;
    }

    public String getId() {
        return id;
    }

    public double getDiscount() {
        return discount;

    }


public abstract void displayPurchaseProgram();
//Method to display buyer information
public void displayInfo() {
    System.out.println("Full Name: " + fullName);
    System.out.println("ID: " + id);
    System.out.println("Phone Number: " + phoneNumber);
    System.out.println("Discount: " + discount + "%");
}

// Method to save buyer info to a text file
public void saveToFile(String filename) {
    try (FileWriter fw = new FileWriter(filename, true); BufferedWriter bw = new BufferedWriter(fw)) {
        bw.write(fullName + "," + id + "," + phoneNumber + "," + discount + "\n");
    } catch (IOException e) {
        System.out.println("An error occurred while saving buyer data.");
        e.printStackTrace();
    }
}
}
