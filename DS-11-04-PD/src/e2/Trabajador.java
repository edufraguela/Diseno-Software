package e2;

import java.util.List;

public class Trabajador implements Equipo {

    private String nombre;
    private float coste;
    private float horas;

    public Trabajador(String nombre, float coste, float horas) {
        this.nombre = nombre;
        this.coste = coste;
        this.horas = horas;
    }


    @Override
    public float calcularCoste() {
        return this.coste;
    }

    @Override
    public float calcularHoras() {
        return this.horas;
    }

    @Override
    public String imprimir() {
        return "Worker " + this.nombre + ": " + this.horas + " hours, " + this.coste + " €\n";
    }

    @Override
    public List<Trabajador> listWorker(List<Trabajador> trabajadores){
        trabajadores.add(this);
        return trabajadores;
    }
}
