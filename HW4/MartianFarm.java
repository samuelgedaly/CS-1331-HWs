//Collaborated with Benjamin Viasberg
import java.util.Random;

public class MartianFarm {
    private MartianPlant[] plants;
    private int farmSize = 10;

    public MartianFarm() {
        plants = new MartianPlant[10];
        for (int i = 0; i < plants.length; i++) {
            plants[i] = new MartianPlant();
        }
    }

    public void growFarm() {
        for (int i = 0; i < plants.length; i++) {
            if (plants[i] != null) {
                plants[i].grow();
            }
        }
    }

    public void plantPlant() {
        if (farmSize >= plants.length) {
            MartianPlant[] newPlants = new MartianPlant[plants.length * 2];
            for (int j = 0; j < plants.length; j++) {
                newPlants[j] = plants[j];
            }
            newPlants[plants.length] = new MartianPlant();
            farmSize++;
            plants = newPlants;
        } else if (farmSize < plants.length) {
            for (int i = 0; i < plants.length; i++) {
                if (plants[i] == null) {
                    plants[i] = new MartianPlant();
                    farmSize++;
                    break;
                }
            }
        }
    }

    public boolean damagePlants() {
        for (int i = 0; i < plants.length; i++) {
            if (plants[i] != null) {
                boolean b = plants[i].shrivel();
                if (b) {
                    plants[i] = null;
                    farmSize--;
                    return true;
                }
            }
        }
        return false;
    }

    public MartianPlant removePlant(MartianPlant plant) { ///check
        MartianPlant amigo = new MartianPlant();
        for (int i = 0; i < farmSize; i++) {
            boolean tp = plants[i].equals(plant);
            if (tp) {
                plants[i] = amigo;
                plants[i] = null;
                farmSize--;
                return amigo;
            }
        }
        return amigo;
    }

    public MartianPlant getRandPlant() {
        Random r = new Random();
        return plants[r.nextInt(farmSize)];
    }

    public int getFarmSize() {
        return farmSize;
    }

    public MartianPlant[] getPlantArray() {
        return plants;
    }

}