package gr.aueb.cf.myPractice.interfaces.exercise1;

import java.io.Serializable;
import java.util.Objects;

public class Circle extends AbstractShape implements ITowDimensional, Cloneable, Serializable {
    private static final long serialVersionUID = 38439;
    private double radius;
    private transient int hashcode;

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(Circle copiedCircle) {
        this.radius = copiedCircle.radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Circle circle = (Circle) o;

        return Objects.equals(radius, circle.radius);
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius);
    }

    @Override
    protected Circle clone() throws CloneNotSupportedException {
        return (Circle) super.clone();
    }


}
