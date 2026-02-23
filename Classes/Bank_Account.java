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
      getBalance()
      This method return the total balance of the account
     */
    public double getBalance(){
        return this.balance;
    }

    /*
      deposit(double amount)
      This method will take an input amount and add money to balance
      This method must return true or false
           - true is for success
           - false is for failed
     */
    public synchronized boolean deposit(double amount){
        if(amount > 0){
            this.makeTransaction("Deposit", amount, "Standard Deposit");
            this.balance += amount;
            return true;
        }
        return false;
    }

    /*
      withdraw(double amount)
      This method will take an input amount and remove money from balance
      This method must return true or false
           - true is for success
           - false is for failed
     */
    public synchronized boolean withdraw(double amount){
        if(validateTransaction(amount)){
            this.makeTransaction("Withdraw", amount, "Standard Withdraw");
            this.balance -= amount;
            return true;
        }
        return false;
    }

    /*
      validateTransaction(double)
      This method must be called by every transaction related methods
      This method will compare the amount of money transaction will use with balance
      This method must return true or false
           - true is for transaction can be perform( need < balance )
           - false is for transaction can not be perform ( need > balance )
     */
    public boolean validateTransaction(double amount){
        if(amount <= this.balance){
            return true;
        }
        return false;
    }

    /*
      updateBalance(double amount)
      This method must be called when account need to set new balance amount
      This method must return true or false
           - true is for success
           - false is for failed
     */
    private boolean updateBalance(double amount){
        if(amount >= 0){
            this.balance = amount;
            return true;
        }
        return false;
    }

    /*
      makeTransaction()
      This method must be called when Transaction need to be created
      This methode should create Transaction object and put in history_list
      This method must return true or false
           - true is for success
           - false is for failed
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
