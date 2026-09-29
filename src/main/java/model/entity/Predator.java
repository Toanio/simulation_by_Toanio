package model.entity;

import model.map.Coordinate;
import model.map.GameMap;

public class Predator extends Creature {
    int attackPower;

    public Predator(String name, String image, Coordinate coordinate, int hp, int speed, int attackPower) {
        super(name, image, coordinate, hp, Herbivore.class);
        this.attackPower = attackPower;
    }

    @Override
    protected void interact(GameMap map, Coordinate coordinate) {
        if (map.getEntityByCoordinate(coordinate) instanceof Herbivore herbivore) {
            herbivore.takeDamage(attackPower);
            if (!herbivore.isAlive()) {
                map.deleteEntity(herbivore.getCoordinate());
            }
        }
    }
}
