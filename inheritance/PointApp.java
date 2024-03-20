package gr.aueb.cf.myPractice.inheritance;

/**
 *  The class {@link PointApp} This class tests the
 *  functionality of classes :
 *  {@link Point} ,
 *  {@link Point2D} ,
 *  {@link Point3D} and
 *  the utility class {@link PointUtil}.
 *
 */
public class PointApp {
    public static void main(String[] args) {
        Point p = new Point();
        Point p2 = new Point2D();
        Point3D p3 = new Point3D();

        p2.movePlus1();

        p3.movePlus10();

        ((Point2D)p2).setY(5);

        System.out.println(p3);

        doMovePlus10(p);
        doMovePlus10(p2);
        doMovePlus10(p3);

        doPrint(p);
        System.out.println(p.getDistanceFromOrigin());
        doPrint(p2);
        System.out.println(p2.getDistanceFromOrigin());
        doPrint(p3);
        System.out.println(p3.getDistanceFromOrigin());
        PointUtil.distanceFromOrigin(p3);
        p3.printTypeOf();
    }


    public static void doMovePlus10(Point point) {
        point.movePlus10();
    }

    public static void doPrint(Point point) {
        System.out.println(point);
    }
}
