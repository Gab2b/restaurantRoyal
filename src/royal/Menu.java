package royal;
import java.util.ArrayList;

public class Menu {

    //
    // ATTRIBUTS
    //


    private int id;
    private String name;
    private String creationDate;
    private String typeMenu;
    ArrayList<Dish> availableDishes = new ArrayList<Dish>();

    //
    // CONSTRUCTEUR
    //

    public Menu(int id, String name, String creationDate, String typeMenu){
        this.id = id;
        this.name = name;
        this.creationDate = creationDate;
        this.typeMenu = typeMenu;
    }

    //
    // GETTERS
    //

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCreationDate () {
        return creationDate;
    }

    public String getTypeMenu() {
        return typeMenu;
    }

    //
    // SETTERS
    //

    public void setName(String name) {
        this.name = name;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public void setTypeMenu(String typeMenu) {
        this.typeMenu = typeMenu;
    }

    //
    // METHODES
    //

    public String toString() {
        return String.format("Menu [id=%s, name=%s, creationDate=%s, typeMenu=%s]\n", id, name, creationDate, typeMenu);
    }

    public String display(){
        String allDishes = "";
        for (int i =0; i<availableDishes.size(); i++){
            allDishes += availableDishes.get(i) + "\n";
        }
        return toString() + allDishes;
    }

    public void addDish(Dish dish) {
        availableDishes.add(dish);
    }

    public void removeDish(Dish dish) {
        availableDishes.remove(dish);
    }

    public String getDishByName(String name){
        for(int i =0; i<availableDishes.size(); i++){
            if(availableDishes.get(i).getName().equals(name)){
                return availableDishes.get(i).toString();
            }
        }
        return "This dish does not exist";
    }

}