package e1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HumanoTest {

    @Test
    void ataque() {
        int vidaMauhur = 1500;
        int valorDadoTrucado = 92;
        Dado dado = new DadoTrucado(5);
        Humano Gandalf = new Humano("Gandalf", 1500, 10, dado);
        Trasgo Mauhur = new Trasgo("Mauhur", vidaMauhur, 10, dado);
        Gandalf.ataque(Mauhur);
        assertEquals(vidaMauhur-valorDadoTrucado+Mauhur.getArmadura(), Mauhur.getSalud());
    }

    @Test
    void getSalud() {
        int valorVida = 1500;
        Dado dado = new Dado();
        Humano Gandalf = new Humano("Gandalf", valorVida, 10, dado);
        assertEquals(valorVida, Gandalf.getSalud());
    }

    @Test
    void setSalud() {
        int valorVida = 1500;
        Dado dado = new Dado();
        Humano Gandalf = new Humano("Gandalf", 5, 10, dado);
        Gandalf.setSalud(valorVida);
        assertEquals(valorVida, Gandalf.getSalud());
    }

    @Test
    void getArmadura() {
        int valorArmadura = 20;
        Dado dado = new Dado();
        Humano Gandalf = new Humano("Gandalf", 1500, valorArmadura, dado);
        assertEquals(valorArmadura, Gandalf.getArmadura());
    }

    @Test
    void setArmadura() {
        int valorArmadura = 20;
        Dado dado = new Dado();
        Humano Gandalf = new Humano("Gandalf", 1500, 10, dado);
        Gandalf.setArmadura(valorArmadura);
        assertEquals(valorArmadura, Gandalf.getArmadura());
    }

    @Test
    void getNombre() {
        String nombre = "Gandalf";
        Dado dado = new Dado();
        Humano Gandalf = new Humano(nombre, 1500, 10, dado);
        assertEquals(nombre, Gandalf.getNombre());
    }

    @Test
    void setNombre() {
        String nombre = "Gandalf";
        Dado dado = new Dado();
        Humano Gandalf = new Humano("Gandalf", 1500, 10, dado);
        Gandalf.setNombre(nombre);
        assertEquals(nombre, Gandalf.getNombre());
    }
}