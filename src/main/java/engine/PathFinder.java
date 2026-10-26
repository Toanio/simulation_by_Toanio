package engine;

import model.entity.Entity;
import model.map.Coordinate;
import model.map.GameMap;

import java.util.*;

public class PathFinder {
    private static final List<Coordinate> SHIFT_COORDINATES = List.of(
            new Coordinate(-1,0),
            new Coordinate(+1, 0),
            new Coordinate(0, -1),
            new Coordinate(0, +1)
    );

    public List<Coordinate> findPath(GameMap map, Coordinate start, Class<?> targetType) {
        Queue<Coordinate> queue = new ArrayDeque<>();
        Set<Coordinate> visited = new HashSet<>();
        Map<Coordinate, Coordinate> parentMap = new HashMap<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();

            boolean isCurrentTarget = map.getEntityByCoordinate(current)
                    .filter(targetType::isInstance)
                    .isPresent();

            if (isCurrentTarget) {
                List<Coordinate> path = new ArrayList<>();
                Coordinate buffer = current;
                while (buffer != null) {
                    path.add(buffer);
                    buffer = parentMap.get(buffer);
                }

                return path.reversed();
            }

            List<Coordinate> neighbors = getNeighbors(current);

            for (Coordinate neighbor : neighbors) {
                if (isValidStep(map, neighbor, visited, targetType)) {
                    parentMap.put(neighbor, current);
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }
        return Collections.emptyList();
    }

    private boolean isValidStep(GameMap map, Coordinate neighbor, Set<Coordinate> visited, Class<?> targetType) {
        boolean isTarget = map.getEntityByCoordinate(neighbor)
                .filter(targetType::isInstance)
                .isPresent();
        return map.isCoordinateValid(neighbor)
                && !visited.contains(neighbor)
                && (map.isCoordinateEmpty(neighbor)
                || isTarget);
    }

    private List<Coordinate> getNeighbors(Coordinate coordinate) {
        List<Coordinate> neighbors = new ArrayList<>();
        for (Coordinate shift: SHIFT_COORDINATES) {
            Coordinate neighbor = new Coordinate(coordinate.x() + shift.x(), coordinate.y() + shift.y());
            neighbors.add(neighbor);
        }
        return neighbors;
    }

}
