public class Rabbit extends Herbivore{

    public Rabbit(Coordinate coordinate) {
        super("Заяц", "\uD83D\uDC07", coordinate, 100,1);
    }

    public Rabbit(int x, int y) {
        this(new Coordinate(x, y));
    }

}
