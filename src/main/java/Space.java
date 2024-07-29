import objects.Entity;

public class Space {
    private int posX;
    private int posY;
    private Entity entity;

    public Space(int posX, int posY, Entity entity) {
        this.posX = posX;
        this.posY = posY;
        this.entity = entity;
    }
}
