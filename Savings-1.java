// Erik Neu
// Class represents money deposited or earned by customer

public class Savings extends Cash {
  
  // constructor to input a savings interest rate
  public Savings(double interestRate) {
    super(interestRate);
  }
  
  // method that deposits money into balance
  public void deposit(double money) {
    this.transfer(-money);
  }
  
  // method that withdraws money from balance, but won't if not enough funds can be withdrawn
  public boolean withdraw(double money) {
    if (money <= this.getBalance()) {
      this.transfer(money);
      return true;
    }
    else {
      return false;
    } 
  }
}