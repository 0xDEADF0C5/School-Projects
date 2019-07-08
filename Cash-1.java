// Erik Neu
// Cash represents an account that holds money. It also has an interest rate, and a record of amount earned through interest

public class Cash {
  
  // field for interest rate of account
  private double interestRate = 0.0;
  
  //field for balance of account
  public double balance = 0.0;
  
  // constructor to take input for interest rate of account
  public Cash(double interestRate) {
    super();
    this.interestRate = interestRate;
  }
  
  public double getBalance() {
    return balance;
  }
  
  // method returns the interest rate
  public double getInterestRate() {
    return interestRate;
  }
  
  // method sets the interest rate
  public void setInterestRate(double interestRate) {
    this.interestRate = interestRate;
  }
  
  // method transfers money to account (negative) or away from the account (positive)
  public void transfer(double money) {
    this.balance = this.getBalance() - money;
  }
  
  // method gets the interest earned on a balance in account
  public double getInterestEarned() {
    return this.getBalance() * this.getInterestRate();
  }
  
  // method processes one day of interest
  public void processDay() {
    if (this.getBalance() >= 0) {
      this.balance = this.getBalance() + (this.getBalance() * this.getInterestRate() / 365);
    }
    else;
  }
  
  // method processes one month of interest
  public void processMonth() {
    if (this.getBalance() >= 0) {
      this.balance = this.getBalance() + (this.getBalance() * this.getInterestRate() / 12);
    }
    else;
  }
}