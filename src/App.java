public class App {

    public static void main(String[] args) {
        BankAccount bank1 = new BankAccount("peepee", 50.0f); 
        System.out.println(bank1.getAccountHolderName()); 
        System.out.println(bank1.getRandomAccNum());
        System.out.println(bank1.getAccountBalance());
        bank1.deposit((float) 100);
        // bank1.deposit((float) -1);
        bank1.withdraw((float) 5);
        // bank1.withdraw((float) 500);
        System.out.println(bank1.getAccountBalance());
        System.out.println(bank1.getTransactions()); 
        System.out.println(bank1.getAccountCreated());
        bank1.setAccountOpen(false);
        System.out.println(bank1.getAccountClosed());
        // bank1.deposit((float) 10);

        FixedDeposit fd1 = new FixedDeposit("deedee", 500.0f, 6.0f, 10);
        System.out.println(fd1.getAccountHolderName());
        System.out.println(fd1.getRandomAccNum());
        System.out.println(fd1.getAccountBalance());
        fd1.deposit((float) 100);
        fd1.withdraw((float) 5);
        fd1.getBalance();
        System.out.println(fd1.getAccountCreated());
        fd1.setAccountOpen(false);
        System.out.println(fd1.getAccountClosed());

        FixedDeposit fd2 = new FixedDeposit("weewee", 10.0f);
        fd2.setInterest(10.0f);
        // fd2.setInterest(12.0f);
        fd2.setDurationMonths(12);
        // fd2.setDurationMonths(15);

        System.out.println(fd2.getInterest()); 
        System.out.println(fd2.getDurationMonths());

    }
}
