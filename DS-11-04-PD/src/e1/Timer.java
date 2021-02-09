package e1;

public class Timer implements EstadoTermostato {
    public Timer(Termostato termostato, int tiempo) {
        termostato.setTiempo(tiempo);
    }

    @Override
    public void newTemperature(Termostato termostato, float currentTemperature) {
        termostato.setEstado(Termostato.Estado.ON);
        termostato.setTempActual(currentTemperature);
        termostato.updateTiempo(-5);
        if(termostato.getTiempo() < 0) {
            termostato.log.add("Se desactiva el modo Timer.");
            termostato.log.add(termostato.getTempActual() + " Modo Off - Calefacción apagada.");
            termostato.setModo(new Off());
        } else
            termostato.log.add(termostato.getTempActual() + " Modo Timer (faltan " + termostato.getTiempo() + " minutos) - Calefacción encendida.");
    }

    @Override
    public void screenInfo(Termostato termostato) {
        if(termostato.getTiempo() > 0)
            termostato.log.add(termostato.getTempActual() + " ON T " + termostato.getTiempo());
    }

    @Override
    public void activateModo(Termostato termostato) {
        termostato.log.add("Se activa el modo Timer " + termostato.getTiempo() + " minutos.");
    }
}
