package model.map;

import model.entity.Creature;
import model.entity.Entity;

import java.util.*;

public class GameMap {
    private final int width;
    private final int height;
    private final Map<Coordinate, Entity> grid = new HashMap<>();
    private final Random random = new Random();

    public GameMap(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void addEntity(Entity entity) {
        grid.put(entity.getCoordinate(), entity);
    }

    public Collection<Entity> getAllEntities() {
        return grid.values();
    }

    public Optional<Entity> getEntityByCoordinate(Coordinate coordinate) {
        return  Optional.ofNullable(grid.get(coordinate));
    }

    public void deleteEntity(Coordinate coordinate) {
        grid.remove(coordinate);
    }

    public boolean isCoordinateEmpty(Coordinate coordinate) {
        if (isCoordinateValid(coordinate)) {
            return !grid.containsKey(coordinate);
        } else {
            return false;
        }

    }

    public boolean isCoordinateValid(Coordinate coordinate) {
        return 0 <= coordinate.x() && coordinate.x() < width
                && 0 <= coordinate.y() && coordinate.y() < height;
    }


}
