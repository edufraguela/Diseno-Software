package e3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GunfightTest {

    @Test
    void duel() {
        Gunslinger g1 = new Gunslinger();
        Gunslinger g2 = new Gunslinger();
        Gunfight gf = new Gunfight();
        gf.duel(g1, g2);
    }

    @Test
    void alive() {
        Gunslinger g1 = new Gunslinger();
        Gunslinger g2 = new Gunslinger();
        Gunfight gf = new Gunfight();

        g1.action = GunslingerAction.SHOOT;
        g2.action = GunslingerAction.RELOAD;
        gf.alive(g1, g2);
        assertFalse(g2.alive);

        g1.action = GunslingerAction.SHOOT;
        g2.action = GunslingerAction.SHOOT;
        gf.alive(g1, g2);
        gf.alive(g2, g1);
        assertFalse(g2.alive);
        assertFalse(g1.alive);

        g1.action = GunslingerAction.MACHINE_GUN;
        g2.action = GunslingerAction.PROTECT;
        gf.alive(g1, g2);
        assertFalse(g2.alive);
    }
}