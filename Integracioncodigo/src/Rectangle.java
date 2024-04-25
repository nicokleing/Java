public class Rectangle implements GeometricFigure{

    private Double base;

    private Double height;

    public Rectangle(Double base, Double height){
        this.base = base;
        this.height = height;
    }

    @Override
    public Double calculateArea(){
        return base * height;
    }

}
