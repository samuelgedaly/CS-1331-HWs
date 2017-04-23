//Collaborated with Benjamin Viasberg
public class Astronaut {
    private String name;
    private int health;
    private boolean alive;

    public Astronaut(String name) {
        if (name == null) {
            this.name = "Anonymous";
        } else {
            this.name = name;
        }
        this.health = 100;
        this.alive = true;
    }

    public void eat(MartianPlant plant) {
        if (alive == true) {
            if (plant != null) {
                int nut = plant.getNutrients();
                health = (int) (health + nut);
            }
        }
    }

    public boolean injure(int dam) {
        if (alive == true) {
            this.health = this.health - dam;
            if (health <= 0) {
                health = 0;
                alive = false;
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public String toString() {
        return "The astronaut " + name + " has a health level of " + health + " Is he alive? " + alive;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public boolean getAlive() {
        return alive;
    }
}