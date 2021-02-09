package e1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HobbitTest {

    @Test
    void ataqueNormal() {
        int vidaLurtz = 1500;
        int valorDadoTrucado = 92;
        Dado dado = new DadoTrucado(5);
        Hobbit Frodo = new Hobbit("Legolas", 1500, 10, dado);
        Orco Lurtz = new Orco("Lurtz", vidaLurtz, 10, dado);
        Frodo.ataque(Lurtz);
        assertEquals(vidaLurtz-valorDadoTrucado+Lurtz.getArmadura(), Lurtz.getSalud());
    }

    @Test
    void ataqueTrasgo() {
        int vidaMauhur = 1500;
        int valorDadoTrucado = 92;
        int valorExtraTrasgo = 5;
        Dado dado = new DadoTrucado(5);
        Hobbit Frodo = new Hobbit("Legolas", 1500, 10, dado);
        Trasgo Mauhur = new Trasgo("Mauhur", vidaMauhur, 10, dado);
        Frodo.ataque(Mauhur);
        assertEquals(vidaMauhur-valorDadoTrucado+valorExtraTrasgo+Mauhur.getArmadura(), Mauhur.getSalud());
    }

    @Test
    void getSalud() {
        int valorVida = 1500;
        Dado dado = new Dado();
        Hobbit Frodo = new Hobbit("Frodo", valorVida, 10, dado);
        assertEquals(valorVida, Frodo.getSalud());
    }

    @Test
    void setSalud() {
        int valorVida = 1500;
        Dado dado = new Dado();
        Hobbit Frodo = new Hobbit("Frodo", 5, 10, dado);
        Frodo.setSalud(valorVida);
        assertEquals(valorVida, Frodo.getSalud());
    }

    @Test
    void getArmadura() {
        int valorArmdura = 20;
        Dado dado = new Dado();
        Hobbit Frodo = new Hobbit("Frodo", 1500, valorArmdura, dado);
        assertEquals(valorArmdura, Frodo.getArmadura());
    }

    @Test
    void setArmadura() {
        int valorArmdura = 20;
        Dado dado = new Dado();
        Hobbit Frodo = new Hobbit("Frodo", 1500, 10, dado);
        Frodo.setArmadura(valorArmdura);
        assertEquals(valorArmdura, Frodo.getArmadura());
    }

    @Test
    void getNombre() {
        String nombre = "Frodo";
        Dado dado = new Dado();
        Hobbit Frodo = new Hobbit(nombre, 1500, 10, dado);
        assertEquals(nombre, Frodo.getNombre());
    }

    @Test
    void setNombre() {
        String nombre = "Frodo";
        Dado dado = new Dado();
        Hobbit Frodo = new Hobbit("Frodo", 1500, 10, dado);
        Frodo.setNombre(nombre);
        assertEquals(nombre, Frodo.getNombre());
    }
}