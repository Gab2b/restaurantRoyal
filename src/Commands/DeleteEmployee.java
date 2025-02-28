package Commands;
import java.util.ArrayList;
import java.util.Scanner;
import royal.*;

public class DeleteEmployee extends Command {
    Scanner scanner;
    ArrayList<Restaurant> allRestaurants;

    public DeleteEmployee(Scanner scanner, ArrayList<Restaurant> allRestaurants) {
        this.scanner = scanner;
        this.allRestaurants = allRestaurants;
    }

    @Override
    public String getLabel() {
        return "Delete an employee";
    }

    @Override
    public void execute() {
        System.out.println("\n-- DELETE EMPLOYEE --\n");
        for (int i=0; i < allRestaurants.size(); i++) {
            System.out.println((i+1) + " - " + allRestaurants.get(i).getName());
        }
        int restaurant = Integer.parseInt(Main.NewScanner(scanner, "\nSelect the restaurant you want to delete the employee from :"));
        if (restaurant > 0 && restaurant <= allRestaurants.size()) {
            System.out.println("What's the id of the employee ?");
            int employeeId = scanner.nextInt();

            if (allRestaurants.get(restaurant-1).employeeExists(employeeId)) {
                allRestaurants.get(restaurant - 1).removeEmployee(employeeId);
                System.out.println("Your employee have been deleted !\n");
            }
            else {
                System.out.println("The Id you've entered does not match with any employee");
            }
        }
        else {
            System.out.println("\nInvalid Restaurant Input, Try Again");
        }

    }

}