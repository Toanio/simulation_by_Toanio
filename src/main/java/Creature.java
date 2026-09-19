public abstract class Creature extends Entity{
    private int hp;
    private int speed;

    public Creature(String name, int coordinateX, int coordinateY, String image, int hp, int speed) {
        super(name, coordinateX, coordinateY, image);
        this.hp = hp;
        this.speed = speed;
    }

    public void makeMove() {

    }
}
