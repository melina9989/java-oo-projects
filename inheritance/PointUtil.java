package gr.aueb.cf.myPractice.inheritance;

/**
 * This utility class consists of a polymorphic
 * method whits returns the distance of any Point({@link Point},
 * {@link Point3D} and {@link Point3D}) from Origin.
 *
 */
public class PointUtil {
    private PointUtil() {
    }

    public static double distanceFromOrigin(Point point) {
        return  point.getDistanceFromOrigin();
    }
}
