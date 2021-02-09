package e1;

public interface EstadoTermostato {
    void newTemperature(Termostato termostato, float currentTemperature);
    void screenInfo(Termostato termostato);
    void activateModo(Termostato termostato);
}
