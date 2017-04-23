//Collaborated with Benjamin Viasberg
public enum Location {
    NORTH, SOUTH, EAST, WEST;

    public String toString(Location l) {
        if (l == Location.NORTH) {
            return "NORTH";
        } else if (l == Location.SOUTH) {
            return "SOUTH";
        } else if (l == Location.EAST) {
            return "EAST";
        } else {
            return "WEST";
        }
    }
}