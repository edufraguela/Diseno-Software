package e1;
import java.util.Random;

public class Dado{

    Random aletorio;

    public Dado(){
        this.aletorio = new Random();
    }

    public int tirarDado(int maximoValor){
        return this.aletorio.nextInt(maximoValor);
    }
}
