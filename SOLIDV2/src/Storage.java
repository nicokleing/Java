//5. Dependency Inversion Principle (DIP)
//Módulos de alto nivel no deben depender de módulos de bajo nivel.
// Ambos deben depender de abstracciones. Además, las abstracciones
// no deben depender de los detalles, sino que los detalles deben
// depender de las abstracciones.


public interface Storage {
    void save(Object data);
}

public class FileStorage implements Storage {
    public void save(Object data) {
        System.out.println("Guardando datos en un archivo");
    }
}

public class CloudStorage implements Storage {
    public void save(Object data) {
        System.out.println("Guardando datos en la nube");
    }
}

public class DataManager {
    private Storage storage;

    public DataManager(Storage storage) {
        this.storage = storage;
    }

    public void saveData(Object data) {
        storage.save(data);
    }
}

// Uso
Storage storage = new CloudStorage();
DataManager dataManager = new DataManager(storage);
dataManager.saveData("Datos importantes");
