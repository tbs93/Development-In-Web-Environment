package Controller;

import Model.Employee;
import Model.Option;

public class DisplayOptions {

    public void showOptions(Employee employee) {
        System.out.println("\nAvailable Options:");
        int optionNumber = 1;
        for (Option option : employee.getAvailableOptions()) {
            System.out.println(optionNumber + ". " + option.name());
            optionNumber++;
        }
        System.out.print("Choose an option (1-" + (optionNumber - 1) + "): ");
    }
}
