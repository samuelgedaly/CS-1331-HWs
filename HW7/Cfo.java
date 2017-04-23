/**
* Class Cfo that creates the Cfo object
* @version 1.0
* @author Samuel Gedaly
*/
public class Cfo extends TenXer {
    private int moneySkills;

/**
* Cfo constructor that creates the Cfo object
* @param name Cfo's name
* @param salary Cfo's salary
* @param experience Cfo's experience
* @param moneySkills Cfo's money skills
*/
    public Cfo(String name, int salary, int experience, int moneySkills) {
        super(name, salary, experience);
        this.moneySkills = moneySkills;
    }

/**
* Overrides the toString method to return a string representation of the Cfo's
* attributes
* @return returns a string representation of the attributes of the Cfo
*/
    @Override
    public String toString() {
        return "The CFO " + name + " has " + experience
            + " years of experince " + " and a salary of $" + salary
            + ". Also has " + moneySkills + " level of money skills.";
    }

/**
* Overrides the equals method
* @param tx type Object
* @return returns true or false if its equal to the object
*/
    @Override
    public boolean equals(Object tx) {
        if (tx instanceof Cfo) {
            return (super.equals((TenXer) tx)
                && ((Cfo) tx).getMoneySkills() == moneySkills);
        } else {
            return false;
        }
    }
/**
* Overrides the compareTo method
* @param other of type TenXer
* @return returns an int
*/
    @Override
    public int compareTo(TenXer other) {
        if (other instanceof Cfo) {
            if (((Cfo) other).moneySkills < moneySkills) {
                return 1;
            } else if (((Cfo) other).moneySkills == moneySkills) {
                return super.compareTo(other);
            } else {
                return -1;
            }
        } else {
            return getClass().getCanonicalName().compareTo(other.getClass()
                    .getCanonicalName());
        }
    }
/**
* getter method to get the number of money skills.
* @return returns an int, the number amount of skills with money
*/
    public int getMoneySkills() {
        return moneySkills;
    }

}