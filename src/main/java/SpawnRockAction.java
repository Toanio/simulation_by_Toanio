public class SpawnRockAction extends SpawnAction{
    public SpawnRockAction(int countEntity) {
        super(countEntity);
    }

    @Override
    Entity createEntity(Coordinate coordinate) {
        return new Rock(coordinate);
    }
}
