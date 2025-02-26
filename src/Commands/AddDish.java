package Commands;
import java.util.ArrayList;
import java.util.Scanner;
import royal.*;

public class AddDish extends Command {
    Scanner scanner;
    ArrayList<Restaurant> allRestaurants;

    public AddDish(Scanner scanner, ArrayList<Restaurant> allRestaurants) {
        this.scanner = scanner;
        this.allRestaurants = allRestaurants;
    }

    @Override
    public String getLabel() {
        return "Add a new dish";
    }

    @Override
    public void execute() {
        System.out.println("\n-- NEW DISH CREATION --\n");
        for (int i=0; i < allRestaurants.size(); i++) {
            System.out.println((i+1) + " - " + allRestaurants.get(i).getName());
        }
        int restaurant = Integer.parseInt(Main.NewScanner(scanner, "Select the restaurant you will create the new dish in :"));
        if (restaurant > 0 && restaurant <= allRestaurants.size()) {
            String name = Main.NewScanner(scanner, "Enter the name of the new dish ?");
            String description = Main.NewScanner(scanner, "Write a nice description for your dish");
            System.out.println( "What's the price of your dish ?");
            double price = scanner.nextDouble();
            scanner.nextLine();
            System.out.println("How many calories will you dish get");
            double calories = scanner.nextDouble();
            scanner.nextLine();
            String part = Main.NewScanner(scanner, "What is the part of food, the specifications of the part");
            String publicationDate = Main.NewScanner(scanner, "When did this dish got released ?");
            String foodType = Main.NewScanner(scanner, "Enter the type of food");
            System.out.println("How many time you will need to make it");
            double preparationTime = scanner.nextDouble();
            scanner.nextLine();
            System.out.println("What is the special price under reductions");
            double specialPrice = scanner.nextDouble();
            scanner.nextLine();

            Dish dish = new Dish(name, description, price, calories, part, publicationDate, true, foodType, preparationTime, specialPrice);
            System.out.println("Your dish have been created !\n");
        }
        else {
            System.out.println("\nInvalid Restaurant Input, Try Again");
        }

    }

}