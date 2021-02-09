package e1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrasgoTest {

    @Test
    void ataque() {
        int vidaGandalf = 1500;
        int valorDadoTrucado = 17;
        Dado dado = new DadoTrucado(5);
        Trasgo Mauhur = new Trasgo("Mauhur", 1500, 10, dado);
        Humano Gandalf = new Humano("Gandalf", vidaGandalf, 10, dado);
        Mauhur.ataque(Gandalf);
        assertEquals(vidaGandalf-valorDadoTrucado+Gandalf.getArmadura(), Gandalf.getSalud());
    }

    @Test
    void getSalud() {
        int valorVida = 1500;
        Dado dado = new Dado();
        Trasgo Mauhur = new Trasgo("Mauhur", valorVida, 10, dado);
        assertEquals(valorVida, Mauhur.getSalud());
    }

    @Test
    void setSalud() {
        int valorVida = 1500;
        Dado dado = new Dado();
        Trasgo Mauhur = new Trasgo("Mauhur", 5, 10, dado);
        Mauhur.setSalud(valorVida);
        assertEquals(valorVida, Mauhur.getSalud());
    }

    @Test
    void getArmadura() {
        int valorArmdura = 20;
        Dado dado = new Dado();
        Trasgo Mauhur = new Trasgo("Mauhur", 1500, valorArmdura, dado);
        assertEquals(valorArmdura, Mauhur.getArmadura());
    }

    @Test
    void setArmadura() {
        int valorArmdura = 20;
        Dado dado = new Dado();
        Trasgo Mauhur = new Trasgo("Mauhur", 1500, 10, dado);
        Mauhur.setArmadura(valorArmdura);
        assertEquals(valorArmdura, Mauhur.getArmadura());
    }

    @Test
    void getNombre() {
        String nombre = "Mauhur";
        Dado dado = new Dado();
        Trasgo Mauhur = new Trasgo(nombre, 1500, 10, dado);
        assertEquals(nombre, Mauhur.getNombre());
    }

    @Test
    void setNombre() {
        String nombre = "Mauhur";
        Dado dado = new Dado();
        Trasgo Mauhur = new Trasgo("Mauhur", 1500, 10, dado);
        Mauhur.setNombre(nombre);
        assertEquals(nombre, Mauhur.getNombre());
    }
}