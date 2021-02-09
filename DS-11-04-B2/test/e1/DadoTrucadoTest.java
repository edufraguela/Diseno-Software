package e1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DadoTrucadoTest {

    @Test
    void tirarDado() {
        int semilla = 5;
        int resultadoEsperado = 87;
        DadoTrucado dadoTrucado = new DadoTrucado(semilla);
        assertEquals(resultadoEsperado, dadoTrucado.tirarDado(100));
    }
}