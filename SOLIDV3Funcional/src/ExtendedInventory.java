// 3. Liskov Substitution Principle (LSP)
//Seguimos con el principio de Liskov para
// garantizar que los subtipos sean sustituibles por sus tipos base:


public class ExtendedInventory extends SimpleInventory {
    @Override
    public void addBook(Book book) {
        super.addBook(book);
        System.out.println("Extended Inventory Logging: Added " + book.getTitle());
    }
}
