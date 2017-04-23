//Collaborated with Benjamin Vaisberg

import java.util.Random;
/**
* Class that represents a Star object, which is an instance
* of Astronomical Object.
* @author Samuel Gedaly
* @version 1.0
*/
public class Star extends AstronomicalObject implements Scannable {
    public Star() {
        super();
        Random r = new Random();
        int rand = r.nextInt(2);
        if (rand == 1) {
            sc = SizeClass.Massive;
        } else {
            sc = SizeClass.Gigantic;
        }
    }
    /**
    * An overrided method that observes an Astronomical Obejct.
    * @return string representing the view of this obect.
    */
    @Override
    public String observed() {
        if (sc.ordinal() == 6) {
            return this.getID() + " twinkles in the distance.";
        } else {
            return this.getID() + " looms brightly ahead";
        }
    }
    /**
    * An overrided method that scans an Astronomical Obejct.
    * @return string representing components of this object.
    */
    @Override
    public String scanned() {
        return this.getID() + " is made out of hydrogen and helium.";
    }
}