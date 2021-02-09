package e1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElfoTest {

    @Test
    void ataqueNormal() {
        int vidaMauhur = 1500;
        int valorDadoTrucado = 92;
        Dado dado = new DadoTrucado(5);
        Elfo Legolas = new Elfo("Legolas", 1500, 10,  dado);
        Trasgo Mauhur = new Trasgo("Mauhur", vidaMauhur, 10, dado);
        Legolas.ataque(Mauhur);
        assertEquals(vidaMauhur-valorDadoTrucado+Mauhur.getArmadura(), Mauhur.getSalud());
    }

    @Test
    void ataqueOrco() {
        int vidaLurtz = 1500;
        int valorDadoTrucado = 92;
        int valorExtraOrco = 10;
        Dado dado = new DadoTrucado(5);
        Elfo Legolas = new Elfo("Legolas", 1500, 10, dado);
        Orco Lurtz = new Orco("Lurtz", vidaLurtz, 10, dado);
        Legolas.ataque(Lurtz);
        assertEquals(vidaLurtz-valorDadoTrucado-valorExtraOrco+Lurtz.getArmadura(), Lurtz.getSalud());
    }

    @Test
    void getSalud() {
        int valorVida = 1500;
        Dado dado = new Dado();
        Elfo Legolas = new Elfo("Legolas", valorVida, 10, dado);
        assertEquals(valorVida, Legolas.getSalud());
    }

    @Test
    void setSalud() {
        int valorVida = 1500;
        Dado dado = new Dado();
        Elfo Legolas = new Elfo("GatitoTrishte", 5, 10, dado);
        Legolas.setSalud(valorVida);
        assertEquals(valorVida, Legolas.getSalud());
    }

    @Test
    void getArmadura() {
        int valorArmdura = 20;
        Dado dado = new Dado();
        Elfo Legolas = new Elfo("Legolas", 1500, valorArmdura, dado);
        assertEquals(valorArmdura, Legolas.getArmadura());
    }

    @Test
    void setArmadura() {
        int valorArmdura = 20;
        Dado dado = new Dado();
        Elfo Legolas = new Elfo("Legolas", 1500, 10, dado);
        Legolas.setArmadura(valorArmdura);
        assertEquals(valorArmdura, Legolas.getArmadura());
    }

    @Test
    void getNombre() {
        String nombre = "Legolas";
        Dado dado = new Dado();
        Elfo Legolas = new Elfo(nombre, 1500, 10, dado);
        assertEquals(nombre, Legolas.getNombre());
    }

    @Test
    void setNombre() {
        String nombre = "Legolas";
        Dado dado = new Dado();
        Elfo Legolas = new Elfo(nombre, 1500, 10, dado);
        Legolas.setNombre(nombre);
        assertEquals(nombre, Legolas.getNombre());
    }

}