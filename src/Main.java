import Model.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Baralho baralho=new Baralho();
        Hand cassino=new Hand(baralho),apostador=new Hand(baralho);
        System.out.println(cassino);
        System.out.println(apostador);
        apostador.pedeCarta();
        System.out.println(cassino);
        System.out.println(apostador);
    }
}