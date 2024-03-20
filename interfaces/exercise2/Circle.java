package gr.aueb.cf.myPractice.interfaces.exercise2;

public class Circle extends AbstractShape implements ICircle{
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getDiameter() {
        return 2 * radius;
    }

    @Override
    public double getArea() {
        return Math.PI * this.radius;
    }

    @Override
    public long getCircumference() {
        return (long) (2 * Math.PI * radius);
    }
}
