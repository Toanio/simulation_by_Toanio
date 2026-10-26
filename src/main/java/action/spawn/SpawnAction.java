package action.spawn;

import action.Action;
import model.entity.Entity;
import model.map.Coordinate;
import model.map.GameMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;

public class SpawnAction implements Action {
    private final int countEntity;
    private final Random random = new Random();
    private final Function<Coordinate, Entity> entityCreator;

    public SpawnAction(Function<Coordinate, Entity> entityCreator, int countEntity ) {
        this.entityCreator = entityCreator;
        this.countEntity = countEntity;
    }

    @Override
    public void execute(GameMap map) {
        for (int i = 0; i < countEntity; i++) {
            Coordinate coordinate = getRandomEmptyCoordinate(map);
            if (coordinate != null) {
                Entity entity = entityCreator.apply(coordinate);
                map.addEntity(entity, coordinate);
            }
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
