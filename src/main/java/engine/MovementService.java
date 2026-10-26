package engine;

import model.entity.Entity;
import model.map.Coordinate;
import model.map.GameMap;

public class MovementService {

    public boolean moveEntity(Entity entity, Coordinate coordinate, GameMap map) {
        if (map.isCoordinateEmpty(coordinate)) {
            map.deleteEntity(entity.getCoordinate());
            entity.setCoordinate(coordinate);
            map.addEntity(entity, coordinate);
            return true;
        } else {
            return false;
        }
    }
}
