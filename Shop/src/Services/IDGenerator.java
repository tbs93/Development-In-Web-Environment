package Services;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

public class IDGenerator {

    // Gets the next ID based on the file name
    public static int getNextID(String fileName) {
        String idPrefix;
        String delimiter= "=======================================";

        // Determine prefix and delimiter based on filename
        if (FileConstants.RECEIPTS_FILE_NAME.equals(fileName)) {
            idPrefix = "Receipt ID: ";
        } else if (FileConstants.EMPLOYEES_FILE_NAME.equals(fileName)) {
            idPrefix = "Employee ID: ";
        } else {
            throw new IllegalArgumentException("Unsupported file name: " + fileName);
        }

        File file = new File(fileName);

        if (!file.exists()) {
            // File does not exist, create it and start with ID 1
            try {
                file.createNewFile();
                System.out.println("Created new file. Starting with ID 1."); // Debugging line
            } catch (IOException e) {
                System.out.println("An error occurred while creating the file: " + e.getMessage());
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

                if (currentLine.equals(delimiter)) {
                    // Skip delimiter lines
                    inDelimiter = true;
                } else {
                    if (inDelimiter) {
                        // After a delimiter, we are looking for an ID line
                        if (currentLine.startsWith(idPrefix)) {
                            lastLine = currentLine;
                            inDelimiter = false;
                        }

                    } else {
                        if (currentLine.startsWith(idPrefix)) {
                            lastLine = currentLine;
                        }
                    }
                }
            }

            if (lastLine != null && lastLine.startsWith(idPrefix)) {
                int lastID = Integer.parseInt(lastLine.substring(idPrefix.length()));
                System.out.println("Last ID found: " + lastID); // Debugging line
                return lastID + 1;
            }

            System.out.println("No valid last ID found. Starting with ID 1."); // Debugging line
            return 1;

        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
        return 1; // Fallback ID in case of errors
    }
}
