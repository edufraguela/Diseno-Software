package e2;

import java.util.List;
import java.util.ArrayList;

public class Proyecto {
    private String nombre;
    private Equipo equipo;

    public Proyecto(String nombre) {
        this.nombre = nombre;
    }

    public Proyecto(String nombre, Equipo equipo) {
        this.nombre = nombre;
        this.equipo = equipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public List<Trabajador> coTrabajador(Trabajador trabajador){
        List<Trabajador> trabajadores = this.equipo.listWorker(new ArrayList<>());
        trabajadores.remove(trabajador);
        return trabajadores;
    }

}
