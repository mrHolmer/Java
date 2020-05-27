import java.util.*;
public class CoinGame
{
  private static int numCoinGames;
  private String playerName;
  private int balance;
  private Coin c1;
  private Coin c2;
  private int correct;
  private int flips;
  private int wager;
  public CoinGame(String pN, int b)
  {
    numCoinGames++;
    playerName = pN;
    balance = b;
    welcome();
    playGame();
  }
  public CoinGame(String pN)
  {
    numCoinGames++;
    playerName = pN;
    setBalance();
    welcome();
    playGame();
  }
  public CoinGame(int b)
  {
    numCoinGames++;
    Scanner name = new Scanner(System.in);
    System.out.print("What is your name?");
    playerName = name.nextLine();
    balance = b;
    welcome();
    playGame();
  }
  public CoinGame()
  {
    numCoinGames++;
    setPlayerName();
    setBalance();
    welcome();
    playGame();
  }
  public void welcome()
  {
    System.out.println("Welcome to the Coin Game, " + playerName + "!\n" +
                       "Your balance is " + balance + ".");
  }
  public void setPlayerName()
  {
    Scanner name = new Scanner(System.in);
    System.out.print("What is your name?");
    try
    {
      playerName = name.nextLine();
    }
    catch(Exception e)
    {
      System.out.println("I don't understand.  Please try again.");
      setPlayerName();
    }
  }
  public void playGame()
  {
   System.out.println("The coin game asks you to compare two coins to determine which is fairer.\n" +
                      "I will now flip two coins 10 times each and represent their outcomes.\n" +
                      "h represents heads and t represents tails.\n");
   c1 = new Coin(Math.random());
   c2 = new Coin(Math.random()); 
   c1.flip(10);
   c2.flip(10);
   System.out.println("Coin 1's outcomes are " + c1.getOutcomes() + " and\n" +
                      "Coin 2's outcomes are " + c2.getOutcomes());
   System.out.print("How much would you like to wager?");
   wager();
   System.out.println("Which coin do you think is fairer?");
   
     
   
  }
  public void wager()
  {
    Scanner w = new Scanner(System.in);
    wager = w.nextInt();
    if(wager > balance)
    {
      System.out.println("You don't have that much money.");
      wager();
    }
    if (wager < 0)
    {
      System.out.println("You must wager a positive amount of money.");
      wager();
    }
  }
  public void setBalance()
  {
    Scanner b = new Scanner(System.in);
    System.out.print("Hello, " + playerName + ". How much would you like to risk today?");
    try
    {
      balance = b.nextInt();
    }
    catch(Exception e)
    {
      System.out.println("I didn't catch that.  Let's try again.");
      setBalance();
    }
  }
}
  /*public static void playerName()
  {
    Scanner name = new Scanner(System.in);
    System.out.print("What is your name?");
    playerName = name.nextLine();
    System.out.println("Welcome, " + playerName + ".");
  }
  public static void difficulty()
  {
    System.out.println("Would you rather use a fair coin or a random coin?");
    Scanner coin = new Scanner(System.in);
    String coinDiff = coin.nextLine();
    if(coinDiff.equals("random"))
    {
      c = new Coin(Math.random());
    }
    else if(coinDiff.equals("fair"))
    {
      c = new Coin();
    }
    else
    {
      System.out.println("Let's try that again.");
      difficulty();
    }
  }
 /* public static void balance()
  {
    System.out.println("Your balance is $" + balance + ".");
  }
  public static void wager()
  {
    System.out.print("How much would you like to wager?");
    Scanner w = new Scanner(System.in);
   // try{wager = w.nextInt();}
    //catch(Exception e)
    if(wager > balance)
    {
      System.out.println("You don't have that much money.");
      wager();
    }
    if (wager < 0)
    {
      System.out.println("You must wager a positive amount of money.");
      wager();
    }
  }
  public static void headsOrTails()
  {
    System.out.print("Heads or tails?");
    Scanner call = new Scanner(System.in);
    String headsOrTails = call.nextLine();
    headsOrTails.toLowerCase();
    String flip = c.flip();
    flips++;
    System.out.println("It's " + flip + ".");
    if (headsOrTails.equals(flip))
    {
      System.out.println("You got it!");
      correct++;
      balance += wager;
      if (correct > 1)
      {
        System.out.println("You've been correct " + correct + " times.");
        System.out.println("You are correct " + (int)((double)correct/flips*100) + " percent of the time.");
      }
      balance();
      wager();
      headsOrTails();
    }
    else
    {
      System.out.println("Sorry, you were wrong.");
      System.out.println("You've been correct " + correct + " times.");
      System.out.println("You are correct " + (int)((double)correct/flips*100) + " percent of the time.");
      balance -= wager;
      balance();
      if(balance<=0)
        gameOver();
      else
      {
      wager();
      headsOrTails();
      }
    }
  }
  public static void gameOver()
  {
    System.out.println("You lose. Would you like to play again?");
    Scanner yn = new Scanner(System.in);
    String yesOrNo = yn.nextLine();
    yesOrNo.toLowerCase();
    if (yesOrNo.equals("yes"))
    {
      balance = 100;
      playGame();
    }
    else
      System.out.print("Goodbye!");
  }   
}*/