//Collaborated with Benjamin Vaisberg

import java.util.Random;
/**
* Class that represents a Planet object, which is an instance
* of Astronomical Object.
* @author Samuel Gedaly
* @version 1.0
*/

public class Planet extends AstronomicalObject
    implements Embarkable, Scannable {
    public Planet() {
        super();
        Random r = new Random();
        int ra = r.nextInt(2);
        if (ra == 1) {
            this.sc = SizeClass.Largish;
        } else {
            this.sc = SizeClass.Huge;
        }
    }
    /**
    * An overrided method that observes an Astronomical Obejct.
    * @return string representing the view of this obect.
    */
    @Override
    public String observed() {
        if (sc.ordinal() == 4) {
            return this.getID() + " looks pretty largish.";
        } else {
            return this.getID() + " looks HUGE";
        }
    }
    /**
    * An overrided method that scans an Astronomical Obejct.
    * @return string representing components of this object.
    */
    @Override
    public String scanned() {
        return this.getID() + " is made out of hydrogen oxigen and carbon.";
    }
    /**
    * An overrided method that boards an Astronomical Obejct.
    * @return string representing result of boarding.
    */
    @Override
    public String boarded() {
        Random random = new Random();
        int ran = random.nextInt(101);
        if (ran >= CAN_EMBARK) {
            return "Congrats! You are now on board of " + this.getID();
        } else {
            return "Sorry. You were not able to embark " + this.getID();
        }
    }
}