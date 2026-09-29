package action.spawn;

import model.entity.Entity;
import model.entity.Tree;
import model.map.Coordinate;

public class SpawnTreeAction extends SpawnAction{

    public SpawnTreeAction(int countEntity) {
        super(countEntity);
    }

    @Override
    Entity createEntity(Coordinate coordinate) {
        return new Tree(coordinate);
    }
}
