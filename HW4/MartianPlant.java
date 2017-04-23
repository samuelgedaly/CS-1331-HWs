//Collaborated with Benjamin Viasberg
import java.util.Random;

public class MartianPlant {
    private double nutrients;
    private int plantNum = 1;
    private static int count = 0;

    public MartianPlant() {
        this.nutrients = 12.5;
        this.plantNum = this.plantNum + this.count;
        this.count++;
    }

    public void grow() {
        Random r = new Random();
        int increment = r.nextInt(5) + 1;
        nutrients = nutrients + increment;
    }

    public boolean shrivel() {
        if (nutrients != 0) {
            Random r = new Random();
            int decrement = r.nextInt(7) + 1;
            nutrients = nutrients - decrement;
            if (nutrients <= 0) {
                nutrients = 0;
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean equals(MartianPlant plant2) {
        if (plant2.getPlantNum() == plantNum) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        return "Plant's number is " + plantNum + " and nutrient level is " + nutrients;
    }

    public int getNutrients() {
        return (int) nutrients;
    }

    public int getPlantNum() {
        return plantNum;
    }

}
