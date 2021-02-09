package e3;

public class Defensive implements Behavior {
    @Override
    public GunslingerAction action(Gunslinger g) {
        if(g.getLoads() == 0)
            g.action = GunslingerAction.RELOAD;
        if(g.getRivalLoads() > 0)
            g.action = GunslingerAction.PROTECT;
        if(g.getLoads() > 0 && g.getRivalLoads() == 0)
            g.action = GunslingerAction.SHOOT;
        return g.action;
    }
}
