package e1;

public class Elfo extends Heroe {

    public Elfo(String nombre, int salud, int armadura, Dado dado) {
        super(salud, armadura, nombre, dado);
    }

    @Override
    public void ataque(Personaje rival){
        if (rival instanceof Orco){
            int valorAtaque = Math.max(this.dado.tirarDado(100), this.dado.tirarDado(100)) + 10;
            if (rival.getArmadura() < valorAtaque){
                rival.setSalud(rival.getSalud() - (valorAtaque - rival.getArmadura()));
            }
        }else{
            super.ataque(rival);
        }
    }
}
