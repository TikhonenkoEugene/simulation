import lombok.Data;
import objects.Entity;

import java.util.ArrayList;
import java.util.List;

@Data
public class MyMap {
    private static MyMap map;
    private final List<Entity> entities;
    private final Config config;
    private final int size;

    private MyMap() {
        this.config = Config.getInstance();
        this.size = config.getMapWidth() * config.getMapHeight();
        this.entities = new ArrayList<>();
    }

    public static MyMap getInstance() {
        if (map == null) {
            map = new MyMap();
        }
        return map;
    }

    public void addEntity(Entity entity) {
        this.entities.add(entity);
    }

}
