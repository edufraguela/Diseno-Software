package e1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LordOfRings {

    private List<Heroe> heroes = new ArrayList<>();
    private List<Bestia> bestias = new ArrayList<>();


    public List<Heroe> getHeroes() {
        return heroes;
    }

    public void setHeroes(List<Heroe> heroes) {
        this.heroes = heroes;
    }

    public List<Bestia> getBestias() {
        return bestias;
    }

    public void setBestias(List<Bestia> bestias) {
        this.bestias = bestias;
    }

    public void crearPersonajes(){
        Dado dado = new DadoTrucado(5);

        Heroe Legolas = new Elfo("Legolas", 150, 50, dado);
        Heroe Frodo = new Hobbit("Frodo", 150, 50, dado);
        Heroe Gandalf = new Humano("Gandalf", 150, 50, dado);
        Bestia Lurtz = new Orco("Lurtz", 150, 50,dado);
        Bestia Mauhur = new Trasgo("Mauhur", 150, 50, dado);

        heroes.add(Legolas);
        heroes.add(Frodo);
        heroes.add(Gandalf);
        bestias.add(Lurtz);
        bestias.add(Mauhur);
    }

    public String batalla(){
        int turno = 0;
        StringBuilder st = new StringBuilder();
        while (heroes.size()>0 && bestias.size()>0){
            st.append("\n\nTurno ").append(turno);
            for(int i = 0; i < Math.min(heroes.size(), bestias.size()); i++){
                Heroe heroe = heroes.get(i);
                Bestia bestia = bestias.get(i);

                st.append("\nFight between ").append(heroe.getNombre()).append("( Energy = ").append(heroe.getSalud()).
                        append(" )  and ").append(bestia.getNombre()).append("( Energy = ").append(bestia.getSalud()).
                        append(" )");
                heroe.ataque(bestia);
                bestia.ataque(heroe);
                if (heroe.getSalud() < 1){
                    st.append("\nMuere ").append(heroe.getNombre());
                }
                if (bestia.getSalud() < 1){
                    st.append("\nMuere ").append(bestia.getNombre());
                }
            }

            for(int i = 0; i < Math.min(heroes.size(), bestias.size()); i++){
                Personaje heroe = heroes.get(i);
                Personaje bestia = bestias.get(i);
                if (heroe.getSalud() < 1){
                    heroes.remove(heroe);
                }
                if (bestia.getSalud() < 1){
                    bestias.remove(bestia);
                }
            }

            if (heroes.size()>0 && bestias.size()==0){
                st.append("\n\nHan ganado los heroes!!");
            }
            if (heroes.size()==0 && bestias.size()>0){
                st.append("\n\nHan ganado las bestias!!");
            }

            turno++;


        }
        return st.toString();
    }
}
