import java.util.Scanner;

public class ATMapp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // 1. Banker sets the shared daily limit
        Banker banker = new Banker("Dana");
        banker.setDailyLimit(300.00);

        // 2. build a customer from input
        System.out.println("Enter your first name: ");
        String first = input.nextLine().trim();

        System.out.println("Do you want to enter a last name (yes/no): ");
        String resp = input.nextLine().trim().toLowerCase();

        Customer customer;
        if(resp.equals("yes")){
            System.out.println("Enter your last name: ");
            String last = input.nextLine().trim();
            customer = new Customer(first, last);
        } else {
            customer = new Customer(first);
        }

        // 3 transaction object
        Transaction txn = new Transaction();

        // 4 outer loop: more transactions
        boolean more = true;
        while(more){
            // 5 inner loop: keep trying one transaction until  it succeeds
            boolean success = false;
            while(!success){
                success = txn.takeTransaction(customer, banker);
            }

            // 6 ask to do another transaction
            System.out.println("Another transaction ? (y/n): ");
            String again = input.nextLine().trim().toLowerCase();

            if(again.startsWith("y")){
                // optional: treat as a new day and let the banker set
                System.out.println("Set a new daily limit for today(y/n)");
                String newDay = input.nextLine().trim().toLowerCase();

                if(newDay.startsWith("y")){
                    System.out.println("Enter new daily limit (number: )");

                    // read as a line then parse to avoid scanner newline
                    double newLimit = Double.parseDouble(input.nextLine().trim());
                    banker.setDailyLimit(newLimit);
                    System.out.println("New daily limit set to $: " + newLimit);
                } else {
                    more = false;
                }
            }
        }
    }
}
