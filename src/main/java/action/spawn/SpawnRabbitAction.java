package action.spawn;

import model.entity.Entity;
import model.entity.Rabbit;
import model.map.Coordinate;

public class SpawnRabbitAction extends SpawnAction{

    public SpawnRabbitAction(int countEntity) {
        super(countEntity);
    }

    @Override
    Entity createEntity(Coordinate coordinate) {
        return new Rabbit(coordinate);
    }
}
