package e1;

public class Off implements EstadoTermostato {
    public Off() {  }
    @Override
    public void newTemperature(Termostato termostato, float currentTemperature) {
        termostato.setEstado(Termostato.Estado.OFF);
        termostato.setTempActual(currentTemperature);
        termostato.log.add(termostato.getTempActual() + " Modo OFF - Calefacción apagada.");
    }

    @Override
    public void screenInfo(Termostato termostato) {
        termostato.log.add(termostato.getTempActual() + " OFF O");
    }

    @Override
    public void activateModo(Termostato termostato) {
        termostato.log.add("Se activa el modo Off.");
    }
}
