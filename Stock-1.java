// Erik Neu
// Class represents a stock, having a ticker symbol, current price, dividend rate, date the dividend is paid, number
// of shares owned, cost basis of stock, and capital gains earned by the stock

public class Stock {
  
  // fields for stock symbol, current price, dividend date, and dividend rate from constructor
  private String tickerSymbol = null;
  private double currentPrice = 0.0;
  private Date dividendDate = null;
  private double dividendRate = 0.0;
  
  // field for number of stock shares owned
  private int numberShares = 0;
  
  // field for cost basis
  private double costBasis = 0.0;
  
  // field for capital gains
  private double capitalGains = 0.0;
  
  // constructor just for symbol and current price of stock
  public Stock(String tickerSymbol, double currentPrice) {
    super();
    this.tickerSymbol = tickerSymbol;
    this.currentPrice = currentPrice;
  }
  
  // constructor for symbol, current price, dividend date, and dividend rate
  public Stock(String tickerSymbol, double currentPrice, Date dividendDate, double dividendRate) {
    this(tickerSymbol, currentPrice);
    this.dividendDate = dividendDate;
    this.dividendRate = dividendRate;
  }
  
  // method to get ticker symbol
  public String getTickerSymbol() {
    return tickerSymbol;
  }
  
  // method to get current price of stock
  public double getCurrentPrice() {
    return currentPrice;
  }
  
  // method to set a new current price for the stock
  public void setCurrentPrice(double currentPrice) {
    // this.currentPrice becomes the input of currentPrice
    this.currentPrice = currentPrice;
  }
  
  // method to get the dividend rate
  public double getDividendRate() {
    return this.dividendRate;
  }
  
  // method to set the dividend rate
  public void setDividendRate(double dividendRate) {
    // this.dividendRate is set to the input dividendRate
    this.dividendRate = dividendRate;
  }
  
  // method gets/returns dividend date
  public Date getDividendDate() {
    return this.dividendDate;
  }
  
  // method sets dividend date
  public void setDividendDate(Date a) {
    // sets the dividendDate to Date a
    this.dividendDate = a;
  }
  
  // method returns the number of shares owned
  public int getNumberShares() {
    return numberShares;
  }
  
  // method gets the cost basis of shares owned and commission to buy the shares
  public double getCostBasis() {
    return this.costBasis;
  }
  
  // method returns the capital gains of a stock
  public double getCapitalGains() {
    return capitalGains;
  }
  
  public double payDividend() {
    this.capitalGains = this.capitalGains + (this.getDividendRate() * this.getNumberShares());
    return this.getDividendRate() * this.getNumberShares();
  }
  
  // purchases shares of a stock plus a commission fee and increases stocks held
  public double buy(int numberShares , double commission) {
    this.numberShares = this.getNumberShares() + numberShares;
    this.costBasis = this.getCostBasis() + (numberShares * this.getCurrentPrice()) + commission;
    return numberShares * this.getCurrentPrice() + commission;
  }
  
  // method sells shares of a stock plus a commission fee and decreases shares held
  public double sell(int numberShares , double commission) {
    if (numberShares > this.getNumberShares()) {
      return 0;
    }
    else {
      this.capitalGains = this.getCapitalGains() + (((double)numberShares * this.getCurrentPrice()) - commission - (this.getCostBasis() * ((double)numberShares / (double)this.getNumberShares())));
      this.costBasis = this.getCostBasis() - (this.getCostBasis() * (numberShares / this.getNumberShares()));
      this.numberShares = this.getNumberShares() - numberShares;
      return (numberShares * this.getCurrentPrice()) - commission;
    }
  }
  
  // method splits stock shares (if it is a 2:1 split, it doubles, if it is a 1:2, it halves), and sells the fraction share
  // if there is a decimal in the shares (fraction shares can't exist, so it is sold)
  public double split(int numerator, int denominator) {
    if ((numerator == 0) || (denominator == 0)) {
      return 0;
    }
    else {
      // splitShare is shares after the split, while this.getNumberShares is prior to split
      double splitShare = this.getNumberShares() * ((double)numerator / (double)denominator);
      if ((numerator % denominator) != 0.0 ) {
        // fractionShare is the share fraction sold if the split result is not a whole number
        double fractionShare = splitShare - (double)((int)splitShare);
        this.capitalGains = this.getCapitalGains() + ((fractionShare * this.getCurrentPrice()));
        this.numberShares = (int)splitShare;
        return fractionShare * this.getCurrentPrice();
      }
      else {
        this.numberShares = (int)splitShare;
        return 0;
      }
    }
  }
}  