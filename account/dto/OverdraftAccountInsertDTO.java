package gr.aueb.cf.myPractice.account.dto;

public class OverdraftAccountInsertDTO extends AccountInsertDTO{
    double overdraftLimit;

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }
}
