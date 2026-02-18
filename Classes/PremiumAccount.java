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
      takeOutLoan(double amount)
      This method just increase invest_amount by amount and also decrease the balance
     */
    public double invest(double amount){
        return 0.0;
    }

    /*
      This method is from Transferable
      This method should decrease balance by amount with incountry_fee
      This method must return true or false
           - true is for success
           - false is for failed
     */
    public boolean transferInCountry(double amount, double fee){
        if(super.withdraw(amount + fee)){
            return true;
        }
        return false;
    }

    /*
      This method is from Transferable
      This method should decrease balance by amount with international_fee
      This method must return true or false
           - true is for success
           - false is for failed
     */
    public boolean transferOutsideCountry(double amount, double fee){
        if(super.withdraw(amount + fee)){
            return true;
        }
        return false;
    }

    @Override
    public String getAccountType(){
        return "Premium";
    }

}
