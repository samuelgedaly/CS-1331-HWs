/**
* SoftwareEngineer class which creates the SoftwareEngineer object.
* @version 1.0
* @author Samuel Gedaly
*/
public class SoftwareEngineer extends TenXer {

    private int githubStars;
    private boolean knowsJava;

/**
* SoftwareEnginner constructor creates a SoftwareEngineer object
* @param name SoftwareEngineer's name
* @param salary SoftwareEngineer's salary
* @param experience SoftwareEngineer's experience
* @param githubStars SoftwareEngineer's amount of github stars
* @param knowsJava whether the SoftwareEngineer knows java or not
*/
    public SoftwareEngineer(String name, int salary, int experience,
                            int githubStars, boolean knowsJava) {
        super(name, salary, experience);
        this.githubStars = githubStars;
        this.knowsJava = knowsJava;
    }

/**
* Overrides the toString method to return a string representation of the
* Software Engineers's
* attributes
* @return returns a string representation of the attributes of the
* Software Engineer
*/
    @Override
    public String toString() {
        return "The SoftwareEngineer " + name + " has " + experience
            + " years of experience " + " and a salary of $" + salary
            + ". Also has " + githubStars + " github stars. Knows Java?: "
            + knowsJava;
    }

/**
* Overrides the equals method
* @param tx type Object
* @return returns true or false if its equal to the object
*/
    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (other == this) {
            return true;
        }
        if (!(other instanceof SoftwareEngineer)) {
            return false;
        }
        SoftwareEngineer otherSE = (SoftwareEngineer) other;

        return super.equals(otherSE) && otherSE.getGithubStars() == githubStars
            && otherSE.getKnowsJava() == knowsJava;
    }

/**
* Overrides the compareTo method
* @param other of type TenXer
* @return returns an int
*/
    @Override
    public int compareTo(TenXer other) {
        if (other instanceof SoftwareEngineer) {
            if (githubStars > ((SoftwareEngineer) other).getGithubStars()) {
                return 1;
            } else if (githubStars == ((SoftwareEngineer) other).getGithubStars()) {
                if (knowsJava) {
                    if (((SoftwareEngineer) other).getKnowsJava()) {
                        return super.compareTo(other);
                    } else {
                        return 1;
                    }
                } else {
                    if (((SoftwareEngineer) other).getKnowsJava()) {
                        return -1;
                    } else {
                        return super.compareTo(other);
                    }
                }
            } else {
                return -1;
            }
        } else {
            return getClass().getCanonicalName().compareTo(
                other.getClass().getCanonicalName());
        }
    }

/**
* getter method that gets the number of githubStars.
* @return int number of githubStars
*/
    public int getGithubStars() {
        return githubStars;
    }

/**
* getter method that gets whether the SoftwareEngineer knows java
* @return boolean true or false whether he knows Java or not
*/
    public boolean getKnowsJava() {
        return knowsJava;
    }

}