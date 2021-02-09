package e2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProyectoTest {
    @Test
    void getNombre() {
        String nombre = "nombre";
        Proyecto proyecto = new Proyecto(nombre);
        assertEquals(nombre, proyecto.getNombre());
    }

    @Test
    void setNombre() {
        String nombre = "nombre";
        Proyecto proyecto = new Proyecto(nombre);
        proyecto.setNombre("hola");
        assertEquals("hola", proyecto.getNombre());
    }

    @Test
    void coTrabajador() {
        Trabajador edu = new Trabajador("Edu", 500f, 20f);
        Trabajador david = new Trabajador("David", 180f, 10f);
        Trabajador bea = new Trabajador("Bea", 1000f, 50f);
        Trabajador laura = new Trabajador("Laura", 480f, 40f);
        Trabajador juan = new Trabajador("Juan", 900f, 60f);
        SubEquipo profe = new SubEquipo("Teaching");
        SubEquipo practica = new SubEquipo("Practicum");
        SubEquipo teoria = new SubEquipo("Theory");

        profe.addEquipo(edu);
        practica.addEquipo(juan);
        practica.addEquipo(bea);
        practica.addEquipo(laura);
        teoria.addEquipo(david);

        profe.addEquipo(teoria);
        profe.addEquipo(practica);

        Proyecto proyecto = new Proyecto("Teaching");
        proyecto.setEquipo(profe);

        List<Trabajador> trabajadores = proyecto.coTrabajador(laura);
        assertEquals(trabajadores.get(0), edu);
        assertEquals(trabajadores.get(1), david);
        assertEquals(trabajadores.get(2), juan);
        assertEquals(trabajadores.get(3), bea);

    }

}