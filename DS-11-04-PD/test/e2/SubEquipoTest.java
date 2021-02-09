package e2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubEquipoTest {

    private Equipo generarEquipo(){
        Equipo edu = new Trabajador("Edu", 500f, 20f);
        Equipo fer = new Trabajador("Fer", 500f, 20f);
        Equipo bea = new Trabajador("Bea", 900f, 10f);
        Equipo lucia = new Trabajador("Lucía", 400f, 40f);
        Equipo juan = new Trabajador("Juan", 300f, 30f);
        SubEquipo profe = new SubEquipo("Teaching");
        SubEquipo alumno = new SubEquipo("Practicum");
        SubEquipo teoria = new SubEquipo("Theory");

        profe.addEquipo(bea);
        alumno.addEquipo(edu);
        alumno.addEquipo(fer);
        teoria.addEquipo(lucia);
        teoria.addEquipo(juan);

        alumno.addEquipo(teoria);
        profe.addEquipo(alumno);
        return profe;
    }

    @Test
    void addEquipo() {
        Equipo edu = new Trabajador("Edu", 500f, 20f);
        SubEquipo alumno = new SubEquipo("Student");

        alumno.addEquipo(edu);
        assertEquals(alumno.getListaEquipos().get(0), edu);
    }

    @Test
    void eliminarEquipos() {
        Equipo edu = new Trabajador("Edu", 500f, 20f);
        SubEquipo alumno = new SubEquipo("Student");

        alumno.addEquipo(edu);
        alumno.eliminarEquipos(edu);
        assertEquals(alumno.getListaEquipos().size(), 0);
    }

    @Test
    void calcularCoste() {
        Equipo profe = this.generarEquipo();
        assertEquals(profe.calcularCoste(), 2600f);
    }

    @Test
    void calcularHoras() {
        Equipo profe = this.generarEquipo();
        assertEquals(profe.calcularHoras(), 120f);
    }

    @Test
    void imprimir() {
        String info = "Team " + generarEquipo() +"180.0  hours , 3060.0eWorker  Edu: 20.0  hours , 500.0eTeam  Theory: 10.0  hours , 180.0eWorker  David: 10.0  hours , 180.0eTeam  Practicum: 150.0  hours , 2380.0eWorker  Juan: 60.0  hours , 900.0eWorker  Bea: 50.0  hours , 1000.0eWorker  Laura: 40.0  hours , 480.0e";
    }
}