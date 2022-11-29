package Characters;

import java.util.ArrayList;
import java.util.Iterator;


public class Team implements Iterable<BaseNpc> {
    private final ArrayList<BaseNpc> team = new ArrayList<>();
    public final String teamColor;

    public Team(String teamColor){
        this.teamColor = teamColor;
    }

    public void add(BaseNpc npc) {
        team.add(npc);
    }

    public void printAll(){
        team.forEach(System.out::println);
    }

    public BaseNpc getNpcWithLeastHP(){
        BaseNpc toHeal = team.get(0);
        for (BaseNpc teammate : team) {
            if (teammate.getHealth() / teammate.getMaxHealth() < toHeal.getHealth() / toHeal.getMaxHealth()) {
                toHeal = teammate;
            }
        }
        return toHeal;
    }


    @Override
    public Iterator<BaseNpc> iterator() {
        return team.iterator();
    }

//    @Override
//    public void forEach(Consumer action) {
//        Iterable.super.forEach(action);
//    }
//
//    @Override
//    public Spliterator spliterator() {
//        return Iterable.super.spliterator();
//    }
}
