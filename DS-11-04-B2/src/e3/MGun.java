package e3;

public class MGun implements Behavior{
    @Override
    public GunslingerAction action(Gunslinger g) {
        if(g.getLoads() < 5)
            g.action = GunslingerAction.RELOAD;
        else
            g.action  =GunslingerAction.MACHINE_GUN;
        return g.action;
    }
}
