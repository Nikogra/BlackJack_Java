package Model;

public class Player {
    private int saldo;
    private int handValue;
    private int aposta;
    private Hand hand;
    private Baralho baralho;

    public Player(Hand h, Baralho b,int s) {
        hand = h;
        baralho=b;
        saldo = s;
        handValue = hand.getHandValue();
    }

    public int getSaldo() {
        return saldo;
    }

    public int getHandValue() {
        return handValue;
    }

    public int getAposta() {
        return aposta;
    }

    public Hand getHand() {
        return hand;
    }

    public boolean retiraSaldo(){
        if(saldo>=aposta){
            saldo-=aposta;
            return true;
        }
        return false;
    }

    public void ganharAposta(){
        saldo+=aposta*2;
    }

    public void aposta(int bet){
        aposta=bet;
        if(retiraSaldo()){
            hand.pedeCarta();
            hand.pedeCarta();
        }

    }

    public void pedeCarta(){
        hand.pedeCarta();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(hand);
        builder.append(" "+this.getSaldo());
        return builder.toString();
    }
}
