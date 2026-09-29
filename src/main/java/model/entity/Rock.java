package model.entity;

import model.map.Coordinate;

public class Rock extends Entity {
    public Rock(Coordinate coordinate) {
        super("Камень", "\uD83E\uDEA8", coordinate);
    }
}
