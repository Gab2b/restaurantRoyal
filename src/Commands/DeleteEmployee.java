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
        System.out.println("\n-- NEW EMPLOYEE --\n");
        for (int i=0; i < allRestaurants.size(); i++) {
            System.out.println((i+1) + " - " + allRestaurants.get(i).getName());
        }
        int restaurant = Integer.parseInt(Main.NewScanner(scanner, "Select the restaurant you will create the employee in :"));
        if (restaurant > 0 && restaurant <= allRestaurants.size()) {
            String lastName = Main.NewScanner(scanner, "What's the last name of the employee ?");
            String firstName = Main.NewScanner(scanner, "What's the first name of the employee ?");
            String role = Main.NewScanner(scanner, "What's the employee job ?" );
            String hireDate = Main.NewScanner(scanner, "When did the employee got recruited ?");
            System.out.println("What's the employee salary ?");
            double salary = scanner.nextDouble();
            scanner.nextLine();

//            Employee employee = new Employee(, lastName, firstName, role, hireDate, salary);
            System.out.println("Your employee have been created !\n");
        }
        else {
            System.out.println("\nInvalid Restaurant Input, Try Again");
        }

    }

}