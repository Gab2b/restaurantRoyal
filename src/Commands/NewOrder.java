package Commands;
import java.util.ArrayList;
import java.util.Scanner;
import royal.*;

public class NewOrder extends Command {
    Scanner scanner;
    ArrayList<Restaurant> allRestaurants;

    public NewOrder(Scanner scanner, ArrayList<Restaurant> allRestaurants) {
        this.scanner = scanner;
        this.allRestaurants = allRestaurants;
    }

    @Override
    public String getLabel() {
        return "Create a new order";
    }

    @Override
    public void execute() {
        for (int i=0; i < allRestaurants.size(); i++) {
            System.out.println((i+1) + " - " + allRestaurants.get(i).getName());
        }
        int restaurant = Integer.parseInt(Main.NewScanner(scanner, "\nSelect the restaurant you want to order from :"));
        if (restaurant > 0 && restaurant <= allRestaurants.size()) {
            boolean ordering = true;
            Order order = new Order(allRestaurants.get(restaurant - 1).getOrderCount() + 1);
            while (ordering) {
                System.out.println("Que voulez vous ajouter à la commande ?\n\nTapez 1 pour afficher les plats\nTapez 2 pour ajouter un plat\nTapez 3 pour retirer un plat\nTapez 4 pour afficher la commande en cours\nTapez 5 pour terminer");
                switch (scanner.nextInt()){
                    case 1 :
                        System.out.println(allRestaurants.get(restaurant-1).menu.display());
                        break;
                    case 2 :
                        scanner.nextLine();
                        System.out.println("Enter the name of the Dish you want to append to the order :");
                        String dishToAppend = scanner.nextLine();
                        String answertoAppend = allRestaurants.get(restaurant-1).menu.getDishByName(dishToAppend);
                        if (answertoAppend.equals("This dish does not exist")) {
                            System.out.println(answertoAppend);
                            break;
                        }
                        else {
                            for (int i = 0; i < allRestaurants.get(restaurant-1).menu.availableDishes.size(); i++) {
                                if (allRestaurants.get(restaurant-1).menu.availableDishes.get(i).toString().equals(answertoAppend)) {
                                    order.addDish(allRestaurants.get(restaurant-1).menu.availableDishes.get(i));
                                }
                            }
                            System.out.println("Dish added to the order !");
                        }
                        break;

                    case 3:
                        scanner.nextLine();
                        System.out.println("Enter the name of the Dish you want to delete from the order :");
                        String dishToRemove = scanner.nextLine();
                        String answerToRemove = allRestaurants.get(restaurant-1).menu.getDishByName(dishToRemove);
                        if (answerToRemove.equals("This dish does not exist")) {
                            System.out.println(answerToRemove);
                            break;
                        }
                        else {
                            for (int i = 0; i < allRestaurants.get(restaurant-1).menu.availableDishes.size(); i++) {
                                if (allRestaurants.get(restaurant-1).menu.availableDishes.get(i).toString().equals(answerToRemove)) {
                                    order.removeDish(allRestaurants.get(restaurant-1).menu.availableDishes.get(i));
                                }
                            }
                            System.out.println("Dish deleted from the order !");
                        }
                        break;
                    case 4:
                        System.out.println(order.toString());
                        break;

                    case 5:
                        allRestaurants.get(restaurant-1).addOrder(order);
                        ordering = false;
                        break;


                    default:
                        System.out.println("Numéro non reconnu");
                        break;

                }

            }
        }
        else {
            System.out.println("\nInvalid Restaurant Input, Try Again");
        }

    }
}