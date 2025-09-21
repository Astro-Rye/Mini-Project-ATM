public class Customer extends Persons{

    private int balance;
    public static final int STARTER_FUNDS = 100;

    public Customer (String firstName){
        super(firstName);
        this.balance = STARTER_FUNDS;
    }

    public Customer (String firstName, String lastName){
        super(firstName, lastName);
        this.balance = STARTER_FUNDS;
    }

    public int getBalance() { return balance;}
    public void setBalance(int balance) {this.balance = balance;}

    @Override
    public String toString(){
        String name = (getFirstName() + " " + getLastName()).trim();
        return name = " - Balance: $" + balance;
    }
}
