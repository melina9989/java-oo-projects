package gr.aueb.cf.myPractice.account.model;

import gr.aueb.cf.ch15.accounts.model.User;

public abstract class AbstractEntity implements IdentifiableEntity {
    private Long id;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

