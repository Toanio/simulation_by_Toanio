import java.util.*;

public class Rabbit extends Creature{

    public Rabbit(Coordinate coordinate) {
        super("Заяц", "\uD83D\uDC07", coordinate, 100, 1);

    }

    public Rabbit(int x, int y) {
        this(new Coordinate(x, y));
    }


    @Override
    public void makeMove(GameMap map) {
        List<Coordinate> possibleMoves = possibleMovesCoordinates(map);

        if (possibleMoves.isEmpty()) {
            return;
        }

        Coordinate nextMove = getRandomMovesCoordinate(possibleMoves);
        map.moveEntity(this, nextMove);
    }

    private List<Coordinate> possibleMovesCoordinates(GameMap map) {
        List<Coordinate> newCoordinate = new ArrayList<>();

        for (int i = this.getCoordinate().x() - 1; i <= this.getCoordinate().x() + 1; i++) {
            for (int j = this.getCoordinate().y() - 1; j <= this.getCoordinate().y() + 1; j++) {
                if (!(i == this.getCoordinate().x() && j == this.getCoordinate().y())) {
                    if (map.isCoordinateEmpty(new Coordinate(i, j))) {
                        newCoordinate.add(new Coordinate(i, j));
                    }
                }
            }
        }
        return newCoordinate;
    }

    private Coordinate getRandomMovesCoordinate(List<Coordinate> possibleMoves) {
        Random random = new Random();
        int randomIndex = random.nextInt(possibleMoves.size());
        return possibleMoves.get(randomIndex);
    }
}
