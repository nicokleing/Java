public class Main {
    public static void main(String[] args) {
        // Creación de una instancia de gestión de inventario
        InventoryManagement inventory = new SimpleInventory();

        // Creación de una instancia del servicio de la librería con la gestión de inventario
        LibraryService libraryService = new LibraryService(inventory);

        // Creación de un nuevo libro
        Book book1 = new Book("1984", "George Orwell", 123456);

        // Añadiendo el libro al inventario a través del servicio de la librería
        libraryService.manageNewBook(book1);
    }
}
