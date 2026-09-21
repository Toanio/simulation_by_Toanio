public abstract class Entity {
    private final String name;
    private final String image;
    private Coordinate coordinate;

    public Entity(String name, String image, Coordinate coordinate) {
        this.name = name;
        this.image = image;
        this.coordinate = coordinate;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }
}
