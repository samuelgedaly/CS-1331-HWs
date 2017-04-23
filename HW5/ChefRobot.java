import java.util.Random;
/**
* This class represents a Chef Robot, which is a type of Robot.
* @author Samuel Gedaly
* @version Homework 5
*/
public class ChefRobot extends Robot {
    private String bestDish;
    private int mealsServedCount;
    private String[] menu;
/**
* This method creates a Chef Robot
* @param name is the name of the Chef Robot
* @param bd is the name of the best dish made.
* @param melas is the number of meals served
* @param menu is a manu of meals
*/
    public ChefRobot(String name, String bd, int meals, String[] menu) {
        super(name);
        this.bestDish = bd;
        this.mealsServedCount = meals;
        this.menu = new String[menu.length];
        this.menu = menu;
    }
/**
* This method generates a String representation of the Chef Robot
* @return String representation of Chef Robot
*/
    public String toString() {
        return "Chef " + super.getName() + ". Meals served: "
            + mealsServedCount + ". Best dish: " + bestDish;
    }
/**
* This method makes the Chef Robot serve a randomly picked meal from the menu
* @return name of meal served
*/
    public String serveMeal() {
        Random r = new Random();
        int rand  = r.nextInt(menu.length);
        String meal = menu[rand];
        mealsServedCount++;
        return meal;
    }
/**
* This method gets the name of the best dish
* @return name of best dish
*/
    public String getBestDish() {
        return bestDish;
    }
/**
* This method gets the number of meals served
* @return number of meals served
*/
    public int getMealsServed() {
        return mealsServedCount;
    }
/**
* This method gets the entire menu
* @return string array of menu
*/
    public String[] getMenu() {
        return menu;
    }
}