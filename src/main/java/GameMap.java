import java.util.HashMap;
import java.util.Map;

public class GameMap {
    private final int width;
    private final int height;
    private final Map<Coordinate, Entity> grid = new HashMap<>();

    public GameMap(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void addEntity(Entity entity) {
        grid.put(entity.getCoordinate(), entity);
    }

    public Entity getEntityByCoordinate(Coordinate coordinate) {
        return  grid.get(coordinate);
    }

    public void deleteEntity(Coordinate coordinate) {
        grid.remove(coordinate);
    }

    public boolean isCoordinateEmpty(Coordinate coordinate) {
        return !grid.containsKey(coordinate);
    }
}
