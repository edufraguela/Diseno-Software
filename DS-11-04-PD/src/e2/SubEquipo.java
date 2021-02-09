package e2;

import java.util.ArrayList;
import java.util.List;

public class SubEquipo implements Equipo {

    private String nombre;
    protected List<Equipo> listaEquipos = new ArrayList<>();

    public SubEquipo(String nombre) {
        this.nombre = nombre;
    }

    public List<Equipo> getListaEquipos() {
        return listaEquipos;
    }

    public void addEquipo(Equipo eq){
        listaEquipos.add(eq);
    }

    public void eliminarEquipos(Equipo eq){
        listaEquipos.remove(eq);
    }

    @Override
    public float calcularCoste() {
        int coste = 0;
        for(Equipo equipo: listaEquipos){
            coste += equipo.calcularCoste();
        }
        return coste;
    }

    @Override
    public float calcularHoras() {
        int horas = 0;
        for(Equipo equipo: listaEquipos){
            horas += equipo.calcularHoras();
        }
        return horas;
    }

    @Override
    public String imprimir() {
        StringBuilder infoEquipo = new StringBuilder("Team " + nombre + ": " + calcularHoras() + " hours, " + calcularCoste() + " €\n");
        for(Equipo equipo: listaEquipos){
            infoEquipo.append(equipo.imprimir());
        }
        return infoEquipo.toString();
    }

    @Override
    public List<Trabajador> listWorker( List<Trabajador> trabajadores){
        for(Equipo equipo: listaEquipos){
            equipo.listWorker(trabajadores);
        }
        return trabajadores;
    }
}
