public class Render {
    private final static String ground = "\uD83D\uDFEB";
    private final static String grass = "\uD83C\uDF3F";
    private final static String rock = "\uD83E\uDEA8";
    private final static String tree = "\uD83C\uDF32";
    private final static String herbivore = "\uD83E\uDD92";
    private final static String predator = "\uD83D\uDC05";
    private final Map map;

    public Render(Map map) {
        this.map = map;
    }

    public void print() {
        // TODO: 05.07.2024
        System.out.println(ground + ground + predator + ground + tree + ground + grass + ground + ground + rock);
        System.out.println(ground + ground + ground + herbivore + tree + ground + rock + ground + ground + tree);
        System.out.println(herbivore + grass + ground + predator + rock + ground + tree + ground + ground + ground);
    }
}
