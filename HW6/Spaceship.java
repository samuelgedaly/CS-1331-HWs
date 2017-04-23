//Collaborated with Benjamin Vaisberg

import java.util.Random;
/**
* Class that represents a Spaceship object, which is an instance
* of Astronomical Object.
* @author Samuel Gedaly
* @version 1.0
*/
public class Spaceship extends AstronomicalObject
    implements Attackable, Embarkable {
    public Spaceship() {
        super();
        Random r = new Random();
        int ra = r.nextInt(2);
        if (ra == 1) {
            this.sc = SizeClass.Teeny;
        } else {
            this.sc = SizeClass.Tiny;
        }
    }
    /**
    * An overrided method that observes an Astronomical Obejct.
    * @return string representing the view of this obect.
    */
    @Override
    public String observed() {
        if (sc.ordinal() == 0) {
            return this.getID() + " can barely be seen.";
        } else {
            return this.getID() + " looks exteremely small.";
        }
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
    /**
    * An overrided method that attacks an Astronomical Obejct.
    * @return string representing result of attack.
    */
    @Override
    public String attacked() {
        Random random = new Random();
        int ran = random.nextInt(101);
        if (ran >= DODGE_CHANCE) {
            return this.getID() + " dodged your attack.";
        } else {
            return "Your attack to " + this.getID() + " was successful";
        }
    }
}