package royal;
import java.util.ArrayList;

public class Order {

    //
    // ATTRIBUTS
    //

    private int idOrder;
    ArrayList<Dish> dishes = new ArrayList<Dish>();
    private double totalPrice;

    //
    // CONSTRUCTEUR
    //

    public Order(int idOrder){
        this.idOrder = idOrder;
    }

    //
    // METHODES
    //

    public String toString() {
        if(dishes.size() == 0){
            return "This order is empty!";
        }
        else {
            String orderOverview = String.format("Order #%s :\n- ", idOrder);
            for (int i=0; i<dishes.size(); i++){
                orderOverview += String.format("%s", dishes.get(i).getName());
                if(i+1 != dishes.size()) {
                    orderOverview += String.format("\n- ");
                }
            }
            orderOverview += String.format("\nTotal price : %s €", totalPrice);
            return orderOverview;
        }
    }

    public void addDish(Dish dish) {
        dishes.add(dish);
        getTotalPrice();
    }

    public void removeDish(Dish dish) {
        dishes.remove(dish);
        getTotalPrice();
    }

    public double getTotalPrice(){
        totalPrice = 0;
        for (int i=0; i<dishes.size(); i++){
            totalPrice += dishes.get(i).getPrice();
        }
        return totalPrice;
    }

}