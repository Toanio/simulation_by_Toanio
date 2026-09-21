public abstract class Creature extends Entity{
    private int hp;
    private int speed;

    public Creature(String name, String image, Coordinate coordinate, int hp, int
                    speed) {
        super(name, image, coordinate);
        this.hp = hp;
        this.speed = speed;
    }

    public abstract void makeMove(GameMap map);
}
