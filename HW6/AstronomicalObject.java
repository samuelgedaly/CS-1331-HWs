//Collaborated with Benjamin Vaisberg

import java.util.Random;

/**
* An abstract class that represents an Astronomical Object.
* @author Samuel Gedaly
* @version 1.0
*/

//YOUR CODE HERE: Edit the class header to include all necessary information.
//Rember that you should not be able to create a new instance of this class.
public abstract class AstronomicalObject
    implements Comparable<AstronomicalObject> {
    //YOUR CODE HERE: Add necessary instance variables
    protected String id;
    protected SizeClass sc;
    protected static int count;
    //YOUR CODE HERE: Implement the necessary constructor (only one)
    /**
    * A method that creates an Astronomical Obejct.
    */
    public AstronomicalObject() {
        id = generateID();
        count++;
    }
    //YOUR CODE HERE: Add all required methods
    public abstract String observed();
    /**
    * An overrided method that compares two Astronomical Obejct.
    * @param ao astro. object to campare
    * @return integer representing comparisson
    */
    @Override
    public int compareTo(AstronomicalObject ao) {
        if (getSizeClass().ordinal() > ao.getSizeClass().ordinal()) {
            return 1;
        } else if (getSizeClass().ordinal() < ao.getSizeClass().ordinal()) {
            return -1;
        } else {
            return 0;
        }
    }
    /**
    * An overrided method that returns the string id of an Astronomical Obejct.
    * @return id string of Astronomical object.
    */
    @Override
    public String toString() {
        return id;
    }
    /**
    * A method that returns the id.
    * @return id of Astronomical object.
    */
    public String getID() {
        return id;
    }
    /**
    * An overrided method that returns the size of an Astronomical Obejct.
    * @return size of Astronomical object.
    */
    public SizeClass getSizeClass() {
        return sc;
    }
    /**
    * An overrided method that returns nth instance od astronomical object.
    * @return count of Astronomical object.
    */
    public int getCount() {
        return count;
    }

    //NOTE: DON'T CHANGE ANY CODE PAST THIS LINE
    /**
     * A method that generates a random ID based upon the type of the
     * object. You should use this each time the AstronomicalObject constructor
     * is called.
     *
     * @return The A randomly generated ID for the instance the method
     *         is called on
     */
    private String generateID() {
        Random randGen = new Random();
        String hex = Integer.toHexString(randGen.nextInt());
        return this.getClass().getName() + "-" + hex;
    }
}
