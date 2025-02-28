package royal;
import Commands.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        ArrayList<Restaurant> allRestaurants = new ArrayList<>();

        Initialization init = new Initialization();
        init.start(allRestaurants);

        Scanner newScan = new Scanner(System.in);

        while (true) {

            Command[] commands = {
                    new Commands.AddRestaurant(newScan, allRestaurants),
                    new Commands.AddEmployee(newScan, allRestaurants),
                    new Commands.AddDish(newScan, allRestaurants),
                    new Commands.NewOrder(newScan, allRestaurants),
                    new Commands.DisplayEmployees(newScan, allRestaurants),
                    new Commands.DisplayOrders(newScan, allRestaurants),
                    new Commands.DisplayRestaurant(newScan, allRestaurants),
                    new Commands.SaveRestaurant(newScan, allRestaurants),
                    new Commands.DeleteEmployee(newScan, allRestaurants),
                    new Commands.Quit()
            };

            System.out.println("Main Menu :");

            for (int i = 0; i < commands.length; i++) {
                System.out.println((i + 1) + ". " + commands[i].getLabel());
            }

            System.out.println("\nWhat do you want to do ?");

            int choice = 0;

            try {
                if (newScan.hasNextInt()) {
                    choice = newScan.nextInt();
                    newScan.nextLine();
                } else {
                    newScan.next();
                    choice = -1;
                }
            } catch (Exception e) {
                choice = -1;
            }


            if (choice <= 0 || choice > commands.length) {

                System.out.println(choice);
                System.out.println("Invalid input");
            }
            else if (choice == commands.length) {
                newScan.close();
            }

            commands[choice - 1].execute();
        }

    }

    public static String NewScanner(Scanner newScan, String prompt) {
        System.out.println(prompt);
        return newScan.nextLine();
    }
}