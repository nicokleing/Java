// 5. Dependency Inversion Principle (DIP)
//Finalmente, aseguramos que las dependencias
// altas no dependan de las bajas, sino de abstracciones:

public class LibraryService {
    private InventoryManagement inventory;

    public LibraryService(InventoryManagement inventory) {
        this.inventory = inventory;
    }

    public void manageNewBook(Book book) {
        inventory.addBook(book);
    }
}

public class Main {
    public static void main(String[] args) {
        InventoryManagement inventory = new SimpleInventory();
        LibraryService libraryService = new LibraryService(inventory);
        Book book1 = new Book("1984", "George Orwell", 123456);
        libraryService.manageNewBook(book1);
    }
}


//En este diseño:
//
//SRP: Cada clase tiene una responsabilidad única.
//OCP: InventoryManagement permite nuevas formas de gestión de inventario sin modificar código existente.
//LSP: ExtendedInventory puede ser usado en lugar de SimpleInventory sin afectar el resultado.
//ISP: Las interfaces están segregadas de acuerdo a sus funciones específicas.
//DIP: LibraryService depende de la abstracción InventoryManagement y no de su implementación.
//Este ejemplo abarca la aplicación de los principios SOLID de forma coherente en un sistema simple, haciendo que el código sea más robusto, mantenible y escalable.