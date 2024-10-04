import java.util.*;
import java.time.LocalDateTime;


public class BankAccount {
    private final String accountHolderName;
    private final String randomAccNum; 
    private float accountBalance;
    private List<String> transactions; 
    private Boolean accountOpen = true; 
    private LocalDateTime accountCreated;
    private LocalDateTime accountClosed;

    Random rand = new Random();
    
    public BankAccount(String accountHolderName) {
        this.accountHolderName = accountHolderName;
        this.randomAccNum = String.valueOf(rand.nextInt(100, 1000));
        this.accountBalance = 0.0f;
        this.accountCreated = LocalDateTime.now();

        if (transactions == null) {
            transactions = new ArrayList<>();
        }
    }

    public BankAccount(String accountHolderName, Float accountBalance) {
        this.accountHolderName = accountHolderName;
        this.randomAccNum = String.valueOf(rand.nextInt(1000));
        this.accountBalance = accountBalance;
        this.accountCreated = LocalDateTime.now();

        if (transactions == null) {
            transactions = new ArrayList<>();
        }
    } 

    // alternative method for generating account no 
    private String generateAccountNo() {
        int startAsciNo = 65; 
        int endAsciNo = 90; 
        int accountNoLength = 10; 
        Random random = new Random(); 
        String accountNo = "";

        for (int i = 0; i < accountNoLength; i++) {
            int randomValue = startAsciNo + random.nextInt() * (endAsciNo - startAsciNo + 1);
            accountNo = accountNo + (char) randomValue; 
        }

        return accountNo; 
    }

    public void deposit(Float depositAmt) {
        if (depositAmt < 0) {
            throw new IllegalArgumentException("Deposit amount cannot be less than zero");
        } else if (!accountOpen) {
            throw new IllegalArgumentException("Account is closed");
        } else {
            this.accountBalance += depositAmt;
            LocalDateTime today = LocalDateTime.now();

            String transactionStatement = "Deposit $" + depositAmt + " at " + today;
            transactions.add(transactionStatement);

            // System.out.println(transactionStatement);
            // System.out.println(transactions);
        }
    }

    public void withdraw(Float withdrawAmt) {
        if (withdrawAmt < 0) {
            throw new IllegalArgumentException("Withdraw amount cannot be less than zero");
        } else if (withdrawAmt > this.accountBalance) {
            throw new IllegalArgumentException("Not enough money in account");
        } else if (!accountOpen) {
            throw new IllegalArgumentException("Account is closed");
        } else {
            this.accountBalance -= withdrawAmt;
            LocalDateTime today = LocalDateTime.now();

            String transactionStatement = "Withdraw $" + withdrawAmt + " at " + today;
            transactions.add(transactionStatement);

            // System.out.println(transactionStatement);
            // System.out.println(transactions);
        }
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public String getRandomAccNum() {
        return randomAccNum;
    }

    public float getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(float accountBalance) {
        this.accountBalance = accountBalance;
    }

    public List<String> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<String> transactions) {
        this.transactions = transactions;
    }

    public Boolean getAccountOpen() {
        return accountOpen;
    }

    public void setAccountOpen(Boolean accountOpen) {
        this.accountOpen = accountOpen;
        if (!accountOpen) {
            this.accountClosed = LocalDateTime.now();
        }
    }

    public LocalDateTime getAccountCreated() {
        return accountCreated;
    }

    public void setAccountCreated(LocalDateTime accountCreated) {
        this.accountCreated = accountCreated;
    }

    public LocalDateTime getAccountClosed() {
        return accountClosed;
    }

    public void setAccountClosed(LocalDateTime accountClosed) {
        this.accountClosed = accountClosed;
    }

    public Random getRand() {
        return rand;
    }

    public void setRand(Random rand) {
        this.rand = rand;
    }

}