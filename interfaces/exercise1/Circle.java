package gr.aueb.cf.myPractice.interfaces.exercise1;

public class Circle extends AbstractShape implements ITowDimensional{
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius;
    }
}
