
import java.util.Random;

public class Game extends javax.swing.JFrame {

    /**
     * Command buttons. Used to move pieces on the board.
     */
    private javax.swing.JButton upButton;
    private javax.swing.JButton downButton;
    private javax.swing.JButton leftButton;
    private javax.swing.JButton rightButton;

    /**
     * Board. boardDisplay is a 2D array of the labels used to display the
     * elements on the board.
     */
    private Element[][] board;

    /**
     * Creates new form Main
     */
    public Game() {
        initComponents();
        newTurn();
    }

    private void initComponents() {

        upButton = new javax.swing.JButton();
        rightButton = new javax.swing.JButton();
        leftButton = new javax.swing.JButton();
        downButton = new javax.swing.JButton();
        board = new Element[4][4];

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        upButton.setText("Up");
        upButton.addActionListener((java.awt.event.ActionEvent evt) -> {
            upButtonActionPerformed(evt);
        });

        rightButton.setText("Right");
        rightButton.addActionListener((java.awt.event.ActionEvent evt) -> {
            rightButtonActionPerformed(evt);
        });

        leftButton.setText("Left");
        leftButton.addActionListener((java.awt.event.ActionEvent evt) -> {
            leftButtonActionPerformed(evt);
        });

        downButton.setText("Down");
        downButton.setToolTipText("");
        downButton.addActionListener((java.awt.event.ActionEvent evt) -> {
            downButtonActionPerformed(evt);
        });

        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                board[x][y] = new Element(0, new javax.swing.JLabel());
            }
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(board[0][0].getLabel())
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(board[1][0].getLabel())
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(board[2][0].getLabel())
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(board[3][0].getLabel()))
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(board[0][1].getLabel())
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(board[1][1].getLabel())
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(board[2][1].getLabel())
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(board[3][1].getLabel()))
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(board[0][2].getLabel())
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(board[1][2].getLabel())
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(board[2][2].getLabel())
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(board[3][2].getLabel()))
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(board[0][3].getLabel())
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(board[1][3].getLabel())
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(board[2][3].getLabel())
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(board[3][3].getLabel())))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(leftButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(downButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(upButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rightButton)
                        .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(upButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(rightButton)
                                                .addComponent(leftButton))
                                        .addGap(7, 7, 7)
                                        .addComponent(downButton))
                                .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(board[0][3].getLabel())
                                                .addComponent(board[1][3].getLabel())
                                                .addComponent(board[2][3].getLabel())
                                                .addComponent(board[3][3].getLabel()))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(board[0][2].getLabel())
                                                .addComponent(board[1][2].getLabel())
                                                .addComponent(board[2][2].getLabel())
                                                .addComponent(board[3][2].getLabel()))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(board[0][1].getLabel())
                                                .addComponent(board[1][1].getLabel())
                                                .addComponent(board[2][1].getLabel())
                                                .addComponent(board[3][1].getLabel()))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(board[0][0].getLabel())
                                                .addComponent(board[1][0].getLabel())
                                                .addComponent(board[2][0].getLabel())
                                                .addComponent(board[3][0].getLabel()))))
                        .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }

    private void newTurn() {
        Random random = new Random();
        int x;
        int y;
        do {
            x = random.nextInt(4);
            y = random.nextInt(4);
        } while (board[x][y].getElement() != 0);
        board[x][y].setElement((1 + random.nextInt(2)) * 2);
        for (x = 0; x < 4; x++) {
            for (y = 0; y < 4; y++) {
                board[x][y].updateLabel();
            }
        }
    }

    private void upButtonActionPerformed(java.awt.event.ActionEvent evt) {
        for (int x = 0; x < 4; x++) {
            for (int y = 3; y > -1; y--) {
                int tempY = y;
                while (tempY < 3 && (board[x][tempY + 1].getElement() == 0 || board[x][tempY].getElement() == board[x][tempY + 1].getElement())) {
                    board[x][tempY + 1].combine(board[x][tempY]);
                    tempY++;
                }
            }
        }
        newTurn();
    }

    private void downButtonActionPerformed(java.awt.event.ActionEvent evt) {
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                int tempY = y;
                while (tempY > 0 && (board[x][tempY - 1].getElement() == 0 || board[x][tempY].getElement() == board[x][tempY - 1].getElement())) {
                    board[x][tempY - 1].combine(board[x][tempY]);
                    tempY--;
                }
            }
        }
        newTurn();
    }

    private void leftButtonActionPerformed(java.awt.event.ActionEvent evt) {
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                int tempX = x;
                while (tempX > 0 && (board[tempX - 1][y].getElement() == 0 || board[tempX][y].getElement() == board[tempX - 1][y].getElement())) {
                    board[tempX - 1][y].combine(board[tempX][y]);
                    tempX--;
                }
            }
        }
        newTurn();
    }

    private void rightButtonActionPerformed(java.awt.event.ActionEvent evt) {
        for (int y = 0; y < 4; y++) {
            for (int x = 3; x > -1; x--) {
                int tempX = x;
                while (tempX < 3 && (board[tempX + 1][y].getElement() == 0 || board[tempX][y].getElement() == board[tempX + 1][y].getElement())) {
                    board[tempX + 1][y].combine(board[tempX][y]);
                    tempX++;
                }
            }
        }
        newTurn();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Game().setVisible(true);
        });
    }

}
