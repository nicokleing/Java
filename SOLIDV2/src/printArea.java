// 3. Liskov Substitution Principle (LSP)
//Los objetos de una clase base deben
// ser reemplazables con objetos de sus clases derivadas
// sin afectar la correcta ejecución del programa.

public void printArea(Shape shape) {
    System.out.println("Área: " + shape.calculateArea());
}

// Ahora se puede pasar cualquier subclase de Shape sin afectar el comportamiento de printArea()
Shape circle = new Circle(5);
Shape square = new Square(4);

printArea(circle); // Correcto
printArea(square); // Correcto
