package e3;

import java.util.ArrayList;
import java.util.List;

public class Gunslinger {
    public int loads;
    public int rivalLoads;
    public GunslingerAction action;
    public boolean alive;
    public Behavior behavior;
    public List<GunslingerAction> list;

    //Constructor
    public Gunslinger() {
        this.loads = 0;
        this.alive = true;
        this.action = null;
        this.list = new ArrayList<>();
    }

    //Decide qué acción realizar
    public GunslingerAction action() {
        this.action = this.behavior.action(this);
        if(this.action == GunslingerAction.SHOOT)
            this.loads--;
        if(this.action == GunslingerAction.RELOAD)
            this.loads++;
        if(this.action == GunslingerAction.MACHINE_GUN)
            this.loads -= 5;
        return this.action;
    }

    //Devolver el número de cargas del pistolero
    public int getLoads() {
        return this.loads;
    }

    //Almacena la última acción del rival
    public void rivalAction(GunslingerAction action) {
        this.list.add(action);
    }

    //Devolver la lista con las acciones del rival
    public List<GunslingerAction> getRivalActions() {
        return this.list;
    }

    //Devolver las cargas del rival
    public int getRivalLoads() {
        return rivalLoads;
    }

    //Actualizar las cargas del rival
    public void setRivalLoads() {
        int i = list.size()-1;
        if(list.get(i) == GunslingerAction.RELOAD)
            rivalLoads++;
        if(list.get(i) == GunslingerAction.SHOOT)
            rivalLoads--;
        if(list.get(i) == GunslingerAction.MACHINE_GUN)
            rivalLoads -= 5;
    }

    //Establecer el comportamiento del pistolero
    public void setBehavior(Behavior behavior) {
        this.behavior = behavior;
    }

}
