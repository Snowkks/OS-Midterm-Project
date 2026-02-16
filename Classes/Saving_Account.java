/*
  This class extends from BankAccount Abstract Class
  This class implement Interestable Interface
 */
public class SavingAccount extends BankAccount implements Interestable{
    private double interest_rate = 0.02;
    public double goal_amount;


    //This is constructer
    public SavingAccount(String name, String account_number, double goal_amount){
        super(name, account_number);
        this.goal_amount = goal_amount;
    }

    /*
     This method calcualte the money amount that this account will get this month
     */
    public double calculateInterest(double amount){

    }

    /*
      calculateAmountPerMonth(double goal_amount)
      This methode calculate how many user should save per month to reach the goal
      This method should return amount per month and how many month
     */
    public double calculateAmountPerMonth(double goal_amount){

    }
}
