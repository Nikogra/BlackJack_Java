package Model;

public class BlackJack {
    private Baralho baralho=new Baralho();
    private Player player;

    private int getPlayerHandValue(){
        return player.getHandValue();
    }

    private int getPlayerSaldo(){
        return player.getSaldo();
    }

    private int getplayerAposta(){
        return player.getAposta();
    }

    private Hand getPlayerHand(){
        return player.getHand();
    }

    private void playerPedeCarta(){
        player.pedeCarta();
    }

    private boolean playerAposta(int val){
        player.setAposta(val);
        return player.retiraSaldo();
    }
}
