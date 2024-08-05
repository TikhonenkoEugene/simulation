import objects.*;

public class Render {
    private final static String grass = "\uD83C\uDF3F";
    private final static String rock = "\uD83E\uDEA8";
    private final static String tree = "\uD83C\uDF32";
    private final static String herbivore = "\uD83E\uDD92";
    private final static String predator = "\uD83D\uDC05";
    private final MyMap myMap;
    private final Config config;

    public Render() {
        this.myMap = MyMap.getInstance();
        this.config = Config.getInstance();
    }

    public void print() {
        String[][] pictures = new String[config.getMapWidth()][config.getMapHeight()];
        myMap.getEntities().forEach(it -> {
                    int i = it.getPosX() - 1;
                    int j = it.getPosY() - 1;
                    if (it instanceof Herbivore) {
                        pictures[i][j] = herbivore;
                    } else if (it instanceof Predator) {
                        pictures[i][j] = predator;
                    } else if (it instanceof Rock) {
                        pictures[i][j] = rock;
                    } else if (it instanceof Tree) {
                        pictures[i][j] = tree;
                    } else {
                        pictures[i][j] = grass;
                    }
                });

        for (int i = 0; i < config.getMapWidth(); i++) {
            for (int j = 0; j < config.getMapHeight(); j++) {
                System.out.print(pictures[i][j]);
            }
            System.out.println();
        }
    }
}
