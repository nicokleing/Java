//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ProductTicketDataBase productTicketDataBase = new ProductTicketDataBase();

        productTicketDataBase.addProductTicket(new ProductTicket("Bananas", 10, 1.0));
        productTicketDataBase.addProductTicket(new ProductTicket("Chocolate", 1, 7.5));
        System.out.println(productTicketDataBase.calculateTotalEarnings());
    }
}