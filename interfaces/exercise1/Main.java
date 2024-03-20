package gr.aueb.cf.myPractice.interfaces.exercise1;

public class Main {
    public static void main(String[] args) {
        AbstractShape circle = new Circle(5);
        AbstractShape line = new Line();
        AbstractShape rectangle = new Rectangle(4, 7);
        Rectangle rectangle1 = new Rectangle(7, 9);
        Circle circle1 = new Circle(5);

        circle.setId(2453);
        line.setId(4554);
        rectangle.setId(3476);

        printId(circle);
        printId(line);
        printId(rectangle);


        System.out.println(rectangle1.getArea());
        System.out.println(circle1.getArea());




    }

    public static void printId(AbstractShape shape) {
        System.out.println(shape.getId());
    }

}
