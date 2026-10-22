package action;

import model.entity.Creature;
import model.entity.Entity;
import model.map.GameMap;

import java.util.ArrayList;
import java.util.List;

public class MakeMoveAction implements Action {
    @Override
    public void execute(GameMap map) {
        List<Entity> entities = new ArrayList<>(map.getAllEntities());

        for (Entity entity: entities) {
            if (entity instanceof Creature creature) {
                creature.makeMove(map);
            }
        }
    }
}
