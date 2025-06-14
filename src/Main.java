import Model.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Baralho bar = new Baralho();
        Hand hand = new Hand(bar);
        Player p=new Player(hand,bar,1000);
        System.out.println(p);
        p.aposta(1000);
        System.out.println(p);
        p.pedeCarta();
        System.out.println(p);
    }
}