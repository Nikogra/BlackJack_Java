package Model;

public class Dealer {
    private int handValue;
    private Baralho baralho;
    private Hand hand;
    private boolean firstcard=true;

    public Dealer( Baralho b) {
        baralho=b;
        hand = new Hand(baralho);
    }
    public int getHandValue() {
        return handValue=hand.getHandValue();
    }

    public void pedeCarta(){
        hand.pedeCarta();
        if(firstcard){
            firstcard=false;
        }
    }

    public Hand getHand() {
        return hand;
    }

    public void dealerMostraCard(){
        firstcard=false;
    }

    public void resetaHand(){hand.resetaHand();}
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Dealer:");
        if(firstcard){
            builder.append(hand.getCarta(0));
            builder.append(" ");
            builder.append("("+hand.getCartaValue(0)+")");
        }
        else{
            builder.append(hand);
        }
        return builder.toString();
    }
}
