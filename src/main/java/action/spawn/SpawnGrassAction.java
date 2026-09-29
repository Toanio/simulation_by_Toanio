package action.spawn;

import model.entity.Entity;
import model.entity.Grass;
import model.map.Coordinate;

public class SpawnGrassAction extends SpawnAction{

    public SpawnGrassAction(int countEntity) {
        super(countEntity);
    }

    @Override
    Entity createEntity(Coordinate coordinate) {
        return new Grass(coordinate);
    }

}
