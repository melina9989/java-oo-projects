package gr.aueb.cf.myPractice.interfaces.exercise1;

public class AbstractShape implements IShape{
    private long id;

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public long getId() {
        return this.id;
    }


}
