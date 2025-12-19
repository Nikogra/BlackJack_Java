package Model;

import java.util.Scanner;

public class BlackJack {
    private Baralho baralho=new Baralho();
    private Player player;
    private Dealer dealer;
    private int bet;
    //player functions
    private int getPlayerHandValue(){
        return player.getHandValue();
    }

    private int getPlayerSaldo(){
        return player.getSaldo();
    }

    private Hand getPlayerHand(){
        return player.getHand();
    }

    private void playerPedeCarta(){
        player.pedeCarta();
    }

    private boolean playerAposta(int val){
        return player.retiraSaldo(val);
    }

    private boolean playerGanha(int val){return player.poeSaldo(val);}

    private boolean playerEmpata(int val){return player.insereSaldo(val);}

    //dealer functions
    private int getDealerHandValue(){ return dealer.getHandValue();}

    private Hand getDealerHand(){ return dealer.getHand();}

    private void dealerPedeCarta(){ dealer.pedeCarta();}

    private void dealerShowCard(){ dealer.dealerMostraCard();}
    //game
    private void playersCreation(int val){
        player=new Player(baralho,val);
        dealer=new Dealer(baralho);
    }

    private void Initial_Interface(Scanner sc) {
        System.out.println("Put your Money:");
        int s = sc.nextInt();
        while (s <= 0) {
            System.out.println("Put a Valid amount of money!");
            s = sc.nextInt();
        }
        //criação jogadores
        playersCreation(s);
    }

    private boolean Bet_Interface(Scanner sc){
    //Sistema de aposta
        System.out.println("Saldo:"+getPlayerSaldo());
        System.out.println("Put your Bet:");
        this.bet = sc.nextInt();
        //playerAposta(bet);
        while(!playerAposta(bet)){
            System.out.println("You dont have this money bet again:");
            bet = sc.nextInt();
        }
        return true;
    }

    private void showHands(){
        System.out.println(player);
        System.out.println(dealer);
    }

    public BlackJack(Scanner sc) {

        System.out.println("Welcome to Black Jack!");
        Initial_Interface(sc);
        do{
            if(getPlayerSaldo()<=0){
                System.out.println("You dont have money!");
                break;
            }
            Bet_Interface(sc);
            System.out.println("Play? (Y/N)");
            String res=sc.next().toLowerCase();
            while(!(res.equals("y") || res.equals("n"))){
                System.out.println("Play? (Y/N)");
                res=sc.next().toLowerCase();
            }
            if(res.equals("y")){
                playersCreation(getPlayerSaldo());
                showHands();
                while(true){
                    String choice;
                    do {
                        System.out.println("Hit or Stop?");
                        choice = sc.next().toLowerCase();
                    } while (!choice.equals("hit") && !choice.equals("h") &&
                            !choice.equals("stop") && !choice.equals("s"));

                    if(choice.equals("hit")||choice.equals("h")){
                        playerPedeCarta();
                        showHands();
                        if(getPlayerHandValue()>21){
                            System.out.println("You lost :(!");
                            break;
                        }
                    }
                    else{
                        dealerShowCard();
                        showHands();
                        if(getDealerHandValue()<17){
                            while(getDealerHandValue()<17){
                                dealerPedeCarta();
                                showHands();
                            }
                            if(getDealerHandValue()<=21){
                                if(getDealerHandValue()<getPlayerHandValue()){
                                    if(playerGanha(bet)){
                                        System.out.println("You Win :)!");
                                    }
                                }
                                else if(getDealerHandValue()>getPlayerHandValue()){
                                    System.out.println("You Lost :(");
                                }
                                else{
                                    if(playerEmpata(bet)){
                                    System.out.println("You Tie :|");
                                    }
                                }
                            }else{
                                playerGanha(bet);
                                System.out.println("You Win :)!");
                            }
                        }
                        break;
                    }

                }
            }else{
                    System.out.println("Bye!");
                    break;
            }
        }while(getPlayerSaldo()>0);



        }
    }



