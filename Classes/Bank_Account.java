abstract class BankAccount{

    public String name;

    private double balance;
    private String account_number;

    private Transaction[] history_list;
    private history_count = 0;
    private static final MAX_HISTORY_SIZE = 50;

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
        return balance;
    }

    /*
      deposit(double amount)
      This method will take an input amount and add money to balance
      This method must return true or false
           - true is for success
           - false is for failed
     */
    public boolean deposit(double amount){

    }

    /*
      withdraw(double amount)
      This method will take an input amount and remove money from balance
      This method must return true or false
           - true is for success
           - false is for failed
     */
    public boolean withdraw(double amount){

    }

    /*
      validateTransaction(double)
      This method must be called by every transaction related methods
      This method will compare the amount of money transaction will use with balance
      This method must return true or false
           - true is for transaction can be perform( need < balance )
           - false is for transaction can not be perform ( need > balance )
     */
    private boolean validateTransaction(double amount){

    }

    /*
      updateBalance(double amount)
      This method must be called when account need to set new balance amount
      This method must return true or false
           - true is for success
           - false is for failed
     */
    private boolean updateBalance(double amount){

    }

    /*
      makeTransaction()
      This method must be called when Transaction need to be created
      This methode should create Transaction object and put in history_list
      This method must return true or false
           - true is for success
           - false is for failed
     */
    private boolean makeTransaction(){

    }
}
