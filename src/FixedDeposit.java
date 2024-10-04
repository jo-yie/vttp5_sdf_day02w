public class FixedDeposit extends BankAccount {
    
    private final float accountBalance; 
    private float interest = 3.0f; // can only be set once
    private Integer durationMonths = 6; // can only be set once

    private boolean interestSet = false;
    private boolean durationSet = false;

    public FixedDeposit(String accountHolderName, Float accountBalance) {
        super(accountHolderName);
        this.accountBalance = accountBalance;
    }

    public FixedDeposit(String accountHolderName, Float accountBalance, float interest) {
        super(accountHolderName, accountBalance);
        this.accountBalance = accountBalance;
        this.interest = interest;
    }

    public FixedDeposit(String accountHolderName, Float accountBalance, float interest, Integer durationMonths) {
        super(accountHolderName);
        this.accountBalance = accountBalance;
        this.interest = interest;
        this.durationMonths = durationMonths;
    }

    @Override
    public void deposit(Float depositAmt) {
        System.out.println("Deposits not allowed");
    }

    @Override
    public void withdraw(Float withdrawAmt) {
        System.out.println("Withdrawals not allowed");
    }

    public float getBalance() {
        // balance + interest
        float total = this.getAccountBalance() * ((this.interest / 100.0f) * this.durationMonths);
        return total;
    }

    public float getInterest() {
        return interest;
    }

    // interest can only be set once
    public void setInterest(float interest) {
        if (!this.interestSet) {
            this.interest = interest;
            this.interestSet = true;
        } else {
            throw new IllegalArgumentException("Interest has already been set once");
        }
        
    }

    public Integer getDurationMonths() {
        return durationMonths;
    }

    // duration can only be set once 
    public void setDurationMonths(Integer durationMonths) {
        if (!this.durationSet) {
            this.durationMonths = durationMonths;
            this.durationSet = true;
        } else {
            throw new IllegalArgumentException("Duration has already been set once");
        }
    }

}
