import java.util.Scanner;
import java.util.Random;
public class Game {

  /*
   * The functions related to the move up command.
   * The canMoveUp checks that the element exists at the given location which can move up.
   * moveUp will move up an element
   * up is a loop which will check each column in turn to preform all valid moves
  */
  public static boolean canMoveUp(Element[][] board, int i, int j) {
    return i > 0
      && board[i][j] != null
      && (board[i-1][j] == null || board[i][j].canCombine(board[i-1][j]));
  }

  public static void moveUp(Element[][] board, int i, int j) {
    if (board[i-1][j] == null) {
      board[i-1][j] = board[i][j];
    } else {
      board[i-1][j].combine(board[i][j]);
    }
    board[i][j] = null;
  }

  public static void up(Element[][] board) {
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        int tempI = i;
        while (canMoveUp(board, tempI, j)) {
          moveUp(board, tempI, j);
          tempI--;
        }
      }
    }
  }

  /*
   * The functions related to move down command
  */
  public static boolean canMoveDown(Element[][] board, int i, int j) {
    return i < 3
      && board[i][j] != null
      && (board[i+1][j] == null || board[i][j].canCombine(board[i+1][j]));
  }

  public static void moveDown(Element[][] board, int i, int j) {
    if (board[i+1][j] == null) {
      board[i+1][j] = board[i][j];
    } else {
      board[i+1][j].combine(board[i][j]);
    }
    board[i][j] = null;
  }

  public static void down(Element[][] board) {
    for (int i = 3; i >= 0; i--) {
      for (int j = 3; j >= 0; j--) {
        int tempI = i;
        while (canMoveDown(board, tempI, j)) {
          moveDown(board, tempI, j);
          tempI++;
        }
      }
    }
  }


  /*
   * The functions related to move left command,
   * TODO: these functions
  */
  public static boolean canMoveLeft(Element[][] board, int i, int j) {
    return j > 0
    && board[i][j] != null
    && (board[i][j-1] == null || board[i][j].canCombine(board[i][j-1]));
  }

  public static void moveLeft(Element[][] board, int i, int j) {
    if (board[i][j-1] == null) {
      board[i][j-1] = board[i][j];
    } else {
      board[i][j-1].combine(board[i][j]);
    }
    board[i][j] = null;
  }

  public static void left(Element[][] board) {
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        int tempJ = j;
        while (canMoveLeft(board, i, tempJ)) {
          moveLeft(board, i, tempJ);
          tempJ--;
        }
      }
    }
  }

  /*
   * The functions related to move right command
   * TODO: these functions
  */
  public static boolean canMoveRight(Element[][] board, int i, int j) {
    return j < 3
    && board[i][j] != null
    && (board[i][j+1] == null || board[i][j].canCombine(board[i][j+1]));
  }

  public static void moveRight(Element[][] board, int i, int j) {
    if (board[i][j+1] == null) {
      board[i][j+1] = board[i][j];
    } else {
      board[i][j+1].combine(board[i][j]);
    }
    board[i][j] = null;

  }

  public static void right(Element[][] board) {
    for (int i = 3; i >= 0; i--) {
      for (int j = 3; j >= 0; j--) {
        int tempJ = j;
        while (canMoveRight(board, i, tempJ)) {
          moveRight(board, i, tempJ);
          tempJ--;
        }
      }
    }

  }

  public static void main(String args[]) {
    Element[][] board = new Element[4][4];
    Scanner user = new Scanner(System.in);
    Random random = new Random();
    int x;
    int y;
    String move;
    System.out.println("Type up, down, left or right to move the elements in the respective"
                          + "directions");
    while(true){
      do {
        x = random.nextInt(4);
        y = random.nextInt(4);
      } while (board[x][y] != null);
      board[x][y] = new Element((1 + random.nextInt(2)) * 2);
      for (int i = 0; i < 4; i++) {
        for (int j = 0; j < 4; j++) {
          if (board[i][j] != null) {
            System.out.print(board[i][j].toString() + " ");
          } else {
            System.out.print("0000 ");
          }
        }
        System.out.println("");
      }
      System.out.println("\n Your next move? ");
      move = user.next();
      move = move.toLowerCase();
      switch(move) {
        case "up":
          up(board);
          break;
        case "down":
          down(board);
          break;
        case "left":
          left(board);
          break;
        case "right":
          right(board);
          break;
        default:
          System.out.println("Invalid move");
          System.exit(0);
      }
    }

  }
}
