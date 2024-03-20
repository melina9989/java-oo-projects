package gr.aueb.cf.myPractice.interfaces.exercise2;

public class Main {
    public static void main(String[] args) {
        AbstractShape rectangle = new Rectangle(4.5, 6.9);
        AbstractShape circle = new Circle(7.9);
        Circle circle1 = new Circle(6.8);

        System.out.println(circle1.getArea());

    }




}

