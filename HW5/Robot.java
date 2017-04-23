/**
* This class represents a Robot
* @author Samuel Gedaly
* @version Homework 5
*/
public class Robot {
    private String name;
/**
* This method creates a Robot
*/
    public Robot(String name) {
        this.name = name;
    }
/**
* This method sets the Robot's name to a given String
* @param name
*/
    public void setName(String name) {
        this.name = name;
    }
/**
* This method returns the name of the Robot as a String
* @return name of Robot.
*/
    public String toString() {
        return this.name + ".";
    }
/**
* This method gets the name of the Robot
* @return name of Robot
*/
    public String getName() {
        return name;
    }
}