package engine;

import model.entity.Creature;
import model.entity.Entity;
import model.map.Coordinate;
import model.map.GameMap;

public class MovementService {

    public boolean moveEntity(Creature creature, Coordinate coordinate, GameMap map) {
        if (map.isCoordinateEmpty(coordinate)) {
            map.deleteEntity(creature.getCoordinate());
            creature.setCoordinate(coordinate);
            map.addEntity(creature, coordinate);
            return true;
        }
        return false;
    }
}
