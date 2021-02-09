package e3;

public class Gunfight {

    public void duel(Gunslinger g1, Gunslinger g2) {
        int i = 1;
        Basic basic = new Basic();
        MGun mGun = new MGun();
        Defensive def = new Defensive();

        //Definimos el comportamiento que tienen que tener los pistoleros
        g1.setBehavior(def);
        g2.setBehavior(basic);

        while ((g1.alive && g2.alive) && i <= 50) {
            g1.action = g1.action();
            g2.action = g2.action();
            System.out.println("Round " + i + "-------------------------\n");
            System.out.println("Gunslinger 1: " + g1.action);
            System.out.println("Gunslinger 2: " + g2.action);

            g1.rivalAction(g2.action);
            g2.rivalAction(g1.action);
            g1.setRivalLoads();
            g2.setRivalLoads();
            alive(g1, g2);
            alive(g2, g1);

            i++;
        }
        System.out.println("The duel has ended\n");
        if((g1.alive && g2.alive) || (!g1.alive && !g2.alive))
            System.out.println("DRAW\n");
        else {
            if(g1.alive)
                System.out.println("Winner: GUNSLINGER 1\n");
            if(g2.alive)
                System.out.println("Winner: GUNSLINGER 2\n");
        }
    }

    public void alive(Gunslinger g1, Gunslinger g2) {
        if(g1.action == GunslingerAction.SHOOT) {
            if(g2.action == GunslingerAction.RELOAD)
                g2.alive = false;
            if(g2.action == GunslingerAction.SHOOT)
                g2.alive = false;
        }
        if(g1.action == GunslingerAction.MACHINE_GUN)
            g2.alive = false;
    }
}
