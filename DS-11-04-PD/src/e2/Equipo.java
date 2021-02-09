package e2;

import java.util.List;

public interface Equipo {

    float calcularCoste();
    float calcularHoras();
    String imprimir();

    List<Trabajador> listWorker(List<Trabajador> trabajadores);
}
