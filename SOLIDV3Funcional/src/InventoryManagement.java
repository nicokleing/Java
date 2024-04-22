// 2. Open/Closed Principle (OCP)
//Creamos una interfaz para acciones relacionadas con la
// administración de inventario que puede ser extendida sin modificar la interfaz:

public interface InventoryManagement {
    void addBook(Book book);
    void removeBook(Book book);
}

public class SimpleInventory implements InventoryManagement {
    private List<Book> inventory = new ArrayList<>();

    @Override
    public void addBook(Book book) {
        inventory.add(book);
        System.out.println("Added book to inventory: " + book.getTitle());
    }

    @Override
    public void removeBook(Book book) {
        inventory.remove(book);
        System.out.println("Removed book from inventory: " + book.getTitle());
    }
}
