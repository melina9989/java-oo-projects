package gr.aueb.cf.myPractice.hashMapAccount.model;

public abstract class AbstractEntity implements IdentifiableEntity {
    private Long id;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

