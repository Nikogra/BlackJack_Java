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

    private void playerGanha(int val){player.poeSaldo(val);}


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
    private boolean Initial_Interface(){
        System.out.println("Put your Money:");
        Scanner sc=new Scanner(System.in);
        int s=sc.nextInt();
        while(s<=0){
            System.out.println("Put a Valid amount of money!");
            s=sc.nextInt();
        }
        //criação jogadores
        playersCreation(s);
        //Sistema de aposta
        System.out.println("Saldo:"+getPlayerSaldo());
        System.out.println("Put your Bet:");
        bet = sc.nextInt();
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

    public BlackJack(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome to Black Jack!");
        Initial_Interface();
        do{
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
                                if(getDealerHandValue()<getPlayerHandValue()||getPlayerHandValue()==21){
                                    System.out.println("You Win :)!");
                                    playerGanha(bet);
                                }
                                if(getDealerHandValue()>getPlayerHandValue()){
                                    System.out.println("You Lost :(");
                                }
                                else{
                                    System.out.println("You Tie :|");
                                }
                            }else{
                                System.out.println("You Win :)!");
                                playerGanha(bet);
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



