public class SpawnRabbitAction extends SpawnAction{

    public SpawnRabbitAction(int countEntity) {
        super(countEntity);
    }

    @Override
    Entity createEntity(Coordinate coordinate) {
        return new Rabbit(coordinate);
    }
}
