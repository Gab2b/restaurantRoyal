package Commands;
import java.util.ArrayList;
import java.util.Scanner;
import royal.*;

public class DisplayEmployees extends Command {
    Scanner scanner;
    ArrayList<Restaurant> allRestaurants;

    public DisplayEmployees(Scanner scanner, ArrayList<Restaurant> allRestaurants) {
        this.scanner = scanner;
        this.allRestaurants = allRestaurants;
    }

    @Override
    public String getLabel() {
        return "Display employees from a restaurant";
    }

    @Override
    public void execute() {
        for (int i=0; i < allRestaurants.size(); i++) {
            System.out.println((i+1) + " - " + allRestaurants.get(i).getName());
        }
        int restaurant = Integer.parseInt(Main.NewScanner(scanner, "\nSelect the restaurant you will display the employee of :"));
        System.out.println("\n" + allRestaurants.get(restaurant-1).displayEmployees() + "\n");
    }

}
