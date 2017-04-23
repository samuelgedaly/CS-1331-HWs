//Colaborated with Benjamin Vaisberg
public class Item {

    private String name;
    private double price;
    private int rating;

    public Item(String name, double price, int rating) {
        this.name = name;
        this.price = price;
        if (rating < 1) {
            this.rating = 1;
        } else if (rating > 5) {
            this.rating = 5;
        } else {
            this.rating = rating;
        }
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getRating() {
        return rating;
    }


}