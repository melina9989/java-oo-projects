package gr.aueb.cf.myPractice.interfaces.exercise1;

public class Rectangle extends AbstractShape implements ITowDimensional {
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
}
