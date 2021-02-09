package e1;

public class Manual implements EstadoTermostato {
    public Manual() {   }
    @Override
    public void newTemperature(Termostato termostato, float currentTemperature) {
        termostato.setEstado(Termostato.Estado.ON);
        termostato.setTempActual(currentTemperature);
        termostato.log.add(termostato.getTempActual() + " Modo Manual - Calefacción encendida.");
    }

    @Override
    public void screenInfo(Termostato termostato) {
        termostato.log.add(termostato.getTempActual() + " ON M");
    }

    @Override
    public void activateModo(Termostato termostato) {
        termostato.log.add("Se activa el modo Manual.");
    }
}
