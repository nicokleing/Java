import java.util.ArrayList;
import java.util.List;

public class GeometricFigureComposite implements GeometricFigure{

    private List<GeometricFigure> figuresList;

    public GeometricFigureComposite() {
        figuresList = new ArrayList<>();
    }

    public void addGeometricFigure(GeometricFigure geometricFigure){
        figuresList.add(geometricFigure);
    }

    @Override
    public Double calculateArea() {
        Double finalArea = 0.0;
        for (GeometricFigure geometricFigure : figuresList) {
            finalArea += geometricFigure.calculateArea();
        }

        return finalArea;
    }

}
