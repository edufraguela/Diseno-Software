package e1;

public class Program implements EstadoTermostato {
    public Program(Termostato termostato, float tempConsigna) {
        termostato.setTempConsigna(tempConsigna);
    }
    @Override
    public void newTemperature(Termostato termostato, float currentTemperature) {
        termostato.setTempActual(currentTemperature);
        if(termostato.getTempActual() < termostato.getTempConsigna()) {
            termostato.setEstado(Termostato.Estado.ON);
            termostato.log.add(termostato.getTempActual() + " Modo Program (a " + termostato.getTempConsigna() + " grados) - Calefacción encendida.");
        } else {
            termostato.setEstado(Termostato.Estado.OFF);
            termostato.log.add(termostato.getTempActual() + " Modo Program (a " + termostato.getTempConsigna() + " grados) - Calefacción apagada.");
        }
    }

    @Override
    public void screenInfo(Termostato termostato) {
        if(termostato.getEstado() == Termostato.Estado.ON)
            termostato.log.add(termostato.getTempActual() + " ON P " + termostato.getTempConsigna());
        else
            termostato.log.add(termostato.getTempActual() + " OFF P " + termostato.getTempConsigna());
    }

    @Override
    public void activateModo(Termostato termostato) {
        termostato.log.add("Se activa el modo Program a " + termostato.getTempConsigna() + " grados.");
    }
}
