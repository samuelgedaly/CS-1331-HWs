//Colaborated with Benjamin Vaisberg
public class Rack {

    private Item[] rack = new Item[10];
    private int count = 0;

    public int count() {
        return this.count;
    }

    public boolean add(Item item) {
        if (count() < 10) {
            rack[count] = item;
            count++;
            return true;
        } else {
            return false;
        }
    }

    public Item remove(String name) {
        for (int i = 0; i < count; i++) {
            if (rack[i] != null) {

                String get = rack[i].getName();
                if (get.equals(name)) {
                    Item item = rack[i];
                    rack[i] = null;
                    count--;
                    return item;
                }
            }
        }
        return null;

    }

    public Item[] getItems() {
        return rack;
    }
}