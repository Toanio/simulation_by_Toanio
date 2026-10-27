package engine;

import action.*;
import action.spawn.*;
import config.ConfigLoader;
import config.SimulationConfig;
import model.entity.*;
import model.map.GameMap;
import view.MapRenderer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Simulation {
    private GameMap map;

    MapRenderer renderer = new MapRenderer();

    int counter = 0;

    List<Action> initActions;
    List<Action> turnActions;
    private boolean isRunning = true;
    private volatile boolean isPaused = false;

    public Simulation(GameMap map, SimulationConfig config) {
        this.map = map;

        this.initActions = new ArrayList<>();
        this.turnActions = new ArrayList<>();

        initActions.add(new SpawnAction(Grass::new, config.grass().count()));
        initActions.add(new SpawnAction(Rabbit::new, config.rabbit().count()));
        initActions.add(new SpawnAction(Wolf::new, config.wolf().count()));
        initActions.add(new SpawnAction(Tree::new, config.tree().count()));
        initActions.add(new SpawnAction(Rock::new, config.rock().count()));

        turnActions.add(new MakeMoveAction());
    }

    public void init() {

        for (Action action : initActions) {
            action.execute(map);
        }
    }

    public void nextTurn() {
        counter += 1;
        IO.println("Ход №: " + counter);

        renderer.render(map);
        for (Action action : turnActions) {
            action.execute(map);
        }
    }

    public void startSimulation() {
        init();
        while (isRunning) {
            while (isPaused) {
                pause(100);
            }
            nextTurn();
            pause(500);
        }
    }

    public void pauseSimulation() {
        Scanner scanner = new Scanner(System.in);

        while (isRunning) {
            String userAction = scanner.nextLine();
            if (userAction.equals("p")) {
                IO.println("Игра поставлена на паузу");
                isPaused = true;
            } else if (userAction.equals("c")) {
                IO.println("Игра возобновлена");
                isPaused = false;
            }
        }
    }

    private void pause(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
