package action.spawn;

import action.Action;
import model.entity.Entity;
import model.map.Coordinate;
import model.map.GameMap;

public abstract class SpawnAction implements Action {
    private final int countEntity;

    public SpawnAction(int countEntity) {
        this.countEntity = countEntity;
    }

    abstract Entity createEntity(Coordinate coordinate);

    @Override
    public void execute(GameMap map) {
        for (int i = 0; i < countEntity; i++) {
            map.addEntity(createEntity(map.getRandomEmptyCoordinate()));
        }
    }
}
