public class Wolf extends Predator{
    static int DEFAULT_HP = 200;
    static int DEFAULT_SPEED = 1;
    static int DEFAULT_ATTACK_POWER = 10;

    public Wolf(Coordinate coordinate) {
        super("Волк", "\uD83D\uDC3A", coordinate, DEFAULT_HP, DEFAULT_SPEED, DEFAULT_ATTACK_POWER);
    }

    public Wolf(int x, int y) {
        this(new Coordinate(x, y));
    }
}
