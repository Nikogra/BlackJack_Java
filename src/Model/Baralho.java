package Model;

import java.util.ArrayList;
import java.util.Random;

public class Baralho implements Constants {
    private static ArrayList<Carta> cartas = new ArrayList<>();
    public Baralho() {
        for(int i = 0; i< TIPO_CARTA; i++) {
            for(int j = 0; j< N_NAIPE; j++) {
                Carta c=new Carta(val[i],types[j],figures[i]);
                cartas.add(c);
            }
        }
    }

    public ArrayList<Carta> getCartas() {
        return cartas;
    }


    public Carta getCarta(String id) {
        for(Carta c : cartas) {
            if(c.getId().equals(id)) {
                return c;
            }
        }
        return null;
    }

    public int getNumCartas() {
        return cartas.size();
    }

    public void removeCarta(Carta carta) {
        cartas.remove(carta);
    }

    public void addCarta(Carta carta) {
        cartas.add(carta);
    }

    public static Carta getCarta(Carta c) {
        return cartas.contains(c) ? c : null;
    }

    public Carta getCarta(int pos) {
        return cartas.get(pos);
    }

    public Carta getRandomCarta() {
        Random r = new Random();
        int randomNum = r.nextInt(cartas.size());
        Carta randomCarta= getCarta(cartas.get(randomNum));
        removeCarta(randomCarta);
        return randomCarta;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for(Carta c : cartas) {
            builder.append(c.toString());
            builder.append("\n");
        }
        return builder.toString();
    }
}
