package gr.aueb.cf.myPractice.interfaces.exercise2;

public class AbstractShape implements IShape{
    private long id;
    @Override
    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
