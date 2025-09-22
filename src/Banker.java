public class Banker extends Persons {

    public Banker(String firstName) {
        super(firstName);
    }

    public Banker(String firstName, String lastName) {
        super(firstName, lastName);
    }
    // the spec:
    public void setDailyLimit(double amt){
        Bank.setDailyWithdrawalLimit(amt);
    }
}
