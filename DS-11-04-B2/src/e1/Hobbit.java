package e1;

public class Hobbit extends Heroe {

    public Hobbit(String nombre, int salud, int armadura, Dado dado) {
        super(salud, armadura, nombre, dado);
    }

    @Override
    public void ataque(Personaje rival){
        if (rival instanceof Trasgo){
            int valorAtaque = Math.max(this.dado.tirarDado(100), this.dado.tirarDado(100)) - 5;
            if (rival.getArmadura() < valorAtaque){
                rival.setSalud(rival.getSalud() - (valorAtaque - rival.getArmadura()));
            }
        }else{
            super.ataque(rival);
        }
    }
}
