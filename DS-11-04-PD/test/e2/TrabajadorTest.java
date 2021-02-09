package e2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrabajadorTest {

    @Test
    void calcularCoste() {
        Equipo trabajador = new Trabajador("Edu", 900f, 3f);
        assertEquals(trabajador.calcularCoste(), 900f);
    }

    @Test
    void calcularHoras() {
        Equipo trabajador = new Trabajador("Edu", 900f, 3f);
        assertEquals(trabajador.calcularHoras(), 3f);
    }

    @Test
    void imprimir() {
        Equipo trabajador = new Trabajador("Edu", 900f, 3f);
        String info = "Worker Edu: " + 3f + " hours, " + 900f + " €\n";
        assertEquals(trabajador.imprimir(), info);
    }
}