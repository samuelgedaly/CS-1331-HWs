//Collaborated with Benjamin Viasberg
import java.util.Random;

public class MartianHabitat {
    private MartianDefense[] defenses = new MartianDefense[4];
    private int defenseCount = 4;

    public MartianHabitat() {
        defenses[0] = new MartianDefense(Location.NORTH);
        defenses[1] = new MartianDefense(Location.SOUTH);
        defenses[2] = new MartianDefense(Location.EAST);
        defenses[3] = new MartianDefense(Location.WEST);
    }

    public void reBuildDefense(Location locs) {
        for (int i = 0; i < defenses.length; i++) {
            if (defenses[i].getLocation() == locs) {
                defenses[i].resetDefenseRating();
                defenseCount++;
            }
        }
    }

    public boolean reinforceDefenses() {
        boolean t = false;
        for (int i = 0; i < defenses.length; i++) {
            if (defenses[i].getDefenseRating() != 0) {
                defenses[i].reinforce();
                t = true;
            }
        }
        return t;
    }

    public String damageDefenses() {
        Random r = new Random();
        String ret = "";
        for (int i = 0; i < defenses.length; i++) {
            int ra = r.nextInt(10) + 1;
            boolean tf = defenses[i].damage(ra);
            if (tf) {
                Location nee = defenses[i].getLocation();
                ret = ret.concat(nee.toString(nee));
                defenseCount--;
            }
        }
        return ret;
    }

    public int getDefenseCount() {
        return defenseCount;
    }

    public MartianDefense[] getDefenseArray() {
        return defenses;
    }

}