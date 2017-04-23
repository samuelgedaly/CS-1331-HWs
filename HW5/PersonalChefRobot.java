/**
* This class represents a Personal Chef Robot, which is a type of Chef Robot.
* @author Samuel Gedaly
* @version Homework 5
*/
public class PersonalChefRobot extends ChefRobot {
    private boolean canHostGuests;
/**
* This method creates a Personal Chef Robot
* @param name is the name of the Personal Chef Robot
* @param bd is the name of the best dish made
* @param melas is the number of meals served
* @param menu is a manu of meals
* @param chg is whether or not can host guests
*/
    public PersonalChefRobot(String name, String bd, int meals,
        String[] menu, boolean chg) {
        super(name, bd, meals, menu);
        canHostGuests = chg;
    }
/**
* This method generates a String representation of the Personal Chef Robot
* @return String representation of Personal Chef Robot
*/
    public String toString() {
        if (canHostGuests) {
            return "Personal Chef " + super.getName() + ". Meals Served: "
                + super.getMealsServed() + ". Best dish: " + super.getBestDish()
                + ". Can host guests.";
        } else {
            return "Personal Chef " + super.getName() + ". Meals Served: "
                + super.getMealsServed() + ". Best dish: " + super.getBestDish()
                + ". Can not host guests.";
        }
    }
/**
* This method gets the hosting status
* @return hosting statuts
*/
    public boolean getCanHostGuests() {
        return canHostGuests;
    }

}