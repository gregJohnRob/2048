import java.util.Scanner;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JLabel;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Game extends JFrame {

  Element[][] board = new Element[4][4];

  JPanel panel = new JPanel();
  JButton b = new JButton("Hello");
  JButton test = new JButton("test");

  public Game() {

    super("2048");

    setSize(600,600);
    setResizable(false);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }

  /*
   * The functions related to the move up command.
   * The canMoveUp checks that the element exists at the given location which can move up.
   * moveUp will move up an element
   * up is a loop which will check each column in turn to preform all valid moves
  */
  public boolean canMoveUp(int i, int j) {
    return i > 0 && i < 4
      && board[i][j] != null
      && (board[i-1][j] == null || board[i][j].canCombine(board[i-1][j]));
  }

  public void moveUp(int i, int j) {
    if (board[i-1][j] == null) {
      board[i-1][j] = board[i][j];
    } else {
      board[i-1][j].combine(board[i][j]);
    }
    board[i][j] = null;
  }

  public void up() {
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        int tempI = i;
        while (canMoveUp(tempI, j)) {
          moveUp(tempI, j);
          tempI--;
        }
      }
    }
  }

  /*
   * The functions related to move down command
  */
  public boolean canMoveDown(int i, int j) {
    return i < 3 && i > -1
      && board[i][j] != null
      && (board[i+1][j] == null || board[i][j].canCombine(board[i+1][j]));
  }

  public void moveDown(int i, int j) {
    if (board[i+1][j] == null) {
      board[i+1][j] = board[i][j];
    } else {
      board[i+1][j].combine(board[i][j]);
    }
    board[i][j] = null;
  }

  public void down() {
    for (int i = 3; i >= 0; i--) {
      for (int j = 3; j >= 0; j--) {
        int tempI = i;
        while (canMoveDown( tempI, j)) {
          moveDown(tempI, j);
          tempI++;
        }
      }
    }
  }


  /*
   * The functions related to move left command,
  */
  public boolean canMoveLeft(int i, int j) {
    return j > 0 && j < 4
    && board[i][j] != null
    && (board[i][j-1] == null || board[i][j].canCombine(board[i][j-1]));
  }

  public void moveLeft(int i, int j) {
    if (board[i][j-1] == null) {
      board[i][j-1] = board[i][j];
    } else {
      board[i][j-1].combine(board[i][j]);
    }
    board[i][j] = null;
  }

  public void left() {
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        int tempJ = j;
        while (canMoveLeft(i, tempJ)) {
          moveLeft(i, tempJ);
          tempJ--;
        }
      }
    }
  }

  /*
   * The functions related to move right command
  */
  public boolean canMoveRight( int i, int j) {
    return j < 3 && j > -1
    && board[i][j] != null
    && (board[i][j+1] == null || board[i][j].canCombine(board[i][j+1]));
  }

  public void moveRight( int i, int j) {
    if (board[i][j+1] == null) {
      board[i][j+1] = board[i][j];
    } else {
      board[i][j+1].combine(board[i][j]);
    }
    board[i][j] = null;

  }

  public void right() {
    for (int i = 3; i >= 0; i--) {
      for (int j = 3; j >= 0; j--) {
        int tempJ = j;
        while (canMoveRight( i, tempJ)) {
          moveRight( i, tempJ);
          tempJ++;
        }
      }
    }

  }


  public static void main(String args[]) {
    Game game = new Game();
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
      } while (game.board[x][y] != null);
      game.board[x][y] = new Element((1 + random.nextInt(2)) * 2);
      game.panel = new JPanel();
      game.panel.setLayout(new GridLayout(4, 4));
      for (int i = 0; i < 4; i++) {
        for (int j = 0; j < 4; j++) {
          if (game.board[i][j] != null) {
            game.panel.add(new JLabel((game.board[i][j].toString() + " ")));
          } else {
            game.panel.add(new JLabel(("0000 ")));
          }
        }
      }
      game.setContentPane(game.panel);
      game.setVisible(true);
      System.out.println("\n Your next move? ");
      move = user.next();
      move = move.toLowerCase();
      switch(move) {
        case "up":
          game.up();
          break;
        case "down":
          game.down();
          break;
        case "left":
          game.left();
          break;
        case "right":
          game.right();
          break;
        default:
          System.out.println("Invalid move");
          System.exit(0);
      }
    }

  }
}
