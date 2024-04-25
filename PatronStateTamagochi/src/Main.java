//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Tamagochi tamagochi = new Tamagochi("Tamagochi");

        System.out.println(tamagochi.getCurrentState());

        tamagochi.eat();

        System.out.println(tamagochi.getCurrentState());

        tamagochi.sleep();

        System.out.println(tamagochi.getCurrentState());


    }
}