package view;

import model.map.Coordinate;
import model.map.GameMap;

public class MapRenderer {
    public MapRenderer() {
    }

    public void render(GameMap map) {
        for (int i = 0; i < map.getHeight(); i++) {
            for (int j = 0; j < map.getWidth(); j++) {
                Coordinate coordinate = new Coordinate(j, i);
                if (!map.isCoordinateEmpty(coordinate)) {
                    IO.print(map.getEntityByCoordinate(coordinate).getImage());
                } else {
                    IO.print(". ");
                }
            }
            IO.println();
        }
    }
}
