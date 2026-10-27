import config.ConfigLoader;
import config.SimulationConfig;
import engine.Simulation;
import model.map.GameMap;

void main() {
    SimulationConfig config = ConfigLoader.loadConfig();
    GameMap map = new GameMap(config.map().width(), config.map().height());

    Simulation simulation = new Simulation(map, config);
    new Thread(() -> simulation.startSimulation()).start();
    new Thread(() -> simulation.pauseSimulation()).start();
    try {
        Thread.sleep(10000);
    }catch (InterruptedException e) {
        e.printStackTrace();
    }
}
