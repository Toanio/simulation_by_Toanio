package action.spawn;

import model.entity.Entity;
import model.entity.Rock;
import model.map.Coordinate;

public class SpawnRockAction extends SpawnAction{
    public SpawnRockAction(int countEntity) {
        super(countEntity);
    }

    @Override
    Entity createEntity(Coordinate coordinate) {
        return new Rock(coordinate);
    }
}
