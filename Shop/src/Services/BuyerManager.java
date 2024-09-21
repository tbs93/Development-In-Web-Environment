package Services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import Model.Buyer;
import Model.NewBuyer;
import Model.ReturnedBuyer;
import Model.VipBuyer;

public class BuyerManager {
	private static final String FILENAME = "buyers.txt"; // File to store buyer information

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("1 - Add new buyer");
        System.out.println("2 - Search buyer by ID and apply discount");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline
        
        switch (choice) {
            case 1:
                addBuyer(scanner);
                break;
            case 2:
                System.out.print("Enter buyer ID to search: ");
                String id = scanner.nextLine();
                searchBuyerById(id);
                break;
            default:
                System.out.println("Invalid option.");
        }
    }

    // Method to add a new buyer and save it to the file
    public static void addBuyer(Scanner scanner) {
        System.out.print("Enter full name: ");
        String name = scanner.nextLine();
        System.out.print("Enter ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phone = scanner.nextLine();
        System.out.print("Enter buyer type (1 - New, 2 - Returned, 3 - VIP): ");
        int type = scanner.nextInt();

        Buyer buyer = null;

        switch (type) {
            case 1:
                buyer = new NewBuyer(name, id, phone);
                break;
            case 2:
                buyer = new ReturnedBuyer(name, id, phone);
                break;
            case 3:
                buyer = new VipBuyer(name, id, phone);
                break;
            default:
                System.out.println("Invalid buyer type!");
                return;
        }

        // Save buyer info to the file
        buyer.saveToFile(FILENAME);
        System.out.println("Buyer added successfully.");
    }

    // Method to search for a buyer by ID and apply discount
    public static void searchBuyerById(String id) {
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] details = line.split(",");
                if (details[1].equals(id)) {
                    System.out.println("Buyer found:");
                    System.out.println("Full Name: " + details[0]);
                    System.out.println("Phone Number: " + details[2]);
                    System.out.println("Discount: " + details[3] + "%");
                    return;
                }
            }
            System.out.println("Buyer with ID " + id + " not found.");
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }

}
