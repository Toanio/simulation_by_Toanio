import engine.Simulation;

void main() {
    Simulation simulation = new Simulation();
    new Thread(() -> simulation.startSimulation()).start();
    new Thread(() -> simulation.pauseSimulation()).start();
    try {
        Thread.sleep(10000);
    }catch (InterruptedException e) {
        e.printStackTrace();
    }
}
