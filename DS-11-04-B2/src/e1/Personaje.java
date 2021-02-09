package e1;
import java.util.Random;

public abstract class Personaje {
    public int salud, armadura;
    public String nombre;
    Dado dado;

    public Personaje(int salud, int armadura, String nombre, Dado dado) {
        this.salud = salud;
        this.armadura = armadura;
        this.nombre = nombre;
        this.dado = dado;
    }

    //setter and getter
    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public int getArmadura() {
        return armadura;
    }

    public void setArmadura(int armadura) {
        this.armadura = armadura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
