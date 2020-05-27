public class Coin
{
  //attributes, aka fields, aka properties
  private static int totalCoins;
  private double p; //type double
  private int numHeads; //type int
  private int numTails;
  private int totalFlips;
  private final double fairP = 0.5; //final variable
  private boolean isFair; //type boolean
  private String outcomes;
  public Coin()
  {
    totalCoins++; //addition
    p = fairP;
    numHeads = 0;
    numTails = 0;
    totalFlips = 0;
    isFair = true;
    outcomes = "";
  }
  public Coin(double pHeads) //constructor with formal parameter, overloaded constructor
  {
    totalCoins++;
    p = pHeads;
    numHeads = 0;
    numTails = 0;
    totalFlips = 0;
    if(Math.abs(p-0.5)>0.01) //subtraction
      isFair = false;
    else
      isFair = true;
    outcomes = "";
  }
  public String flip() //zero-parameter method
  {
    totalFlips++;
    if(Math.random()<p)
    {
      numHeads++;
      outcomes += "h";
      return "heads"; //String literal
    }
    else 
    {
      numTails++;
      outcomes += "t";
      return "tails";
    }
  }
  public void flip(int f) //non-static method, void method, method overloading
  {
    totalFlips+=f;
    while(f > 0)
    {
      if(Math.random()<p)
      {
        numHeads++;
        outcomes += "h";
      }
      else 
      {
        numTails++;
        outcomes += "t";
      }
      f--;
    }
  }
  public String getOutcomes()
  {
    return outcomes;
  }
  public static int getTotalCoins() //static method
  {
    return totalCoins;
  }
  public int getNumHeads() //non-void method
  { 
    return numHeads;
  }
  public int getNumTails()
  {
    return numTails;
  }
  public int getTotalFlips()
  {
    return totalFlips;
  }
  public void setP(double updateP) //method with parameter
  {
    p = updateP;
  }
  public double propHeads()
  {
    return (double)numHeads/totalFlips; //division
  }
  public double propTails()
  {
    return (double)numTails/totalFlips;
  }
  public boolean getIsFair()
  {
    return isFair;
  }
  public int expectedHeads(int flips)
  {
    return (int)(flips*p); //multiplication
  }
  public String printExpectedHeads(int flips)
  {
    return "If you flip this coin " + flips + " times, you would expect to get heads "
      + expectedHeads(flips) + " times.";
  }
  public int firstHeads()
  {
    return outcomes.indexOf("h");
  }
  public int firstTails()
  {
    return outcomes.indexOf("t");
  }
  
  public int excessHeads()
  {
    return  (getNumHeads()%(int)(totalFlips*p)); //%
  }
  
  public String toString() //toString() method
  {
    return "This coin has landed heads " + getNumHeads() + " times and tails " + getNumTails() + " times.\n" //escape sequence
      + "It lands heads " + (int)(100*propHeads()) + " percent of the time.\n"; //casting, concatenation of Strings and primitives
  }
  
}