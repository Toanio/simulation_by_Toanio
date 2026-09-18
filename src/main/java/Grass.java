public class Grass extends Entity{
    private int resourceAmount = 100;

    public Grass(int coordinateX, int coordinateY) {
        super("Трава", coordinateX, coordinateY, "☘️");
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
