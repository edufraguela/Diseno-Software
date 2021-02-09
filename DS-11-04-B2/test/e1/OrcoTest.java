package e1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrcoTest {

    @Test
    void ataque() {
        int vidaGandalf = 1500;
        int valorDadoTrucado = 17;
        Dado dado = new DadoTrucado(5);
        Orco Lurtz = new Orco("Lurtz", 1500, 10, dado);
        Humano Gandalf = new Humano("Gandalf", vidaGandalf, 10, dado);
        Lurtz.ataque(Gandalf);
        assertEquals(vidaGandalf-valorDadoTrucado-Math.round(0.1* Gandalf.getArmadura())+Gandalf.getArmadura(), Gandalf.getSalud());
    }

    @Test
    void getSalud() {
        int valorVida = 1500;
        Dado dado = new Dado();
        Orco Lurtz = new Orco("Lurtz", valorVida, 10, dado);
        assertEquals(valorVida, Lurtz.getSalud());
    }

    @Test
    void setSalud() {
        int valorVida = 1500;
        Dado dado = new Dado();
        Orco Lurtz = new Orco("Lurtz", 5, 10, dado);
        Lurtz.setSalud(valorVida);
        assertEquals(valorVida, Lurtz.getSalud());
    }

    @Test
    void getArmadura() {
        int valorArmdura = 20;
        Dado dado = new Dado();
        Orco Lurtz = new Orco("Lurtz", 1500, valorArmdura, dado);
        assertEquals(valorArmdura, Lurtz.getArmadura());
    }

    @Test
    void setArmadura() {
        int valorArmdura = 20;
        Dado dado = new Dado();
        Orco Lurtz = new Orco("Lurtz", 1500, 10, dado);
        Lurtz.setArmadura(valorArmdura);
        assertEquals(valorArmdura, Lurtz.getArmadura());
    }

    @Test
    void getNombre() {
        String nombre = "Lurtz";
        Dado dado = new Dado();
        Orco Lurtz = new Orco(nombre, 1500, 10, dado);
        assertEquals(nombre, Lurtz.getNombre());
    }

    @Test
    void setNombre() {
        String nombre = "Lurtz";
        Dado dado = new Dado();
        Orco Lurtz = new Orco("Lurtz", 1500, 10, dado);
        Lurtz.setNombre(nombre);
        assertEquals(nombre, Lurtz.getNombre());
    }
}