package e1;

import java.util.Random;

public class DadoTrucado extends Dado{
    public DadoTrucado(int semilla) {
        this.aletorio = new Random(semilla);
    }

}
