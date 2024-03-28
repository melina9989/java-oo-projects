package gr.aueb.cf.myPractice.interfaces.exercise1;

import java.io.*;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        AbstractShape circle = new Circle(5);
        AbstractShape line = new Line(5.6);
        Line line1 = new Line(5.6);
        Line copiedLine = new Line(line1);
        AbstractShape rectangle = new Rectangle(7, 9);
        Rectangle rectangle1 = new Rectangle(7, 8);
        Rectangle copiedRectangle = new Rectangle(rectangle1);
        Circle circle1 = new Circle(5);
        Circle copiedCircle = new Circle(circle1);

        Line line2 = line1.clone();

        System.out.println(line2);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:/tmp/line2.ser"))) {
            oos.writeObject(line2);
            System.out.println("Serialized");
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NotSerializableException e1) {
            System.out.println("Not Serializable");
        } catch (IOException e2) {
            System.out.println(e2.getMessage());
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:/tmp/rectangle1.ser"))) {
            oos.writeObject(rectangle1);
            System.out.println("Serialized");
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NotSerializableException e1) {
            System.out.println("Not Serializable");
        } catch (IOException e2) {
            System.out.println(e2.getMessage());
        }



        System.out.println(copiedLine);
        System.out.println(copiedCircle);
        System.out.println(copiedRectangle);

        circle.setId(2453);
        line.setId(4554);
        rectangle.setId(3476);

        printId(circle);
        printId(line);
        printId(rectangle);


        System.out.println(rectangle1.getArea());
        System.out.println(circle1.getArea());

        System.out.println("line equals line1: " + line.equals(line1));
        System.out.println("rectangle equals rectangle1: " + rectangle.equals(rectangle1));
        System.out.println("circle equals circle1: " + circle.equals(circle1));
        System.out.println("hashCode rectangle: " + rectangle.hashCode());
        System.out.println("hashCode rectangle1: " + rectangle1.hashCode());





    }

    public static void printId(AbstractShape shape) {
        System.out.println(shape.getId());
    }

}
