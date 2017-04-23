/**
* This class represents a Government Robot, which is a type of Robot.
* @author Samuel Gedaly
* @version Homework 5
*/
public class GovernmentRobot extends Robot {
    private int projectCount = 0;
    private boolean hasSecurityClearance;
/**
* This method creates a Government Robot
* @param name is the name of the Government Robot
* @param count is the number of projects that this Government Robot has
* @param hasclear is the clearance status of Government Robot
*/
    public GovernmentRobot(String name, int pcount, boolean hasclear) {
        super(name);
        this.projectCount = pcount;
        this.hasSecurityClearance = hasclear;
    }
/**
* This method generates a String representation of the Government Robot
* @return String representation of Government Robot
*/
    public String toString() {
        if (hasSecurityClearance) {
            return "Government Robot " + super.getName() + ". Has completed "
                + projectCount + " projects and has security clearance.";
        } else {
            return "Government Robot " + super.getName() + ". Has completed "
                + projectCount
                + " projects and doesnt have security clearance.";
        }
    }
/**
* This method sets project count to a given integer
* @param pc is an integer
*/
    public void setProjectCount(int pc) {
        this.projectCount = pc;
    }
/**
* This method sets clearance status to a given boolean
* @param hsc is an boolean
*/
    public void setSecurityClearance(boolean hsc) {
        this.hasSecurityClearance = hsc;
    }
/**
* This method gets the number of projects
* @return number of projects
*/
    public int getProjectCount() {
        return projectCount;
    }
/**
* This method gets the clearance status
* @return clearance status
*/
    public boolean getSecurityClearance() {
        return hasSecurityClearance;
    }
}