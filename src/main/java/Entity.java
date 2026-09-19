public abstract class Entity {
    private final String name;
    private int coordinateX;
    private int coordinateY;
    private final String image;

    public Entity(String name, int coordinateX, int coordinateY, String image) {
        this.name = name;
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public int getCoordinateX() {
        return coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }

    public String getImage() {
        return image;
    }
}
