package e3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GunslingerTest {

    Defensive def = new Defensive();
    Basic basic = new Basic();
    MGun mGun = new MGun();

    @Test
    void setBehavior() {
        Gunslinger g1 = new Gunslinger();
        g1.setBehavior(def);
        assertEquals(def, g1.behavior);

        g1.setBehavior(basic);
        assertEquals(basic, g1.behavior);

        g1.setBehavior(mGun);
        assertEquals(mGun, g1.behavior);
    }

    @Test
    void action() {
        Gunslinger g1 = new Gunslinger();
        g1.setBehavior(mGun);
        assertEquals(GunslingerAction.RELOAD, g1.action());
        g1.loads = 5;
        assertEquals(GunslingerAction.MACHINE_GUN, g1.action());
    }

    @Test
    void getLoads() {
        Gunslinger g2 = new Gunslinger();
        g2.loads += 2;
        assertEquals(2, g2.getLoads());
    }

    @Test
    void rivalAction() {
        Gunslinger g1 = new Gunslinger();
        Gunslinger g2 = new Gunslinger();
        g2.action = GunslingerAction.RELOAD;
        g1.rivalAction(g2.action);
        g2.action = GunslingerAction.PROTECT;
        g1.rivalAction(g2.action);
        assertEquals("[RELOAD, PROTECT]", g1.list.toString());
    }

    @Test
    void getRivalActions() {
        Gunslinger g1 = new Gunslinger();
        Gunslinger g2 = new Gunslinger();
        g2.action = GunslingerAction.RELOAD;
        g1.rivalAction(g2.action);
        g2.action = GunslingerAction.PROTECT;
        g1.rivalAction(g2.action);
        g2.action = GunslingerAction.RELOAD;
        g1.rivalAction(g2.action);
        g2.action = GunslingerAction.SHOOT;
        g1.rivalAction(g2.action);
        assertEquals("[RELOAD, PROTECT, RELOAD, SHOOT]", g1.getRivalActions().toString());
    }

    @Test
    void getRivalLoads() {
        Gunslinger g1 = new Gunslinger();
        for(int i = 0; i < 5; i++) {
            g1.rivalAction(GunslingerAction.RELOAD);
            g1.setRivalLoads();
        }
        assertEquals(5, g1.getRivalLoads());
        g1.rivalAction(GunslingerAction.MACHINE_GUN);
        g1.setRivalLoads();
        assertEquals(0, g1.getRivalLoads());
    }

    @Test
    void Gunfight() {
        Gunslinger g1 = new Gunslinger();
        Gunslinger g2 = new Gunslinger();
        Gunfight duelo = new Gunfight();

        duelo.duel(g1, g2);
    }

}