package gr.aueb.cf.myPractice.interfaces.exercise2;

public class Rectangle extends AbstractShape implements IRectangle{
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public long getCircumference() {
        return (long) (2 * width + 2 * height);
    }
}
