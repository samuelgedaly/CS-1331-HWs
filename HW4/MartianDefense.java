//Collaborated with Benjamin Viasberg
public class MartianDefense {
    private int defenseRating;
    private Location location;

    public MartianDefense(Location loc) {
        defenseRating = 20;
        this.location = loc;
    }

    public MartianDefense() {
        this.location = Location.NORTH;
    }

    public boolean damage(int dam) {
        defenseRating = defenseRating - dam;
        if (defenseRating <= 0) {
            defenseRating = 0;
            return true;
        } else {
            return false;
        }
    }

    public void reinforce() {
        defenseRating += 5;
    }

    public void resetDefenseRating() {
        defenseRating = 20;
    }

    public String toString() {
        return "The defense's location is " + location.toString(location) + " and the defense rating is " + defenseRating;
    }

    public Location getLocation() {
        return location;
    }

    public int getDefenseRating() {
        return defenseRating;
    }
}