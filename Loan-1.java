// Erik Neu
// Class represents loans borrowed by a customer

public class Loan extends Cash {
  
  // fields for loan limit and overdraft penalty
  private double loanLimit = 0.0;
  private double overdraftPenalty = 0.0;
  
  // field to record if the account has been overdrafted
  private boolean isOverdrafted = false;
  
  // constructor to input interest rate, loan limit, and overdraft penalty
  public Loan(double interestRate, double loanLimit, double overdraftPenalty) {
    super(interestRate);
    this.loanLimit = loanLimit;
    this.overdraftPenalty = overdraftPenalty;
  }
  
  // method to get the loan limit
  public double getLoanLimit() {
    return this.loanLimit;
  }
  
  // method to set the loan limit
  public void setLoanLimit(double loanLimit) {
    this.loanLimit = loanLimit;
  }
  
  // method to get overdraft penalty
  public double getOverdraftPenalty() {
    return this.overdraftPenalty;
  }
  
  // method to set overdraft penalty
  public void setOverdraftPenalty(double overdraftPenalty) {
    this.overdraftPenalty = overdraftPenalty;
  }
  
  // overrides the processDay() method to account for overdrafting the loan
  @Override
  public void processDay() {
    if (this.getBalance() >= 0) {
      if (this.getBalance() > this.getLoanLimit()) {
        this.balance = this.getBalance() + (this.getBalance() * this.getInterestRate() / 365);
        isOverdrafted = true;
      }
      else {
        this.balance = this.getBalance() + (this.getBalance() * this.getInterestRate() / 365);
      }
    }
    else;
  }
  
  // overrides the processMonth() method to account for overdrafting the loan. also applies overdraft fee to balance
  @Override
  public void processMonth() {
    if (this.getBalance() >= 0) {
      if (isOverdrafted == true) {
        this.balance = this.getBalance() + (this.getBalance() * this.getInterestRate() / 12) + this.getOverdraftPenalty();
      }
      else if (this.getBalance() > this.getLoanLimit()) { 
        this.balance = this.getBalance() + (this.getBalance() * this.getInterestRate() / 12) + this.getOverdraftPenalty();
        isOverdrafted = true;
      }
      else {
        this.balance = this.getBalance() + (this.getBalance() * this.getInterestRate() / 12);
      }
    }
    else;
  }
}