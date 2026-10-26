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

    public void addEntity(Entity entity, Coordinate coordinate) {
        validate(coordinate);
        grid.put(coordinate, entity);
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
        return isCoordinateValid(coordinate) && !grid.containsKey(coordinate);
    }

    public boolean isCoordinateValid(Coordinate coordinate) {
        return 0 <= coordinate.x() && coordinate.x() < width
                && 0 <= coordinate.y() && coordinate.y() < height;
    }

    public void validate(Coordinate coordinate) {
        if (!isCoordinateValid(coordinate)) {
            throw new IllegalArgumentException("The coordinate is outside the map boundaries");
        }
    }


}
