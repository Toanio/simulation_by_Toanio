package view;

import model.entity.*;
import model.map.Coordinate;
import model.map.GameMap;

import java.util.Map;

public class MapRenderer {
    private static final String GROUND = "\uD83D\uDFEB";
    private static final String GRASS = "☘️";
    private static final String RABBIT = "\uD83D\uDC07";
    private static final String WOLF = "\uD83D\uDC3A";
    private static final String ROCK = "\uD83E\uDEA8";
    private static final String TREE = "\uD83C\uDF32";

    private static final Map<Class<?>, String> sprites = Map.of(
            Grass.class, GRASS,
            Wolf.class, WOLF,
            Rabbit.class, RABBIT,
            Rock.class, ROCK,
            Tree.class, TREE
    );

    public void render(GameMap map) {
        for (int y = 0; y < map.getHeight(); y++) {
            for (int x = 0; x < map.getWidth(); x++) {
                Coordinate coordinate = new Coordinate(x, y);
                if (!map.isCoordinateEmpty(coordinate)) {
                    map.getEntityByCoordinate(coordinate)
                            .ifPresent(entity -> IO.print(sprites.get(entity.getClass())));
                } else {
                    IO.print(GROUND);
                }
            }
            IO.println();
        }
    }
}
