//SOLID son principios de diseño orientado a objetos destinados a
// hacer que el software sea más comprensible, flexible y mantenible.
// Los principios SOLID son cinco, y aquí te daré un breve ejemplo de cada
// uno aplicado a un contexto en Java:
//
//1. Single Responsibility Principle (SRP)
//Un clase debe tener una sola razón para cambiar, lo que significa que debe tener
// solo una tarea o responsabilidad.

// Clase que solo maneja detalles del usuario
public class User {
    private String name;
    private String email;

    // Getters y setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}

// Clase dedicada exclusivamente a enviar correos
public class EmailService {
    public void sendEmail(String email, String message) {
        System.out.println("Enviando email a " + email);
        // Lógica de envío de email
    }
}
