package objects;

public abstract class Creature extends Entity {
    protected int speed;
    protected int health;
    protected abstract void makeMove();
}
