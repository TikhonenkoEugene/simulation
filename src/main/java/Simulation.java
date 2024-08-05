import objects.*;

import java.util.Collections;

public class Simulation {
    private final MyMap myMap;
    private final Config config;
    private int counter;

    public Simulation() {
        this.myMap = MyMap.getInstance();
        this.config = Config.getInstance();
    }

    public void nextTurn() {
        // TODO: 05.07.2024

    }

    public void startSimulation() {
        // Add herbivores
        for (int i = 1; i <= config.getNumberHerbivores(); i++) {
            myMap.addEntity(new Herbivore());
        }

        // Add predators
        for (int i = 1; i <= config.getNumberPredators(); i++) {
            myMap.addEntity(new Predator());
        }

        // Add rocks
        for (int i = 1; i <= config.getNumberRocks(); i++) {
            myMap.addEntity(new Rock());
        }

        // Add trees
        for (int i = 1; i <= config.getNumberTrees(); i++) {
            myMap.addEntity(new Tree());
        }

        // Add grass
        final int numberOfGrass = myMap.getSize() - (config.getNumberHerbivores() +
                config.getNumberPredators() + config.getNumberTrees() + config.getNumberRocks());
        for (int i = 1; i <= numberOfGrass; i++) {
            myMap.addEntity(new Grass());
        }

        // Random objects on the map
        Collections.shuffle(myMap.getEntities());

        // Add coordinates
        int element = 0;
        for (int x = 1; x <= config.getMapWidth(); x++) {
            for (int y = 1; y <= config.getMapHeight(); y++) {
                myMap.getEntities().get(element).setPosX(x);
                myMap.getEntities().get(element).setPosY(y);
                element++;
            }
        }
    }

    public void pauseSimulation() {
        // TODO: 05.07.2024

    }
}
