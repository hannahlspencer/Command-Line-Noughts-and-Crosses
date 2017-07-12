import java.util.Scanner;

public class XOUtils {
  public static Grids newGame = new Grids();
  private static int turns = 0;
  private static boolean player;
  private static boolean win;

  public static void toStart() {
	
	Scanner sc = new Scanner(System.in);
	String start = sc.nextLine();
    if (start.equals("x")) {
		  System.out.println("Crosses to start! Where would you like to place your first X?");
		  player = true;
		  System.out.println(newGame.toString());
	  } else if (start.equals("o")) {
		  System.out.println("Noughts to start! Where would you like to place your first O?");
		  player = false;
		  System.out.println(newGame.toString());
	  } else {
	    System.out.println("Please enter only an x or an o");
	    toStart();
	  }
  }
  
  public static void makeChoice() {
	  while (turns < 9 || win == false) {
	    boolean validated = false;
	    String choice = "";
	    while (validated == false) {
	      System.out.println("Please enter which column then which row, eg. 01");
	      Scanner sc = new Scanner(System.in);
	      choice = sc.nextLine();
	      validated = validateInput(choice);
	    }
	  
	    int col = Integer.parseInt(choice.substring(0,1));
	    int row = Integer.parseInt(choice.substring(1));
	
      if (!(newGame.board[col][row].equals(" "))) {
	      System.out.println("That square has already been filled!");
	    } else {
		  if (player == true) {
	       newGame.board[col][row] = "x";
		     win = checkforWin(col, row, "x");
		     if (win == true) {
			     break;
		     }
		     player = false;
		  } else {
			  newGame.board[col][row] = "o";
			  win = checkforWin(col, row, "o");
			if (win == true) {
			  break;
		  }
			player = true;
		}
    turns++;
		System.out.println(newGame.toString());
	  }
	}
	
	System.out.println("Game over!");
	
	  
  }
  
  public static boolean validateInput(String choice) {
    if (choice.length() != 2) {
	  System.out.println("Please enter a column then row number");
	  return false;
	}
	int col = 0;
	int row = 0;
	try {
	  col = Integer.parseInt(choice.substring(0,1));
	  row = Integer.parseInt(choice.substring(1));
	} catch (NumberFormatException e) {
	  System.out.println("Please use numbers 0-2");
	  return false;
	}
	if (col < 0 || col > 2 || row < 0 || row > 2) {
	  System.out.println("Column and row numbers should be between 0 and 2. Please enter again");
	  return false; 
	}
	
	return true;
  }
  
  public static boolean checkforWin(int col, int row, String xo) {
	 
	//checking for row win
	win = rowWin(col, row, xo);
	if (win == true) {
	  return win;
	}
	
	//checking for col win
	win = colWin(col, row, xo);
	if (win == true) {
	  return win;
	}
	
	//check for diagonal win
	if (col == row) {
	  win = leftDiagWin(col, row, xo);
	  if (win == true) {
	    return win;
	  }
	}
	
	if ((col == 2 && row == 0) || (col == 0 && row == 2)) {
	  win = rightDiagWin(col, row, xo);
	  if (win == true) {
	    return win;
	  }		
	}
	
	return win;
  }
  
  public static boolean rightDiagWin(int col, int row, String xo) {
    col = 2;
	row = 0;
	
	if (newGame.board[col][row].equals(xo)) {
	  if (newGame.board[col-1][row+1].equals(xo)) {
	    if (newGame.board[col-1][row+1].equals(xo)) {
		  System.out.println(newGame.toString());
		  System.out.println("You win! Well done!");
		  return true;		  
		}
	  }
	}
	return false;
  }
  
  public static boolean leftDiagWin(int col, int row, String xo) {
    col = 0;
	row = 0;
	if (newGame.board[col][row].equals(xo)) {
	  if (newGame.board[col+1][row+1].equals(xo)) {
		if (newGame.board[col+2][row+2].equals(xo)) {
		  System.out.println(newGame.toString());
		  System.out.println("You win! Well done!");
		  return true;
		}
	  }
	}
	return false;
  }
  
  public static boolean rowWin(int col, int row, String xo) {
	  col = 0;
	  String one = newGame.board[col][row];
	  String two = newGame.board[col+1][row];
	  String three = newGame.board[col+2][row];
	if (one.equals(xo) && two.equals(xo) && three.equals(xo)) {
			System.out.println(newGame.toString());
			System.out.println("You win! Well done!");
			return true;
	}
	 return false; 
  }
  
    public static boolean colWin(int col, int row, String xo) {
	  row = 0;
	if (newGame.board[col][row].equals(xo)) {
	  if (newGame.board[col][row+1].equals(xo)) {
		  if(newGame.board[col][row+2].equals(xo)) {
			System.out.println(newGame.toString());
			System.out.println("You win! Well done!");
			return true;
		  }
		  
	  }
	}
	 return false; 
  }
}
