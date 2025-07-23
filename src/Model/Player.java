package Model;

public class Player {
    private int saldo;
    private int handValue;
    private int aposta;
    private Baralho baralho;
    private Hand hand;

    public Player( Baralho b,int s) {
        baralho=b;
        saldo = s;
        hand = new Hand(baralho);
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

    public void setAposta(int a) {
        aposta=a;
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
