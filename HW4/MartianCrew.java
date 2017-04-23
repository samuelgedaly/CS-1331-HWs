//Collaborated with Benjamin Viasberg
import java.util.Random;

public class MartianCrew {
    private Astronaut[] astronauts = new Astronaut[5];
    private int crewCount = 5;

    public MartianCrew(String[] names) {
        for (int i = 0; i < astronauts.length; i++) {
            astronauts[i] = new Astronaut(names[i]);
        }
    }

    public void feedCrew(MartianPlant plant) {
        for (int i = 0; i < astronauts.length; i++) {
            if (astronauts[i].getAlive() == true) {
                astronauts[i].eat(plant);
            }
        }
    }

    public boolean damageCrew() {
        Random rr = new Random();
        for (int i = 0; i < astronauts.length; i++) {
            int rand = rr.nextInt(50) + 1;
            if (astronauts[i].injure(rand) == true) {
                crewCount--;
                return true;
            }
        }
        return false;
    }

    public int getCrewCount() {
        return crewCount;
    }

    public Astronaut[] getCrewArray() {
        return astronauts;
    }

}