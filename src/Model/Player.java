package Model;

public class Player {
    private int saldo=0;
    private int handValue;
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
        return handValue=hand.getHandValue();
    }

    public Hand getHand() {
        return hand;
    }

    public boolean retiraSaldo(int val) {
        if(val<=saldo) {
            saldo-=val;
            return true;
        }
        return false;
    }

    public void poeSaldo(int val){
        saldo+=val*2;
    }

    public void insereSaldo(int val){
        saldo+=val;
    }

    public void pedeCarta(){
        hand.pedeCarta();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Player:"+hand);
        builder.append("\n "+"Saldo:"+this.getSaldo());
        return builder.toString();
    }
}
