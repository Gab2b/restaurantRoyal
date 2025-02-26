package Commands;
import java.util.ArrayList;
import java.util.Scanner;
import royal.*;

public class AddRestaurant extends Command {
    Scanner scanner;
    ArrayList<Restaurant> allRestaurants;

    public AddRestaurant(Scanner scanner, ArrayList<Restaurant> allRestaurants) {
        this.scanner = scanner;
        this.allRestaurants = allRestaurants;
    }

    @Override
    public String getLabel() {
        return "Add a restaurant";
    }

    @Override
    public void execute() {

        String name = Main.NewScanner(scanner, "\n-- NEW RESTAURANT CREATION --\nRestaurant Name :");
        String address = Main.NewScanner(scanner, "Restaurant Address : ");
        String menuName = Main.NewScanner(scanner, "\nIn order to create a new restaurant you have to create your menu :\nMenu Name :");
        String menuCreationDate = Main.NewScanner(scanner, "\nMenu Creation Date :");
        String menuType = Main.NewScanner(scanner, "\nMenu Type :");
        System.out.println("\nYour menu is empty, you don't need to create dishes now you can add them later !");

        Menu menu = new Menu(1, menuName, menuCreationDate, menuType);
        Restaurant restaurant = new Restaurant(Restaurant.restaurantCount+1, name, address, menu);

        allRestaurants.add(restaurant);
        System.out.println("Your restaurant have been created !\n");
    }

}