import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Creature extends Entity{
    private int hp;
    private int speed;

    public Creature(String name, String image, Coordinate coordinate, int hp, int
                    speed) {
        super(name, image, coordinate);
        this.hp = hp;
        this.speed = speed;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getSpeed() {
        return speed;
    }

    public void makeMove(GameMap map) {
        List<Coordinate> possibleMoves = getNeighborCoordinates(map);

        if (possibleMoves.isEmpty()) {
            return;
        }

        Coordinate nextMove = getRandomMovesCoordinate(possibleMoves);
        map.moveEntity(this, nextMove);
    }

    public List<Coordinate> getNeighborCoordinates(GameMap map) {
        List<Coordinate> newCoordinate = new ArrayList<>();
        int currentX = this.getCoordinate().x();
        int currentY = this.getCoordinate().y();

        for (int i = currentX - speed; i <= currentX + speed; i++) {
            for (int j = currentY - speed; j <= currentY + speed; j++) {
                if (!(i == currentX && j == currentY)) {
                    newCoordinate.add(new Coordinate(i, j));
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

    public List<Coordinate> findCreature(GameMap map) {
        List<Coordinate> possibleCoordinate = getNeighborCoordinates(map);
        List<Coordinate> possibleCreature = new ArrayList<>();

        for (Coordinate coordinate : possibleCoordinate) {
            if (!map.isCoordinateEmpty(coordinate)) {
                possibleCreature.add(coordinate);
            }
        }
        return possibleCreature;
    }

    public boolean isALive() {
        return hp > 0;
    }
}
