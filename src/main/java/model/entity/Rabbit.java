package model.entity;

import model.map.Coordinate;

public class Rabbit extends Herbivore {
    static int DEFAULT_HP = 200;
    static int DEFAULT_SPEED = 1;
    static int DEFAULT_EAT_POWER = 10;

    public Rabbit(Coordinate coordinate) {
        super("Заяц", coordinate, DEFAULT_HP,DEFAULT_SPEED, DEFAULT_EAT_POWER);
    }
}
