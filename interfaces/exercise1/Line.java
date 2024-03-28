package gr.aueb.cf.myPractice.interfaces.exercise1;

import java.io.Serializable;
import java.util.Objects;

public class Line extends AbstractShape implements Cloneable, Serializable {
    private static final long serialVersionUID = 123;
    private double length;
    private transient int hashcode;

    public Line(double length) {
        this.length = length;
    }

    public Line(Line copiedLine) {
        this.length = copiedLine.length;
    }

    @Override
    public String toString() {
        return "Line{" +
                "length=" + length +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Line line = (Line) o;

        return Objects.equals(length, line.length);
    }

    @Override
    public int hashCode() {
        return Objects.hash(length);
    }

    @Override
    protected Line clone() throws CloneNotSupportedException {
        return (Line) super.clone();
    }
}
