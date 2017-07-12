public class Grids {

  public static String[][] board = { {" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "} };

  @Override
  public String toString() {
	System.out.println("   0 1 2  ");
    System.out.println("0 |" + board[0][0] + "|" + board[1][0] + "|" + board[2][0] + "|");
    System.out.println("1 |" + board[0][1] + "|" + board[1][1] + "|" + board[2][1] + "|"); 
    System.out.println("2 |" + board[0][2] + "|" + board[1][2] + "|" + board[2][2] + "|");
	String x = "";
	return x;
  }
}
