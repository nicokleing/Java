// 4. Interface Segregation Principle (ISP)
//Dividimos las interfaces para que no tengan
// más funcionalidades de las que sus implementadores necesitan:

public interface BookManagement {
    void catalogBook(Book book);
}

public class LibraryManagement implements BookManagement, InventoryManagement {
    private List<Book> books = new ArrayList<>();

    @Override
    public void catalogBook(Book book) {
        books.add(book);
        System.out.println("Cataloged book: " + book.getTitle());
    }

    @Override
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Library added book: " + book.getTitle());
    }

    @Override
    public void removeBook(Book book) {
        books.remove(book);
        System.out.println("Library removed book: " + book.getTitle());
    }
}
