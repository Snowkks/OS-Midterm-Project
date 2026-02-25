package Classes;

import Interfaces.Transferable;

/*
  This class extends from BankAccount Abstract Class
  This class implement Tranferable Interface
 */
public class PremiumAccount extends BankAccount implements Transferable{

    private double incountry_fee = 0.0;
    private double international_fee = 0.02;
    private double invest_amount;
    private double estimate_profit;
    private int credits;

    //This is constructer
    public PremiumAccount(String name, String account_number){
        super(name, account_number);
        this.credits = 100;
    }

    /*
      This method just increase invest_amount by amount and also decrease the balance
     */
    public double invest(double amount){
        if(super.validateTransaction(amount)){
            this.invest_amount += amount;
            super.withdraw(amount);
            return amount;
        }
        return 0.0;
    }

    /*
      This method is from Transferable
      This method should decrease balance by amount with incountry_fee
     */
    public boolean transferInCountry(double amount){
        return super.withdraw(amount + incountry_fee);
    }

    /*
      This method is from Transferable
      This method should decrease balance by amount with international_fee
     */
    public boolean transferOutsideCountry(double amount){
        return super.withdraw(amount + international_fee);
    }

     /*
       Create a Transferoutside process
     */
    public Runnable createTransferOutsideTask(double amount, String personName) {
        return () -> {
            System.out.println("[" + personName + "] Attempting to wire $" + amount + " outside the country...");
            boolean success = this.transferOutsideCountry(amount);
            if (!success) System.out.println("[" + personName + "] Transfer FAILED: Insufficient funds.");
        };
    }

     /*
       Create a Transferinside process
     */
    public Runnable createTransferInsideTask(double amount, String personName) {
        return () -> {
            System.out.println("[" + personName + "] Attempting to wire $" + amount + " inside the country...");
            boolean success = this.transferInCountry(amount);
            if (!success) System.out.println("[" + personName + "] Transfer FAILED: Insufficient funds.");
        };
    }

    @Override
    public String getAccountType(){
        return "Premium";
    }
}
