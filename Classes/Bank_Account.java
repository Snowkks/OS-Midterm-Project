package Classes;

abstract class BankAccount{

    public String name;

    private double balance;
    private String account_number;
    private Transaction[] history_list;
    private int history_count = 0;
    private static final int MAX_HISTORY_SIZE = 50;

    // This is constructor
    public BankAccount(String name, String account_number){
        this.name = name;
        this.account_number = account_number;
        this.balance = 0;
        this.history_count = 0;
        this.history_list = new Transaction[MAX_HISTORY_SIZE];
    }

    /*
      This method return the total balance of the account
     */
    public double getBalance(){
        return this.balance;
    }

    /*
      This method will take an input amount and add money to balance
     */
    public synchronized boolean deposit(double amount){
        if(amount > 0){
            this.makeTransaction("Deposit", amount, "Standard Deposit");
            updateBalance(balance + amount);
            return true;
        }
        return false;
    }

    /*
      This method will take an input amount and remove money from balance
     */
    public synchronized boolean withdraw(double amount){
        if(validateTransaction(amount)){
            this.makeTransaction("Withdraw", amount, "Standard Withdraw");
            updateBalance(balance - amount);
            return true;
        }
        return false;
    }

    /*
      This method will compare the amount of money transaction will use with balance
     */
    public boolean validateTransaction(double amount){
        if(amount <= this.balance){
            return true;
        }
        return false;
    }

    /*
      This method must be called when account need to set new balance amount
     */
    private boolean updateBalance(double amount){
        if(amount >= 0){
            this.balance = amount;
            return true;
        }
        return false;
    }

    /*
      This methode should create Transaction object and put in history_list
     */
    protected synchronized boolean makeTransaction(String type, double amount, String description){
        if(this.history_count < MAX_HISTORY_SIZE){
            Transaction new_transaction = new Transaction(java.time.LocalDate.now(), type, amount, description);
            this.history_list[this.history_count] = new_transaction;
            this.history_count++;
            return true;
        }
        return false;
    }

     /*
       Create a Deposit process
     */
    public Runnable createDepositTask(double amount, String personName) {
        return () -> {
            System.out.println("[" + personName + "] Attempting to deposit $" + amount + "...");
            this.deposit(amount);
        };
    }

     /*
       Create a Withdraw process
     */
    public Runnable createWithdrawTask(double amount, String personName) {
        return () -> {
            System.out.println("[" + personName + "] Attempting to withdraw $" + amount + "...");
            this.withdraw(amount);
        };
    }

    // Abstract Method override in all subclass
    public abstract String getAccountType();

}
