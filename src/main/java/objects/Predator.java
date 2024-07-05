package objects;

public class Predator extends Creature {
    private int attackPower;

    public Predator() {
        this.attackPower = 1;
        super.health = 3;
        super.speed = 2;
    }

    @Override
    public void makeMove() {
        // TODO: 05.07.2024

    }
}
