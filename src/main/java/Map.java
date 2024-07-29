import objects.Entity;

import java.util.HashMap;

public class Map {
    private HashMap<Coordinates, Entity> entities;
    private int width;
    private int height;

    public Map(int width, int height) {
        this.entities = new HashMap<>(width * height);
        this.width = width;
        this.height = height;
    }
}
