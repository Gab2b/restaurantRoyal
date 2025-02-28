package Commands;
import java.util.ArrayList;
import java.util.Scanner;
import royal.*;

public class SaveRestaurant extends Command {
    Scanner scanner;
    ArrayList<Restaurant> allRestaurants;

    public SaveRestaurant(Scanner scanner, ArrayList<Restaurant> allRestaurants) {
        this.scanner = scanner;
        this.allRestaurants = allRestaurants;
    }

    @Override
    public String getLabel() {
        return "Save a restaurant in database";
    }

    @Override
    public void execute() {
        System.out.println("What's the id of the restaurant you want to save ?");
        int restaurantId = scanner.nextInt();
        scanner.nextLine();
        System.out.println(allRestaurants.get(restaurantId-1).saveRestaurant(allRestaurants));
    }
}