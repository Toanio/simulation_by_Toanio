package model.entity;

import model.map.Coordinate;

public class Tree extends Entity {
    public Tree(Coordinate coordinate) {
        super("Дерево", "\uD83C\uDF32", coordinate);
    }
}
