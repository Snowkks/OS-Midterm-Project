import Classes.*;

public class BankSystemTesting {
    public static void main(String[] args) {

        Queue_System bankQueue = new Queue_System();

        SavingAccount peterAccount = new SavingAccount("Peter Griffin", "102003", 50000.0);
        peterAccount.deposit(1000.0);

        PremiumAccount companyAccount = new PremiumAccount("Silly Corp", "298475");
        companyAccount.deposit(5000.0);

        // Ask Peter's account for the interest task, run it every 2 seconds
        bankQueue.scheduleRecurringTask(peterAccount.createInterestTask(), 1, 2);

        // Both Jeff and Joe are try to trabfer at the same time in company account
        bankQueue.submitTransaction(companyAccount.createTransferInsideTask(3000.0, "Jeff"));
        bankQueue.submitTransaction(companyAccount.createTransferOutsideTask(3000.0, "Joe"));


        // delay before shutdown
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Shut down
        bankQueue.shutdownSystem();
        System.out.println("Final Company Balance: $" + companyAccount.getBalance());
        System.out.println("Final Peter Balance: $" + peterAccount.getBalance());



    }
}
