package gr.aueb.cf.myPractice.account.model;

import gr.aueb.cf.myPractice.account.model.IdentifiableEntity;

public class User extends AbstractEntity {

    private String firstname;
    private String lastname;
    private String ssn;

    public User() {
    }

    public User(Long id, String firstname, String lastname, String ssn) {
        setId(id);
        this.firstname = firstname;
        this.lastname = lastname;
        this.ssn = ssn;
    }

    /* Copy Constructor */
    public User(User user) {
        firstname = user.getFirstname();
        lastname = user.getLastname();
        ssn = user.getSsn();
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", ssn='" + ssn + '\'' +
                '}';
    }

}
