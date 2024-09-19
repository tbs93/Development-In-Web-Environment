package Services;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

public class ReceiptIDGenerator {

    // Gets the next receipt ID
    public int getNextReceiptID() {
        File file = new File(FileConstants.RECEIPTS_FILE_NAME);

        if (!file.exists()) {
            // File does not exist, create it and start with ID 1
            try {
                file.createNewFile();  
                System.out.println("Created new file. Starting with ID 1."); // Debugging line
            } catch (IOException e) {
                System.out.println("An error occurred while creating the receipts file: " + e.getMessage());              
            }
            return 1;
        }

        // File exists, read the last ID
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String lastLine = null;
            String currentLine;
            boolean inDelimiter = false;

            // Read the file line by line
            while ((currentLine = reader.readLine()) != null) {
            	  System.out.println("Read line: " + currentLine); // Debugging line
            	  
                if (currentLine.equals("=======================================")) {
                    // Skip delimiter lines
                    inDelimiter = true;
                } else {
                    if (inDelimiter) {
                        // After a delimiter, we are looking for a receipt ID line
                        if (currentLine.startsWith("Receipt ID: ")) {
                            lastLine = currentLine;
                            inDelimiter = false;
                        }
                       
                    } else {
                    	if (currentLine.startsWith("Receipt ID: ")) {
                            lastLine = currentLine;
                        }
                    }
                }
            }
            
            if (lastLine != null && lastLine.startsWith("Receipt ID: ")) {
                int lastID = Integer.parseInt(lastLine.substring("Receipt ID: ".length()));
                System.out.println("Last ID found: " + lastID); // Debugging line
                return lastID + 1;
            }
            
            System.out.println("No valid last ID found. Starting with ID 1."); // Debugging line
            return 1;

        } catch (IOException e) {
            System.out.println("An error occurred while reading the receipts file: " + e.getMessage());
        }
        return 1; // Fallback ID in case of errors
    }
}
