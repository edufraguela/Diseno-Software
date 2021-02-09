package e1;

public abstract class Bestia extends Personaje {
    public Bestia(int salud, int armadura, String nombre, Dado dado) {
        super(salud, armadura, nombre, dado);
    }
    public void ataque(Personaje rival){
        int valorAtaque = this.dado.tirarDado(90);
        if (rival.getArmadura() < valorAtaque){
            rival.setSalud(rival.getSalud() - (valorAtaque - rival.getArmadura()));
        }
    }
}
