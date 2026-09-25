import java.util.List;

public class Herbivore extends Creature{
    public Herbivore(String name, String image, Coordinate coordinate, int hp, int speed) {
        super(name, image, coordinate, hp, speed, Grass.class);
    }

    public void findResource(GameMap map) {
        List<Coordinate> possibleCoordinate = this.getNeighborCoordinates(map);

        for (Coordinate coordinate : possibleCoordinate) {
            if (map.getEntityByCoordinate(coordinate) instanceof Grass grass) {
                grass.takeResource(10);
                IO.println("Успешная съел травы " + grass.getResourceAmount());
                IO.println("Координаты зайца " + this.getCoordinate());
                IO.println("Координаты трава " + grass.getCoordinate());
            }
        }

    }

    public void takeDamage(int attackPower) {
        this.setHp(this.getHp() - attackPower);
    }

}
