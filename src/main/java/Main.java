import javax.swing.*;

void main() {
    Simulation simulation = new Simulation();
    new Thread(() -> simulation.startSimulation()).start();
    try {
        Thread.sleep(10000);
    }catch (InterruptedException e) {
        e.printStackTrace();
    }
    simulation.pauseSimulation();
}
