import Interfaces.Interestable;

/*
  This class extends from BankAccount Abstract Class
  This class implement Interestable Interface
 */
public class SavingAccount extends BankAccount implements Interestable{
    private double interest_rate = 0.02;
    private double goal_amount;


    //This is constructer
    public SavingAccount(String name, String account_number, double goal_amount){
        super(name, account_number);
        this.goal_amount = goal_amount;
    }

    /*
     This method is from Interestable Interface
     This method calcualte the money amount that this account will get this month
     */
    public double calculateInterest(double amount, double rate){
        return 0.0;
    }

    /*
      calculateAmountPerMonth(double goal_amount)
      This methode calculate how many user should save per month to reach the goal
      This method should return amount per month and how many month
     */
    public String calculateAmountPerMonth(double goal_amount){
        return "10.0 | 12 month";
    }

    @Override
    public String getAccountType() {
        return "Saving";
    }

}
