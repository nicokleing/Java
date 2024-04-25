public class Circle implements GeometricFigure{
    public Double ratio;

    public Circle(Double ratio) {
        this.ratio = ratio;
    }

    @Override
    public Double calculateArea() {
        return Math.PI * ratio * ratio;
    }
}
