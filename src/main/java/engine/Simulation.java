package engine;

import action.*;
import action.spawn.*;
import config.ConfigLoader;
import config.SimulationConfig;
import model.map.GameMap;
import view.MapRenderer;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
    SimulationConfig config = ConfigLoader.loadConfig();

    GameMap map = new GameMap(config.map().width(), config.map().height());
    MapRenderer renderer = new MapRenderer();

    int counter = 0;

    List<Action> initActions;
    List<Action> turnActions;
    private boolean isRunning = true;

    public Simulation() {
        this.initActions = new ArrayList<>();
        this.turnActions = new ArrayList<>();

        initActions.add(new SpawnGrassAction(config.grass().count()));
        initActions.add(new SpawnRabbitAction(config.rabbit().count()));
        initActions.add(new SpawnWolfAction(config.wolf().count()));
        initActions.add(new SpawnTreeAction(config.tree().count()));
        initActions.add(new SpawnRockAction(config.rock().count()));

        turnActions.add(new MakeMoveAction());
    }

    public void init() {

        for(Action action: initActions) {
            action.execute(map);
        }
    }

    public void nextTurn() {
        counter += 1;
        IO.println("Ход №: " + counter );

        renderer.render(map);
        for(Action action: turnActions) {
            action.execute(map);
        }
    }

    public void startSimulation() {
        init();
        while (isRunning) {
           nextTurn();

           try {
               Thread.sleep(500);
           } catch (InterruptedException e) {
              pauseSimulation();
           }
        }
    }

    public void pauseSimulation() {
        isRunning = false;
    }
}
