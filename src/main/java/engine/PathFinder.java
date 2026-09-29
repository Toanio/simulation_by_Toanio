package engine;

import model.entity.Entity;
import model.map.Coordinate;
import model.map.GameMap;

import java.util.*;

public class PathFinder {

    public PathFinder() {
    }

    public List<Coordinate> findPath(GameMap map, Coordinate start, Class<?> targetType) {
        Queue<Coordinate> queue = new ArrayDeque<>();
        Set<Coordinate> visited = new HashSet<>();
        Map<Coordinate, Coordinate> parentMap = new HashMap<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();
            Entity entity = map.getEntityByCoordinate(current);
            if (targetType.isInstance(entity)) {
                List<Coordinate> path = new ArrayList<>();
                Coordinate buffer = current;
                while (buffer != null) {
                    path.add(buffer);
                    buffer = parentMap.get(buffer);
                }

                return path.reversed();
            } else {

                List<Coordinate> neighbors = new ArrayList<>();

                Coordinate leftNeighbor = new Coordinate(current.x() - 1, current.y());
                Coordinate rightNeighbor = new Coordinate(current.x() + 1, current.y());
                Coordinate upNeighbor = new Coordinate(current.x(), current.y() - 1);
                Coordinate downNeighbor = new Coordinate(current.x(), current.y() + 1);

                neighbors.add(leftNeighbor);
                neighbors.add(rightNeighbor);
                neighbors.add(upNeighbor);
                neighbors.add(downNeighbor);

                for(Coordinate neighbor: neighbors) {
                    if (map.isCoordinateValid(neighbor) && !visited.contains(neighbor) && (map.isCoordinateEmpty(neighbor)
                            || targetType.isInstance(map.getEntityByCoordinate(neighbor)))) {
                        parentMap.put(neighbor, current);
                        queue.add(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
        }
        return Collections.emptyList();
    }

}
