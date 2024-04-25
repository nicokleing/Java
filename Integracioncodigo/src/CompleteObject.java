import java.util.ArrayList;
import java.util.List;

public class CompleteObject {
    public List<GeometricFigure> geometricFigureList;

    public CompleteObject() {
        geometricFigureList = new ArrayList<>();
    }

    public void addGeometricFigure(String code) {
        try {
            GeometricFigure geometricFigure = GeometricFigureFactory.createFigure(code);
            if (geometricFigure == null) {
                // Handling case where no geometric figure is returned
                System.out.println("No geometric figure could be created with the provided code: " + code);
            } else {
                geometricFigureList.add(geometricFigure);
            }
        } catch (GeometricFigureFactoryException e) {
            // This assumes there's a custom exception GeometricFigureFactoryException
            System.out.println(e.getMessage());
        }
    }

    public double calculateTotalArea() {
        double totalArea = 0.0;
        for (GeometricFigure geometricFigure : geometricFigureList) {
            totalArea += geometricFigure.calculateArea();
        }
        return totalArea;
    }
}
