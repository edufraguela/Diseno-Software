package e3;

public class Basic implements Behavior{

    @Override
    public GunslingerAction action(Gunslinger g) {
        if(g.getLoads() == 0 )
            g.action = GunslingerAction.RELOAD;
        if(g.getLoads() > 0)
            g.action = GunslingerAction.SHOOT;
        return g.action;
    }
}
