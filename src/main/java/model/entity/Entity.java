package model.entity;

public abstract class Entity {
    private final String name;
    private final String image;

    public Entity(String name, String image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

}
