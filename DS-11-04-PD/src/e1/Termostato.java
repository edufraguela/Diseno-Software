package e1;

import java.util.ArrayList;
import java.util.List;

public class Termostato {

    public enum Estado {OFF, ON}
    private Estado estado = Estado.OFF;
    private EstadoTermostato modo = new Off();
    public List<String> log = new ArrayList<>();
    private int tiempo;
    private float tempActual, tempConsigna;

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Estado getEstado() {
        return this.estado;
    }

    public void setTiempo(int t) {
        this.tiempo = t;
    }

    public void updateTiempo(int t) {
        this.tiempo += t;
    }

    public int getTiempo() {
        return this.tiempo;
    }

    public void setTempActual(float t) {
        this.tempActual = t;
    }

    public float getTempActual() {
        return this.tempActual;
    }

    public void setTempConsigna(float t) {
        this.tempConsigna = t;
    }

    public float getTempConsigna() {
        return this.tempConsigna;
    }

    public void newTemperature(float currentTemperature) {
        modo.newTemperature(this, currentTemperature);
    }

    public void screenInfo() {
        modo.screenInfo(this);
    }

    public EstadoTermostato getModo() {
        return this.modo;
    }

    public void setModo(EstadoTermostato modo) {
        if(!((this.modo instanceof Timer && modo instanceof Program) || (this.modo instanceof Program && modo instanceof Timer)))
            this.modo = modo;
        this.modo.activateModo(this);
    }
}
