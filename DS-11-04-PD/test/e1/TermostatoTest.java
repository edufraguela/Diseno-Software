package e1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TermostatoTest {

    @Test
    void newTemperature() {
        Termostato t1 = new Termostato();
        t1.newTemperature(21);          // log[0]
        t1.setModo(new Program(t1, 20));   // log[1]
        t1.newTemperature(19.2F);       // log[2]
        assertEquals("21.0 Modo OFF - Calefacción apagada.", t1.log.get(0));
        assertEquals("19.2 Modo Program (a 20.0 grados) - Calefacción encendida.", t1.log.get(2));
        t1.setModo(new Manual());                      // log[3]
        t1.newTemperature(21.2F);       // log[4]
        assertEquals("21.2 Modo Manual - Calefacción encendida.", t1.log.get(4));
        t1.setModo(new Timer(t1, 6));           // log[5]
        t1.newTemperature(19.2F);       // log[6]
        assertEquals("19.2 Modo Timer (faltan 1 minutos) - Calefacción encendida.", t1.log.get(6));
        t1.newTemperature(19.6F);       // log[7] - log[8]
        assertEquals("Se desactiva el modo Timer.", t1.log.get(7));
        assertEquals("19.6 Modo Off - Calefacción apagada.", t1.log.get(8));

    }

    @Test
    void screenInfo() {
        Termostato t1 = new Termostato();
        t1.newTemperature(20);               // log[0]
        t1.setModo(new Off());                              // log[1]
        t1.screenInfo();                                    // log[2]
        assertEquals("20.0 OFF O", t1.log.get(2));
        t1.setModo(new Timer(t1, 16));               // log[3]
        t1.screenInfo();                                    // log[4]
        assertEquals("20.0 ON T 16", t1.log.get(4));
        t1.setModo(new Manual());                           // log[5]
        t1.screenInfo();                                    // log[6]
        assertEquals("20.0 ON M", t1.log.get(6));
        t1.setModo(new Program(t1, 20.5F));     // log[7]
        t1.newTemperature(20.2F);            // log[8]
        t1.screenInfo();                                    // log[9]
        assertEquals("20.2 ON P 20.5", t1.log.get(9));
        t1.newTemperature(21.2F);            // log[10]
        t1.screenInfo();                                    // log[11]
        assertEquals("21.2 OFF P 20.5", t1.log.get(11));

    }

    @Test
    void setModo() {
        Termostato t1 = new Termostato();
        t1.setModo(new Off());
        assertTrue(t1.getModo() instanceof Off);
        t1.setModo(new Manual());
        assertTrue(t1.getModo() instanceof Manual);
        t1.setModo(new Timer(t1, 10));
        assertTrue(t1.getModo() instanceof Timer);
        t1.setModo(new Program(t1, 20));
        assertFalse(t1.getModo() instanceof Program);
        t1.setModo(new Off());
        t1.setModo(new Program(t1, 20.2F));
        assertTrue(t1.getModo() instanceof Program);
    }
}