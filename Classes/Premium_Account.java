/*
  This class extends from BankAccount Abstract Class
  This class implement Tranferable Interface
 */
public class PremiumAccount extends BankAccount implements Tranferable{

    private double incountry_fee = 0.0;
    private double international_fee = 0.02;
    private double invest_amount;
    private double estimate_profit;
    public int credits;


    //This is constructer
    public NormalAccount(String name, String account_number){
        super(name, account_number);
        this.credits = 100;
    }

    /*
      takeOutLoan(double amount)
      This method just increase invest_amount by amount and also decrease the balance
     */
    public double invest(double amount){

    }

    /*
      This method is from Transferable
      This method should decrease balance by amount with incountry_fee
      This method must return true or false
           - true is for success
           - false is for failed
     */
    public boolean tranferInCountry(double amount, double fee){

    }

    /*
      This method is from Transferable
      This method should decrease balance by amount with international_fee
      This method must return true or false
           - true is for success
           - false is for failed
     */
    public boolean tranferOutsideCountry(double amount, double fee){

    }

}
