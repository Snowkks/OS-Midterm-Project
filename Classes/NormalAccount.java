import Interfaces.Transferable;


/*
  This class extends from BankAccount Abstract Class
  This class implement Tranferable Interface
 */
public class NormalAccount extends BankAccount implements Transferable{

    private double incountry_fee = 0.25;
    private double international_fee = 0.55;
    private double loan_amount;
    private int credits;


    //This is constructer
    public NormalAccount(String name, String account_number){
        super(name, account_number);
        this.credits = 100;
    }

    /*
      takeOutLoan(double amount)
      This method just increase loan_amount by amount and also increase the balance
      return amount of loan
     */
    public double takeOutLoan(double amount){
        if(super.validateTransaction(amount)){
            this.loan_amount += amount;
            super.deposit(amount);
            return amount;
        }
        return 0.0;
    }

    /*
      This method is from Transferable
      This method should decrease balance by amount with incountry_fee
      This method must return true or false
           - true is for success
           - false is for failed
     */
    public boolean transferInCountry(double amount){
        if(super.withdraw(amount + incountry_fee)){
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
    public boolean transferOutsideCountry(double amount){
        if(super.withdraw(amount + international_fee)){
            return true;
        }
        return false;
    }


    @Override
    public String getAccountType() {
        return "Normal";
    }

}
