import java.util.List;

public class Predator extends Creature{
    int attackPower;
    public Predator(String name, String image, Coordinate coordinate, int hp, int speed, int attackPower) {
        super(name, image, coordinate, hp, speed);
        this.attackPower = attackPower;
    }


    public void attack(GameMap map) {
        List<Coordinate> possibleCreature = this.findCreature(map);
        for (Coordinate coordinate : possibleCreature) {
            if (map.getEntityByCoordinate(coordinate) instanceof Herbivore herbivore) {
                herbivore.takeDamage(attackPower);
                IO.println("Успешная атака у зайца осталось жизней " + herbivore.getHp());
                IO.println("Координаты волка " + this.getCoordinate());
                IO.println("Координаты зайца " + herbivore.getCoordinate());
            }
        }
    }
}
