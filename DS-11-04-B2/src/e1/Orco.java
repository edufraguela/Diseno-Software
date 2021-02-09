package e1;

public class Orco extends Bestia {
    public Orco(String nombre, int salud, int armadura, Dado dado) {
        super(salud, armadura, nombre, dado);
    }
    @Override
    public void ataque(Personaje rival){
        int valorAtaque = this.dado.tirarDado(90);
        int valorArmaduraRival = (int) Math.round(rival.getArmadura()*0.9);
        if (valorArmaduraRival < valorAtaque){
            rival.setSalud(rival.getSalud() - (valorAtaque - valorArmaduraRival));
        }
    }
}
