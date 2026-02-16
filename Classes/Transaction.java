import java.time.LocalDate;

class Transaction{

    enum STATE{
        INPROGRESS,
        FAILED,
        SUCCESS
    }

    public LocalDate time_stamp;
    public int priority_value;
    public STATE state;
    public String type;
    public double amount;
    public String description;

    // This is constructor
    public Transaction(LocalDate timestamp, String type, double amount, String description){
        this.time_stamp = timestamp;
        this.priority_value = 0;
        this.type = type;
        this.state = STATE.INPROGRESS;
        this.amount = amount;
        this.description = description;
    }


    /*
      toString()
      This method must return string that include all the info of the transaction
      Example:
      | date | priority_value | state | type | amount | description |
      | 2026-12-13 | 5 | INPROGRESS | Withdraw | 1000.0 | buy laptop |
     */
    public String toString(){

    }

}
