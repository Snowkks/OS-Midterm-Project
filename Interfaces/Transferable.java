package Interfaces;

public interface Transferable{
    public boolean transferInCountry(double amount, double fee);
    public boolean transferOutsideCountry(double amount, double fee);
}
