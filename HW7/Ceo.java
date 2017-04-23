/**
* Ceo class that creates a Ceo object
* @version 1.0
* @author Samuel Gedaly
*/
public class Ceo extends TenXer {
    private int numStartups;

/**
* Ceo constructor creates a Ceo object
* @param name Ceo's name
* @param salary Ceo's salary
* @param experience Ceo's experience
* @param numStartups Ceo's number of startups
*/
    public Ceo(String name, int salary, int experience, int numStartups) {
        super(name, salary, experience);
        this.numStartups = numStartups;
    }

/**
* Overrides the toString method to return a string representation of the Ceo's
* attributes
* @return returns a string representation of the attributes of the Ceo
*/
    @Override
    public String toString() {
        return "The CEO " + name + " has " + experience
            + " years of experience " + " and a salary of $" + salary
            + ". Also has " + numStartups + " Sillicon Valley startups";
    }

/**
* Overrides the equals method
* @param tx type Object
* @return returns true or false if its equal to the object
*/
    @Override
    public boolean equals(Object tx) {
        if (tx instanceof Ceo) {
            return (super.equals((TenXer) tx)
                && ((Ceo) tx).getNumStartups() == numStartups);
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
        if (other instanceof Ceo) {
            if (((Ceo) other).numStartups > numStartups) {
                return 1;
            } else if (((Ceo) other).numStartups == numStartups) {
                return super.compareTo(other);
            } else {
                return -1;
            }
        } else {
            return getClass().getCanonicalName().compareTo(
                other.getClass().getCanonicalName());
        }
    }

/**
* getter method to get the number of startups.
* @return returns an int, the number of startups
*/
    public int getNumStartups() {
        return numStartups;
    }
}