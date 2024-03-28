package gr.aueb.cf.myPractice.interfaces.exercise1;

import java.io.Serializable;
import java.util.Objects;

public class Rectangle extends AbstractShape implements ITowDimensional, Cloneable, Serializable {
    private static final long serialVersionUID = 329832;
    private double width;
    private double height;
    private transient int hashcode;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public Rectangle(Rectangle copiedRectangle) {
        this.width = copiedRectangle.width;
        this.height = copiedRectangle.height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rectangle rectangle = (Rectangle) o;

        return Objects.equals(width, rectangle.width) && Objects.equals(height, rectangle.height);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHeight(), getWidth());
    }

    @Override
    protected Rectangle clone() throws CloneNotSupportedException {
        return (Rectangle) super.clone();
    }
}
