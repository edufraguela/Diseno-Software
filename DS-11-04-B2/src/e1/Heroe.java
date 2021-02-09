package e1;

public abstract class Heroe extends Personaje {
    public Heroe(int salud, int armadura, String nombre, Dado dado) {
        super(salud, armadura, nombre, dado);
    }
    public void ataque(Personaje rival){
        int valorAtaque = Math.max(this.dado.tirarDado(100), this.dado.tirarDado(100));
        if (rival.getArmadura() < valorAtaque){
            rival.setSalud(rival.getSalud() - (valorAtaque - rival.getArmadura()));
        }
    }
}
