public class Bank {

    private static double dailyWithdrawalLimit = 1000;

    public static double getDailyWithdrawalLimit() {
        return dailyWithdrawalLimit;
    }
    public static void setDailyWithdrawalLimit(double amount) {
        if(amount < 0){
            throw new IllegalArgumentException("Limit must be non-negative");
        }
        dailyWithdrawalLimit = amount;
    }

}
