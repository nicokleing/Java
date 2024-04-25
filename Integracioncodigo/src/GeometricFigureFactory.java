public class GeometricFigureFactory {
    public static final String CODE_CIRCLE = "Circle";
    public static final String CODE_RECTANGLE = "Rectangle";
    public static final String CODE_SQUARE = "Square";
    public static final String CODE_TRIANGLE = "Triangle";  // Ensure this is correctly spelled and capitalized

    private static GeometricFigureFactory instance = new GeometricFigureFactory();

    public static GeometricFigureFactory getInstance() {
        return instance;
    }

    public static GeometricFigure createFigure(String codigo) throws GeometricFigureFactoryException {
        return getInstance().generateGeometricFigure(codigo);
    }

    public GeometricFigure generateGeometricFigure(String codigo) throws GeometricFigureFactoryException {
        switch (codigo) {
            case CODE_CIRCLE:
                return new Circle(2.0);
            case CODE_RECTANGLE:
                return new Rectangle(5.0, 6.0);
            case CODE_SQUARE:
                return new Rectangle(3.0, 3.0);
            case CODE_TRIANGLE:
                return new Triangle(10.0, 4.0);
            default:
                throw new GeometricFigureFactoryException(codigo + " is not a valid code");
        }
    }
}
