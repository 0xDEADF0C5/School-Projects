// Erik Neu
// Class represents a customer's account. Will have savings, loans, stocks, name, commission, and date

public class Customer {
  
  private String firstName = null;
  private String lastName = null;
  private double commissionAmount = 0.0;
  private Stock stock = null;
  private Savings savings = null;
  private Loan loan = null;
  private Date date = null;
  
  // constructor to take first name, last name, commission amount, stock, savings, loan, and date as input for customer
  public Customer(String firstName, String lastName, double commissionAmount, Stock stock, Savings savings, Loan loan, Date date) {
    super();
    this.firstName = firstName;
    this.lastName = lastName;
    this.commissionAmount = commissionAmount;
    this.stock = stock;
    this.savings = savings;
    this.loan = loan;
    this.date = date;
  }
  
  // method returns first name field
  public String getFirstName() {
    return this.firstName;
  }
  
  // method sets first name field
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }
  
  // method gets last name field
  public String getLastName() {
    return this.lastName;
  }
  
  //method sets last name field
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
  
  // method returns stock field
  public Stock getStock() {
    return this.stock;
  }
  
  // method sets stock field
  public void setStock(Stock stock) {
    this.stock = stock;
  }
  
  // method returns savings field
  public Savings getSavings() {
    return this.savings;
  }
  
  // method returns loan field
  public Loan getLoan() {
    return this.loan;
  }
  
  // method returns commission field
  public double getCommissionAmount() {
    return this.commissionAmount;
  }
  
  // method sets commission amount field
  public void setCommissionAmount(double commission) {
    this.commissionAmount = commission;
  }
  
  // method returns date
  public Date getDate() {
    return this.date;
  }
  
  // method sets the date field
  public void setDate(Date d) {
    this.date = d;
  }
  
  // method returns current value or net worth of the account by adding savings and stock value but subtracting loan balance
  public double currentValue() {
    return this.getSavings().getBalance() + (this.getStock().getNumberShares() * this.getStock().getCurrentPrice()) - this.getLoan().getBalance();
  }
  
  // method deposits money into savings balance
  public void deposit(double money) {
    this.getSavings().deposit(money);
  }
  
  // pays down the loan balance not using savings money
  public void payLoan(double money) {
    this.getLoan().transfer(money);
  }
  
  // method withdraws money from savings balance
  public boolean withdraw(double money) {
    if (money <= this.savings.getBalance()) {
      this.getSavings().withdraw(money);
      return true;
    }
    else {
      return false;
    }
  }
  
  // method sells shares as long as it is the right stock and the amount of shares to be sold is less or equal to the number held
  public void sellShares(int sharesSold, String tickerSymbol) {
    if ((this.getStock().getTickerSymbol().equals(tickerSymbol)) && (sharesSold <= this.getStock().getNumberShares())){
      this.getStock().sell(sharesSold, this.getCommissionAmount());
      this.getSavings().deposit((double)sharesSold * this.getStock().getCurrentPrice() - this.getCommissionAmount()); 
    }
  }
  
  // method purchases shares based on amount of money held in savings (the money comes from savings)
  public boolean buyShares(int sharesBought, String tickerSymbol) {
    if ((this.getStock().getTickerSymbol().equals(tickerSymbol)) && (this.currentValue() >= (this.getStock().getCurrentPrice() * sharesBought))) {
      this.getStock().buy(sharesBought, this.getCommissionAmount());
      this.getSavings().withdraw((double)sharesBought * this.stock.getCurrentPrice() + this.getCommissionAmount());
      return true;
    }
    else {
      return false;
    }
  }
  
  public void incrementDate() {
    this.getDate().incrementDay();
    if (this.getDate().equals(this.getStock().getDividendDate())) {
      this.deposit(this.getStock().payDividend());
    }
    else;
    if (this.getSavings().getBalance() < 0) {
      this.getLoan().transfer(this.getSavings().getBalance());
      this.getSavings().transfer((this.getSavings().getBalance()));
      this.getSavings().processDay();
      this.getLoan().processDay();  
    }
    else;
    if (this.getDate().getDay() == 1) {
      this.getSavings().processMonth();
      this.getLoan().processMonth();
    }
    else;
  }
}
    