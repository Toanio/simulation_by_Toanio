public class Grass extends Entity{
    private int resourceAmount = 100;

    public Grass(Coordinate coordinate) {
        super("Трава", "☘️", coordinate);
    }

    public void takeResource(int count) {
        resourceAmount -= count;
    }

    public boolean isEmpty() {
        return resourceAmount <= 0;
    }
}
