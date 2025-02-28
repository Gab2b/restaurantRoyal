package Commands;
import java.util.ArrayList;
import java.util.Scanner;
import royal.*;

public class DisplayRestaurant extends Command {
    Scanner scanner;
    ArrayList<Restaurant> allRestaurants;

    public DisplayRestaurant(Scanner scanner, ArrayList<Restaurant> allRestaurants) {
        this.scanner = scanner;
        this.allRestaurants = allRestaurants;
    }

    @Override
    public String getLabel() {
        return "Display a restaurant basic informations";
    }

    @Override
    public void execute() {
        for (int i=0; i < allRestaurants.size(); i++) {
            System.out.println((i+1) + " - " + allRestaurants.get(i).getName());
        }
        int restaurant = Integer.parseInt(Main.NewScanner(scanner, "\nSelect the restaurant you want to display the informations of :"));
        if (restaurant > 0 && restaurant <= allRestaurants.size()) {
            System.out.println(allRestaurants.get(restaurant-1).displayRestaurant());
        }
        else {
            System.out.println("\nInvalid Restaurant Input, Try Again");
        }

    }
}