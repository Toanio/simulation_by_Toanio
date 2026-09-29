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

    public Entity getEntityByCoordinate(Coordinate coordinate) {
        return  grid.get(coordinate);
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

    public boolean moveEntity(Entity entity, Coordinate coordinate) {
        if (isCoordinateEmpty(coordinate)) {
            deleteEntity(entity.getCoordinate());
            entity.setCoordinate(coordinate);
            addEntity(entity);
            return true;
        } else {
            return false;
        }
    }

    private Coordinate getRandomCoordinate() {
        int x = random.nextInt(width);
        int y = random.nextInt(height);

        return new Coordinate(x, y);
    }

    public Coordinate getRandomEmptyCoordinate() {
        while (true) {
            Coordinate coordinate = getRandomCoordinate();
            if (isCoordinateEmpty(coordinate)) {
                return coordinate;
            }
        }
    }

    public List<Creature> getCreature() {
        List<Creature> creaturesList = new ArrayList<>();
        for(Entity entity: grid.values()) {
            if(entity instanceof Creature creature) {
                creaturesList.add(creature);
            }
        }
        return creaturesList;
    }
}
