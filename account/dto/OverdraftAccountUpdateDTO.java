package gr.aueb.cf.myPractice.account.dto;

public class OverdraftAccountUpdateDTO extends AccountUpdateDTO{
    double overdraftLimit;

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }
}
