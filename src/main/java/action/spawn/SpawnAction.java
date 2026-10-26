package action.spawn;

import action.Action;
import model.entity.Entity;
import model.map.Coordinate;
import model.map.GameMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public abstract class SpawnAction implements Action {
    private final int countEntity;
    private final Random random = new Random();

    public SpawnAction(int countEntity) {
        this.countEntity = countEntity;
    }

    abstract Entity createEntity(Coordinate coordinate);

    @Override
    public void execute(GameMap map) {
        for (int i = 0; i < countEntity; i++) {
            Coordinate coordinate = getRandomEmptyCoordinate(map);
            Entity entity = createEntity(coordinate);
            map.addEntity(entity, coordinate);
        }
    }

    private Coordinate getRandomCoordinate(GameMap map) {
        int x = random.nextInt(map.getWidth());
        int y = random.nextInt(map.getHeight());

        return new Coordinate(x, y);
    }

    public Coordinate getRandomEmptyCoordinate(GameMap map) {
        while (true) {
            Coordinate coordinate = getRandomCoordinate(map);
            if (map.isCoordinateEmpty(coordinate)) {
                return coordinate;
            }
        }
    }



}
