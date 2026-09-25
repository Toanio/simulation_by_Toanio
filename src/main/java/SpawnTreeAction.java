public class SpawnTreeAction extends SpawnAction{

    public SpawnTreeAction(int countEntity) {
        super(countEntity);
    }

    @Override
    Entity createEntity(Coordinate coordinate) {
        return new Tree(coordinate);
    }
}
