public class SpawnGrassAction extends SpawnAction{

    public SpawnGrassAction(int countEntity) {
        super(countEntity);
    }

    @Override
    Entity createEntity(Coordinate coordinate) {
        return new Grass(coordinate);
    }

}
