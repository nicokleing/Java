public class Main {
    public static void main(String[] args) {
        ItemFactory itemFactory = ItemFactory.getInstance();

        Shop shop = new Shop();

        shop.addItem(itemFactory.createItem(1));
        shop.addItem(itemFactory.createItem(2));
        shop.addItem(itemFactory.createItem(3));

        System.out.println("El precio total de tu carrito es de " + shop.calculatePrice());
    }
}
