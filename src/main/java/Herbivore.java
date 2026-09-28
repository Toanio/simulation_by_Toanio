import java.util.List;

public class Herbivore extends Creature{
    int eatPower;

    public Herbivore(String name, String image, Coordinate coordinate, int hp, int speed, int eatPower) {
        super(name, image, coordinate, hp, Grass.class);
        this.eatPower = eatPower;
    }

    public void takeDamage(int attackPower) {
        this.setHp(this.getHp() - attackPower);
    }

    @Override
    protected void interact(GameMap map, Coordinate coordinate) {
        if (map.getEntityByCoordinate(coordinate) instanceof Grass grass) {
            grass.takeResource(eatPower);
            if (grass.isEmpty()) {
                map.deleteEntity(grass.getCoordinate());
            }
        }
    }
}
