package model.entity;

import model.map.Coordinate;
import model.map.GameMap;

public class Herbivore extends Creature{
    int eatPower;

    public Herbivore(String name, Coordinate coordinate, int hp, int speed, int eatPower) {
        super(name, coordinate, hp, Grass.class);
        this.eatPower = eatPower;
    }

    public void takeDamage(int attackPower) {
        this.setHp(this.getHp() - attackPower);
    }

    @Override
    protected void interact(GameMap map, Coordinate coordinate) {
        map.getEntityByCoordinate(coordinate)
                .filter(entity -> entity instanceof Grass)
                .map(entity -> (Grass) entity)
                .ifPresent(grass -> {
                    grass.takeResource(eatPower);
                    if (grass.isEmpty()) {
                        map.deleteEntity(coordinate);
                    }
                });
    }
}
