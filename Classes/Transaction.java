import java.time.LocalDate;

class Transaction{

    public enum STATE{
        INPROGRESS,
        FAILED,
        SUCCESS
    }

    private LocalDate time_stamp;
    private int priority_value;
    private STATE state;
    private String type;
    private double amount;
    private String description;

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
        return "| " + this.time_stamp + " | " + this.priority_value + " | " + this.state + " | " + this.type + " | " + this.amount + " | " + this.description + " |";
    }

}
