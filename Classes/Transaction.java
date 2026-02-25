package Classes;

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
      This method must return string that include all the info of the transaction
      Example:
      | date | priority_value | state | type | amount | description |
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("| ").append(this.time_stamp)
            .append(" | ").append(this.priority_value)
            .append(" | ").append(this.state)
            .append(" | ").append(this.type)
            .append(" | ").append(this.amount)
            .append(" | ").append(this.description).append(" |");
        return sb.toString();
    }

}
