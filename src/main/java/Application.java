public class Application {
    public static void main(String[] args) {
        Render render = new Render(new Map(10, 10));
        render.print();
    }
}
