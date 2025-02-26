package royal;

public class Dish {

    //
    // ATTRIBUTS
    //

        private String name;
        private String description;
        private double price;
    private double calories;
    private String part;
    private String publicationDate;
    private boolean available;
    private String foodType;
    private double preparationTime;
    private double specialPrice;

    //
    // CONSTRUCTEUR
    //

    public Dish(String name, String description, double price, double calories, String part, String publicationDate, boolean available, String foodType, double preparationTime, double specialPrice){
        this.name = name;
        this.description = description;
        this.price = price;
        this.calories = calories;
        this.part = part;
        this.publicationDate = publicationDate;
        this.available = available;
        this.foodType = foodType;
        this.preparationTime = preparationTime;
        this.specialPrice = specialPrice;
    }

    //
    // GETTERS
    //

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public double getCalories() {
        return calories;
    }

    public String getPart() {
        return part;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public boolean isAvailable() {
        return available;
    }

    public String getFoodType() {
        return foodType;
    }

    public double getPreparationTime() {
        return preparationTime;
    }

    public double getSpecialPrice() {
        return specialPrice;
    }

    //
    // SETTERS
    //

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = Dish.this.description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public void setPreparationTime(double preparationTime) {
        this.preparationTime = preparationTime;
    }

    public void setSpecialPrice(double specialPrice) {
        this.specialPrice = specialPrice;
    }

    //
    // METHODES
    //

    public String toString() {
        return String.format("Dish [name=%s, description=%s, price=%s, calories=%s, part=%s, publicationDate=%s, available=%s, foodType=%s, preparationTime=%s, specialPrice=%s]", name, description, price, calories, part, publicationDate, available, foodType, preparationTime, specialPrice);
    }
}