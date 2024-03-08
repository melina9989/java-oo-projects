package gr.aueb.cf.myPractice.inheritance;

public class Point2D extends Point{
    private double y;

    public Point2D() {
//        super();
//        y = 0.0;
    }

    public Point2D(double x, double y) {
        super(x);
        //setX(x);
        this.y = y;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

//    @Override
//    public String convertToString() {
//      return super.convertToString() + "(" + y + ")";
//    }

    @Override
    public String toString() {
        return "(" + getX() + ", " + getY() +")";
    }

    @Override
    public void movePlus10() {
        super.movePlus10();
        y += 10;
    }

    @Override
    protected void movePlus1() {
        super.movePlus1();
        y += 1;
    }

    @Override
    public double getDistanceFromOrigin() {
        return Math.sqrt(super.getX() * super.getX() + y * y);
    }
}



