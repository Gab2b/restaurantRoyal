package royal;
import java.util.ArrayList;

public class Restaurant {

    //
    // ATTRIBUTS
    //

    public static int restaurantCount = 0;

    private int employeeCount = 0;

    private int id;
    private String name;
    private String address;
    private Menu menu;
    private ArrayList<Order> orderList = new ArrayList<>();
    private ArrayList<Employee> employeesList = new ArrayList<>();

    //
    // CONSTRUCTEUR
    //

    public Restaurant(int id, String name, String address, Menu menu){
        this.id = id;
        this.name = name;
        this.address = address;
        this.menu = menu;
        restaurantCount += 1;
    }

    //
    // GETTERS
    //

    public String getName() {
        return name;
    }

    public String getAddress () {
        return address;
    }

    public String getMenu() {
        return menu.toString();
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    //
    // SETTERS
    //

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    //
    // METHODES
    //

    public void addOrder(Order order){
        orderList.add(order);
    }

    public String displayOrders(){
        String allOrders = "";
        for(int i =0; i<orderList.size(); i++){
            allOrders += orderList.get(i);
            if(i+1 != orderList.size()) {
                allOrders += "\n";
            }
        }

        return allOrders;
    }

    public void addEmployee(Employee employee){
        employeesList.add(employee);
        employeeCount += 1;
    }

    public void removeEmployee(Employee employee) {
        employeesList.remove(employee);
        employeeCount -= 1;
    }

    public String getEmployeeByRole(String role) {
        String employeesWithRole = "";

        for(int i =0; i<employeesList.size(); i++){
            if (employeesList.get(i).getRole().equals(role)) {
                employeesWithRole += employeesList.get(i).toString();
                if(i+1 != employeesList.size()) {
                    employeesWithRole += "\n";
                }
            }
        }

        if (employeesWithRole.equals("")) {
            employeesWithRole = "There is no employee with this role";
        }
        return employeesWithRole;
    }

    public String displayEmployees(){
        String allEmployees = "";
        for (int i=0; i<employeesList.size(); i++){
            allEmployees += employeesList.get(i).toString();
            if(i+1 != employeesList.size()) {
                allEmployees += "\n";
            }
        }

        if (allEmployees.equals("")) {
            allEmployees = "There is no employee in the restaurant";
        }

        return allEmployees;
    }

    public String displayRestaurant() {
        String restaurantInfos = String.format("Restaurant #%s : %s, Address : %s", id, name, address);
        if (employeesList.size() < 0) {
            restaurantInfos += "\nThere is no employee in the restaurant";
        }
        else {
            restaurantInfos += "\nEmployees : ";
            ArrayList<String> rolesList = new ArrayList<>();
            for (int i=0; i<employeesList.size(); i++){
                if (!rolesList.contains(employeesList.get(i).getRole())) {
                    rolesList.add(employeesList.get(i).getRole());
                }
            }

            for (int i=0; i<rolesList.size(); i++){
                restaurantInfos += String.format("\n- %s : ", rolesList.get(i));
                for (int j=0; j<employeesList.size(); j++) {
                    if (employeesList.get(j).getRole().equals(rolesList.get(i))) {
                        restaurantInfos += String.format("%s %s, ", employeesList.get(j).getFirstName(), employeesList.get(j).getLastName());
                    }

                }

                if(i+1 != employeesList.size()) {
                    restaurantInfos += "\n";
                }
            }

        }

        return restaurantInfos;
    }



}