public class SpawnWolfAction extends SpawnAction{
    public SpawnWolfAction(int countEntity) {
        super(countEntity);
    }

    @Override
    Entity createEntity(Coordinate coordinate) {
        return new Wolf(coordinate);
    }
}
