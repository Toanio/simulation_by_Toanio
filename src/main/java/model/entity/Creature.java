package model.entity;

import engine.MovementService;
import engine.PathFinder;
import model.map.Coordinate;
import model.map.GameMap;

import java.util.List;

public abstract class Creature extends Entity{
    private int hp;
    private Class<?> target;
    private Coordinate coordinate;

    public Creature(String name, String image, Coordinate coordinate, int hp, Class<?> target) {
        super(name, image);
        this.coordinate = coordinate;
        this.hp = hp;
        this.target = target;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    protected abstract void interact(GameMap map, Coordinate coordinate);

    public void makeMove(GameMap map) {
        PathFinder pathFinder = new PathFinder();
        List<Coordinate> possibleMoves = pathFinder.findPath(map, getCoordinate(), target);

        if (possibleMoves.isEmpty()) {
            return;
        }

        if (possibleMoves.size() == 2) {
            this.interact(map, possibleMoves.get(1));
        } else {
            Coordinate nextMove = possibleMoves.get(1);

            MovementService movementService = new MovementService();
            movementService.moveEntity(this, nextMove, map);
        }
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public boolean isAlive() {
        return hp > 0;
    }
}
