package engine;

import model.entity.Entity;
import model.map.Coordinate;
import model.map.GameMap;

import java.util.*;

public class PathFinder {

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

            List<Coordinate> neighbors = new ArrayList<>();

            Coordinate leftNeighbor = new Coordinate(current.x() - 1, current.y());
            Coordinate rightNeighbor = new Coordinate(current.x() + 1, current.y());
            Coordinate upNeighbor = new Coordinate(current.x(), current.y() - 1);
            Coordinate downNeighbor = new Coordinate(current.x(), current.y() + 1);

            neighbors.add(leftNeighbor);
            neighbors.add(rightNeighbor);
            neighbors.add(upNeighbor);
            neighbors.add(downNeighbor);

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

}
