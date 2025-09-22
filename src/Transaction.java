public class Transaction {
    private static final int WITHDRAW_FEE = 2;
    private final java.util.Scanner scanner = new java.util.Scanner(System.in);

    public boolean takeTransaction(Customer customer, Banker banker){
        System.out.println("Would you like to (w)ithdraw or (d)eposit? ");
        String choice = scanner.nextLine().trim().toLowerCase();

        if(choice.startsWith("d")) {
            System.out.println("Deposit amount: ");
            int amount = readPositiveInt();
            customer.setBalance(customer.getBalance() + amount);
            System.out.println("Deposited. " + customer.toString());
            return true;
        } else if (choice.startsWith("w")){
            System.out.println("Withdraw amount: ");
            int amount = readPositiveInt();

            // check shared daily limit from Bank(cast to int since balance/amount are int)
            int limit = (int) Bank.getDailyWithdrawalLimit();
            if(amount > limit ){
                System.out.println("Amount exceeds today's limit of " + limit);
                return false;
            }
            // ensure enough funds for amount + fee
            int total = amount + WITHDRAW_FEE;
            if(total > customer.getBalance()){
                System.out.println("Insufficient funds for $ " + amount);
                return false;
            }
            // apply withdrawal
            customer.setBalance(customer.getBalance() - total);
            System.out.println("Withdrawn (fee $ " + WITHDRAW_FEE + "). " + customer.toString());
            return true;
        } else {
            System.out.println("Invalid choice. Please enter 'w' or 'd' ." + customer.toString());
            return false;
        }
    }

    private int readPositiveInt(){
        while(true){
            if(scanner.hasNextInt()){
                int amt = scanner.nextInt();
                scanner.nextLine(); // clear leftover newline
                if(amt > 0) return amt;
                System.out.println("Amount must be > 0. try again!");
            } else {
                scanner.nextLine(); // discard bad token
                System.out.println("Please enter a whole number: ");
            }
        }
    }
}
