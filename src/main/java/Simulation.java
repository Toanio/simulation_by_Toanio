import java.util.ArrayList;
import java.util.List;

public class Simulation {
    GameMap map = new GameMap(10, 10);
    MapRenderer renderer = new MapRenderer();

    List<Action> initActions;
    List<Action> turnActions;
    private boolean isRunning = true;

    public Simulation() {
        this.initActions = new ArrayList<>();
        this.turnActions = new ArrayList<>();

        initActions.add(new SpawnGrassAction(5));
        initActions.add(new SpawnRabbitAction(10));
        initActions.add(new SpawnWolfAction(5));
        initActions.add(new SpawnTreeAction(4));
        initActions.add(new SpawnRockAction(5));

        turnActions.add(new MakeMoveAction());
    }

    public void init() {

        for(Action action: initActions) {
            action.execute(map);
        }
    }

    public void nextTurn() {
        renderer.render(map);
        for(Action action: turnActions) {
            action.execute(map);
        }
        IO.println("Следующий ход");
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
