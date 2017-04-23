/**
* This class represents a Restaurant Chef Robot, which is a type of Chef Robot.
* @author Samuel Gedaly
* @version Homework 5
*/
public class RestaurantChefRobot extends ChefRobot {
    private int celebritiesMet;
/**
* This method creates a Chef Robot
* @param name is the name of the Restaurant Chef Robot
* @param bd is the name of the best dish made
* @param melas is the number of meals served
* @param menu is a manu of meals
* @param celebritiesMet is the number of celebrities met
*/
    public RestaurantChefRobot(String name, String bd, int meals,
        String[] menu, int celebtritiesMet) {
        super(name, bd, meals, menu);
        this.celebritiesMet = celebtritiesMet;
    }
/**
* This method generates a String representation of the Restaurant Chef Robot
* @return String representation of Restaurant Chef Robot
*/
    public String toString() {
        return "Personal Chef " + super.getName() + ". Meals Served: "
            + super.getMealsServed() + ". Best dish: " + super.getBestDish()
            + "Has met " + celebritiesMet + " celebrities!";
    }
/**
* This method gets the number of celebrities met
* @return number of celebrities met
*/
    public int getCelebritiesMet() {
        return this.celebritiesMet;
    }
}