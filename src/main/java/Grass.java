public class Grass extends Entity{
    private int resourceAmount = 100;

    public Grass(Coordinate coordinate) {
        super("Трава", "☘️", coordinate);
    }

    public Grass(int x, int y) {
        this(new Coordinate(x, y));
    }

    public int getResourceAmount() {
        return resourceAmount;
    }

    public int takeResource(int count) {
       if (count <= resourceAmount) {
           resourceAmount -= count;
           return count;
       } else {
           int buffer = resourceAmount;
           resourceAmount = 0;
           return buffer;
       }
    }

    public boolean isEmpty() {
        return resourceAmount <= 0;
    }
}
