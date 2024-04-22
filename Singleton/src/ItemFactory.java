public class ItemFactory {
    private static ItemFactory instance;

    private ItemFactory() {
    }

    public static ItemFactory getInstance() {
        if (instance == null) {
            instance = new ItemFactory();
        }
        return instance;
    }

    public Item createItem(Integer id) {
        switch (id) {
            case 1:
                return new Item("Hamburger", 5.0);
            case 2:
                return new Item("French Fries", 2.0);
            case 3:
                return new Item("Ice Cream", 1.5);
            default:
                return null;
        }
    }
}