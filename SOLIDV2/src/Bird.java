
// 4. Interface Segregation Principle (ISP)
//Una clase no debe ser forzada a implementar interfaces que no utiliza.


public interface Bird {
    void fly();
    void eat();
}

public class Eagle implements Bird {
    public void fly() {
        System.out.println("El águila vuela alto");
    }
    public void eat() {
        System.out.println("El águila come carne");
    }
}

public class Ostrich implements Bird {
    public void eat() {
        System.out.println("El avestruz come plantas");
    }

    // El avestruz no vuela, por lo que no debería implementar fly().
    // Se debería separar la interfaz Bird en interfaces más específicas.
}
