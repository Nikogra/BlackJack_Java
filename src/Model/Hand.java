package Model;

import java.util.ArrayList;

public class Hand {
    private Baralho baralho;
    private  ArrayList<Carta> hand= new ArrayList<>();
    private int handValue=0;

    public Hand(Baralho bar) {
        this.baralho=bar;
        hand.add(baralho.getRandomCarta());
        hand.add(baralho.getRandomCarta());
        calcularHandValue();
    }

    public ArrayList<Carta> getHand() {
        return hand;
    }

    public Carta getCarta(int index) {
        return hand.get(index);
    }

    public int getCartaValue(int index){
        return getCarta(index).getVal();
        }


    public int getHandValue() {
        return handValue;
    }

    private int calcularHandValue() {
        handValue = 0;
        for(Carta carta : hand) {
            handValue += carta.getVal();
        }
        return handValue;
    }

    public boolean containsAs() {
        for(Carta c : hand) {
            if(c.getFigura() == FIGURE.AS) {
                return true;
            }
        }
        return false;
    }

    public void pedeCarta(){
        hand.add(baralho.getRandomCarta());
        if(getHandValue()>21 && containsAs() ){
            for(Carta c : hand) {
                if(c.getFigura()==FIGURE.AS) {
                    c.alteraValores();
                }
            }
        }

        calcularHandValue();
    }

    public void poeCarta(String s){
        hand.add(baralho.getCarta(s));
    }

    public void resetaHand(){
        for(Carta c : hand) {
            baralho.addCarta(c);
        }
        hand.clear();
        hand.add(baralho.getRandomCarta());
        hand.add(baralho.getRandomCarta());
        calcularHandValue();
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for(Carta carta : hand) {
            builder.append(carta.toString());
            builder.append(" ");
        }
            builder.append("("+handValue+")");
        return builder.toString();
    }
}
