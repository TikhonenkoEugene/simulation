public class Application {
    public static void main(String[] args) {
        Simulation simulation = new Simulation();
        simulation.startSimulation();
        Render render = new Render();
        render.print();
    }
}
