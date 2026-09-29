package action;

import model.entity.Creature;
import model.map.GameMap;

import java.util.List;

public class MakeMoveAction implements Action {
    @Override
    public void execute(GameMap map) {
        List<Creature> creatures = map.getCreature();
        for(Creature creature: creatures) {
            creature.makeMove(map);
        }
    }
}
