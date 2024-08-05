import lombok.Data;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Data
public class Config {
    public static Config instance;
    private int mapWidth;
    private int mapHeight;
    private int numberHerbivores;
    private int numberPredators;
    private int numberTrees;
    private int numberRocks;

    private Config() {
        FileInputStream fis;
        Properties property = new Properties();
        try {
            fis = new FileInputStream("src/main/resources/config.properties");
            property.load(fis);
            this.mapWidth = Integer.parseInt(property.getProperty("map.width"));
            this.mapHeight = Integer.parseInt(property.getProperty("map.height"));
            this.numberHerbivores = Integer.parseInt(property.getProperty("number.herbivores"));
            this.numberPredators = Integer.parseInt(property.getProperty("number.predators"));
            this.numberTrees = Integer.parseInt(property.getProperty("number.trees"));
            this.numberRocks = Integer.parseInt(property.getProperty("number.rocks"));
        } catch (IOException e) {
            System.err.println("Err: Configuration file was not found!");
        }
    }

    public static Config getInstance() {
        if (instance == null) {
            instance = new Config();
        }
        return instance;
    }
}
