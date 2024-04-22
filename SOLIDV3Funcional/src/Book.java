// 1. Single Responsibility Principle (SRP)
//Empezaremos definiendo clases que tienen una única responsabilidad:


// Clase que solo maneja detalles del libro
public class Book {
    private String title;
    private String author;
    private int isbn;

    public Book(String title, String author, int isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getIsbn() {
        return isbn;
    }
}

// Clase dedicada exclusivamente a la logística del alquiler de libros
public class RentalService {
    public void rentBook(Book book, User user) {
        System.out.println("Renting out book: " + book.getTitle() + " to " + user.getName());
        // Implementar lógica de alquiler aquí
    }
}
