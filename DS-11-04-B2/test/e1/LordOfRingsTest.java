package e1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LordOfRingsTest {
    @Test
    void crearpersonajes(){
        LordOfRings lordOfRings = new LordOfRings();
        lordOfRings.crearPersonajes();
        assertEquals(2, lordOfRings.getBestias().size());
        assertEquals(3, lordOfRings.getHeroes().size());
    }

    @Test
    void setHeroes(){
        LordOfRings lr = new LordOfRings();
        List<Heroe> heroes = new ArrayList<>();
        heroes.add(new Hobbit("Frodo", 150, 20, new DadoTrucado(5)));
        heroes.add(new Elfo("Legolas", 150, 20, new DadoTrucado(5)));
        heroes.add(new Humano("Gandalf", 150, 20, new DadoTrucado(5)));
        lr.setHeroes(heroes);

        assertEquals(heroes, lr.getHeroes());
    }

    @Test
    void setBestias(){
        LordOfRings lr = new LordOfRings();
        List<Bestia> bestias = new ArrayList<>();
        bestias.add(new Orco("Lurtz", 150, 20, new DadoTrucado(5)));
        bestias.add(new Trasgo("Mauhur", 150, 20, new DadoTrucado(5)));
        lr.setBestias(bestias);

        assertEquals(bestias, lr.getBestias());
    }

    @Test
    void batalla() {


        LordOfRings lordOfRings = new LordOfRings();
        lordOfRings.crearPersonajes();

        StringBuilder sb = new StringBuilder();
        sb.append("\n" +
                "\n" +
                "Turno 0\n" +
                "Fight between Legolas( Energy = 150 )  and Lurtz( Energy = 150 )\n" +
                "Fight between Frodo( Energy = 150 )  and Mauhur( Energy = 150 )\n" +
                "\n" +
                "Turno 1\n" +
                "Fight between Legolas( Energy = 150 )  and Lurtz( Energy = 98 )\n" +
                "Fight between Frodo( Energy = 150 )  and Mauhur( Energy = 150 )\n" +
                "\n" +
                "Turno 2\n" +
                "Fight between Legolas( Energy = 133 )  and Lurtz( Energy = 47 )\n" +
                "Fight between Frodo( Energy = 150 )  and Mauhur( Energy = 150 )\n" +
                "\n" +
                "Turno 3\n" +
                "Fight between Legolas( Energy = 133 )  and Lurtz( Energy = 27 )\n" +
                "Fight between Frodo( Energy = 150 )  and Mauhur( Energy = 115 )\n" +
                "\n" +
                "Turno 4\n" +
                "Fight between Legolas( Energy = 130 )  and Lurtz( Energy = 27 )\n" +
                "Fight between Frodo( Energy = 114 )  and Mauhur( Energy = 105 )\n" +
                "\n" +
                "Turno 5\n" +
                "Fight between Legolas( Energy = 125 )  and Lurtz( Energy = 6 )\n" +
                "Muere Lurtz\n" +
                "Fight between Frodo( Energy = 114 )  and Mauhur( Energy = 105 )\n" +
                "\n" +
                "Turno 6\n" +
                "Fight between Legolas( Energy = 125 )  and Mauhur( Energy = 105 )\n" +
                "\n" +
                "Turno 7\n" +
                "Fight between Legolas( Energy = 125 )  and Mauhur( Energy = 105 )\n" +
                "\n" +
                "Turno 8\n" +
                "Fight between Legolas( Energy = 125 )  and Mauhur( Energy = 71 )\n" +
                "\n" +
                "Turno 9\n" +
                "Fight between Legolas( Energy = 124 )  and Mauhur( Energy = 51 )\n" +
                "\n" +
                "Turno 10\n" +
                "Fight between Legolas( Energy = 124 )  and Mauhur( Energy = 3 )\n" +
                "Muere Mauhur\n" +
                "\n" +
                "Han ganado los heroes!!");

        String batalla = lordOfRings.batalla();
        assertEquals(sb.toString(), batalla);

    }

    @Test
    void ejecutarBatalla() {
        //Este método sirve para imprimir por pantalla la batalla
        LordOfRings lr = new LordOfRings();
        lr.crearPersonajes();
        System.out.println(lr.batalla());
    }
}