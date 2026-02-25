package Classes;

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
    public double calculateInterest(double amount){
        return amount * interest_rate;
    }

    /*
      This methode calculate how many user should save per month to reach the goal
     */
    public String calculateAmountPerMonth(double goal_amount){
        double amount_per_month = goal_amount / 12;
        return String.format("%.2f | 12 months", amount_per_month);
    }

    /*
      create a interest Process
     */
    public Runnable createInterestTask() {
        return () -> {
            double interestToApply = this.calculateInterest(this.getBalance());
            this.deposit(interestToApply);
            System.out.println("[Scheduler] Applied $" + String.format("%.2f", interestToApply) + " interest. New Balance: $" + this.getBalance());
        };
    }

    @Override
    public String getAccountType() {
        return "Saving";
    }

}
