package royal;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Initialization {
    public int start(ArrayList<Restaurant> allRestaurants) {
        try {

            File restaurantDirectory = new File("./data/");
            File[] restaurantFiles = restaurantDirectory.listFiles();

            if (restaurantFiles != null) {
                for (int e = 0; e < restaurantFiles.length; e++) {
                    Scanner scanRestaurantFile = new Scanner(new File("./data/restaurant-" + (e + 1) + "/infos.txt"));
                    Scanner scanMenuFiles = new Scanner(new File("./data/restaurant-" + (e + 1) + "/menu/1/1.txt"));

                    String dishesDirectoryPath = "./data/restaurant-" + (e + 1) + "/menu/1/dishes/";
                    File dishesDirectory = new File(dishesDirectoryPath);

                    String ordersDirectoryPath = "./data/restaurant-" + (e + 1) + "/orders/";
                    File ordersDirectory = new File(ordersDirectoryPath);

                    String employeesDirectoryPath = "./data/restaurant-" + (e + 1) + "/employees/";
                    File employeesDirectory = new File(employeesDirectoryPath);

                    ArrayList<String> restaurantInfos = new ArrayList<>();
                    ArrayList<String> menuInfos = new ArrayList<>();
                    ArrayList<Dish> dishesList = new ArrayList<>();
                    ArrayList<Employee> employeesList = new ArrayList<>();
                    ArrayList<Order> ordersList = new ArrayList<>();

                    // INFOS RESTAURANT
                    for (int i = 0; i < 3; i++) {
                        restaurantInfos.add(scanRestaurantFile.nextLine());
                    }

                    // INFOS DISHES
                    if (dishesDirectory.exists() && dishesDirectory.isDirectory()) {
                        File[] dishesFiles = dishesDirectory.listFiles();
                        if (dishesFiles != null) {
                            for (int i = 0; i < dishesFiles.length; i++) {
                                Scanner scanDishInfos = new Scanner(new File(dishesDirectoryPath + (i + 1) + ".txt"));
                                Dish dish = new Dish(scanDishInfos.nextLine(), scanDishInfos.nextLine(), Double.parseDouble(scanDishInfos.nextLine()), Double.parseDouble(scanDishInfos.nextLine()), scanDishInfos.nextLine(), scanDishInfos.nextLine(), Boolean.parseBoolean(scanDishInfos.nextLine()), scanDishInfos.nextLine(), Double.parseDouble(scanDishInfos.nextLine()), Double.parseDouble(scanDishInfos.nextLine()));
                                dishesList.add(dish);
                                scanDishInfos.close();
                            }
                        }
                    }

                    // INFOS MENU + CREATION
                    for (int i = 0; i < 4; i++) {
                        menuInfos.add(scanMenuFiles.nextLine());
                    }

                    Menu menu = new Menu(Integer.parseInt(menuInfos.get(0)), menuInfos.get(1), menuInfos.get(2), menuInfos.get(3));

                    for (int i = 0; i < dishesList.size(); i++) {
                        menu.addDish(dishesList.get(i));
                    }

                    // CREATION RESTAURANT
                    Restaurant restaurant = new Restaurant(Integer.parseInt(restaurantInfos.get(0)), restaurantInfos.get(1), restaurantInfos.get(2), menu);
                    allRestaurants.add(restaurant);

                    // EMPLOYES
                    if (employeesDirectory.exists() && employeesDirectory.isDirectory()) {
                        File[] employeesFiles = employeesDirectory.listFiles();
                        if (employeesFiles != null) {
                            for (int i = 0; i < employeesFiles.length; i++) {
                                Scanner scanEmployeeInfos = new Scanner(new File(employeesDirectoryPath + (i + 1) + ".txt"));
                                Employee employee = new Employee(Integer.parseInt(scanEmployeeInfos.nextLine()), scanEmployeeInfos.nextLine(), scanEmployeeInfos.nextLine(), scanEmployeeInfos.nextLine(), scanEmployeeInfos.nextLine(), Double.parseDouble(scanEmployeeInfos.nextLine()));
                                restaurant.addEmployee(employee);
                                scanEmployeeInfos.close();
                            }
                        }
                    }

                    // ORDERS
                    if (ordersDirectory.exists() && ordersDirectory.isDirectory()) {
                        File[] ordersFiles = ordersDirectory.listFiles();
                        if (ordersFiles != null) {
                            for (int i = 0; i < ordersFiles.length; i++) {
                                Scanner scanOrderInfos = new Scanner(new File(ordersDirectoryPath + (i + 1) + ".txt"));
                                Order order = new Order(Integer.parseInt(scanOrderInfos.nextLine()));
                                while (scanOrderInfos.hasNextLine()) {
                                    Scanner scanDishInfos = new Scanner(new File(dishesDirectoryPath + (scanOrderInfos.nextInt()) + ".txt"));
                                    Dish dish = new Dish(scanDishInfos.nextLine(), scanDishInfos.nextLine(), Double.parseDouble(scanDishInfos.nextLine()), Double.parseDouble(scanDishInfos.nextLine()), scanDishInfos.nextLine(), scanDishInfos.nextLine(), Boolean.parseBoolean(scanDishInfos.nextLine()), scanDishInfos.nextLine(), Double.parseDouble(scanDishInfos.nextLine()), Double.parseDouble(scanDishInfos.nextLine()));
                                    order.addDish(dish);
                                    scanDishInfos.close();
                                }
                                restaurant.addOrder(order);
                                scanOrderInfos.close();
                            }
                        }
                    }

                    scanRestaurantFile.close();
                    scanMenuFiles.close();
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }
}