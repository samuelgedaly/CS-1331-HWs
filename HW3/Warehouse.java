//Colaborated with Benjamin Vaisberg
import java.util.Random;

public class Warehouse {
    private Rack[][] warehouse;
    private Item item;
    private Random r = new Random();

    public Warehouse(int n) {
        warehouse = new Rack[n][];
        for (int i = 0; i < n; i++) {
            int rand = r.nextInt(6)+5;
            warehouse[i] = new Rack[rand];
            for (int j = 0; j < rand; j++) {
                warehouse[i][j] = new Rack();
            }
        }
    }

    public Item order(String name) {
        for (int i = 0; i < warehouse.length; i++) {
            for (int j = 0; j < warehouse[i].length; j++) {
                Item ware = warehouse[i][j].remove(name);
                if (ware == null) {
                    continue;
                } else {
                    return ware;
                }
            }
        }
        return null;
    }

    public boolean store(Item item) {
        int r1 = r.nextInt(warehouse.length);
        int r2 = r.nextInt(warehouse[r1].length);
        boolean tf = warehouse[r1][r2].add(item); 
        return tf;
    }

    public double totalAssets() {
        double totalassets = 0;
        for (int i = 0; i < warehouse.length; i++) {
            for (int j = 0; j < warehouse[i].length; j++) {
                Item[] ite = warehouse[i][j].getItems();
                for (int k = 0; k < warehouse[i][j].count(); k++) {
                    if (ite[k] != null) {
                    totalassets += ite[k].getPrice();
                }
                }
            }

        }
        return totalassets;
    }
}