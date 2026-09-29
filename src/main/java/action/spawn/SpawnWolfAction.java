package action.spawn;

import model.entity.Entity;
import model.entity.Wolf;
import model.map.Coordinate;

public class SpawnWolfAction extends SpawnAction{
    public SpawnWolfAction(int countEntity) {
        super(countEntity);
    }

    @Override
    Entity createEntity(Coordinate coordinate) {
        return new Wolf(coordinate);
    }
}
