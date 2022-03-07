/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sssn
 */
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class Gui {
    

    private JFrame frame;
    private JLabel[][] slots;
    private JButton[] buttons;
    //variables used in grid
    private int xsize = 6;
    private int ysize = 5;
    private int currentPlayer = 1;
    //game variables 
    private boolean hasWon = false;
    private boolean hasDraw = false;
    private boolean quit = false;
    private boolean newGame = false;
    //making of grid and logic
    Grid my_grid = new Grid();
    Logic my_logic = new Logic(my_grid); // game logic

    public Gui() {

        frame = new JFrame("connect four");

        JPanel panel = (JPanel) frame.getContentPane();
        panel.setLayout(new GridLayout(xsize, ysize + 1));

        slots = new JLabel[xsize][ysize];
        buttons = new JButton[xsize];

        for (int i = 0; i < xsize; i++) {
            buttons[i] = new JButton("" + (i + 1));
            buttons[i].setActionCommand("" + i);
            buttons[i].addActionListener(
                    new ActionListener() {

                        public void actionPerformed(ActionEvent e) {
                            int a = Integer.parseInt(e.getActionCommand());
                            int y = my_grid.find_y(a);//check for space in collumn
                            if (y != -1) {
                                //sets a place to current player
                                if (my_logic.set_and_check(a, y, currentPlayer)) {
                                    hasWon = true;
                                } else if (my_logic.draw_game()) {
                                    hasDraw = true;
                                } else {
                                    //change player
                                    currentPlayer = my_grid.changeplayer(currentPlayer, 2);
                                    frame.setTitle("connect four - player " + currentPlayer + "'s turn");
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "choose another one", "column is filled", JOptionPane.INFORMATION_MESSAGE);
                            }
                        }
                    });
           // buttons[i].setActionCommand("" + i);
          
            panel.add(buttons[i]);
        
                    }
        for (int column = 0; column < ysize; column++) {
            for (int row = 0; row < xsize; row++) {
                slots[row][column] = new JLabel();
                //slots[row][column].setHorizontalAlignment(SwingConstants.CENTER);
                slots[row][column].setBorder(new LineBorder(Color.RED));
                panel.add(slots[row][column]);
            }
        }

        //jframe stuff
        frame.setContentPane(panel);
        frame.setSize(600, 500);
        frame.setVisible(true);
       //frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void updateBoard() {//COLOUR SET KORA
        for (int row = 0; row < xsize; row++) {
            for (int column = 0; column < ysize; column++) {
                if (my_grid.matrix_equals(row, column, 1)) {
                   slots[row][column].setOpaque(true);
                    slots[row][column].setBackground(Color.BLACK);
                }
                if (my_grid.matrix_equals(row, column, 2)) {
                    slots[row][column].setOpaque(true);
                    slots[row][column].setBackground(Color.GREEN);
                }
            }
        }
    }
//GAME ENDS MESSAGE
    public void showWon() {
        String winner = "player " + currentPlayer + " wins";
        int n = JOptionPane.showConfirmDialog(
                frame,
                "new game?",
                winner,
                JOptionPane.YES_NO_OPTION);
        if (n < 1) {
            frame.dispose();
            newGame = true;
        } else {
            frame.dispose();
            quit = true;
        }
       
    }

    public void showDraw() {
        String winner = "draw game";
        int n = JOptionPane.showConfirmDialog(
                frame,
                "new game?",
                winner,
                JOptionPane.YES_NO_OPTION);
         if (n < 1) {
            frame.dispose();
            newGame = true;
        } else {
            frame.dispose();
            quit = true;
        }
       
    }

    public boolean getHasWon() {
        return hasWon;
    }

    public boolean getHasDraw() {
        return hasDraw;
    }

    public boolean getQuit() {
        return quit;
    }

    public boolean getNewGame() {
        return newGame;
    }


    
  
    public static void main(String[] args) {
         Gui Gui = new Gui();
        // Connect4 c =new Connect4();
         //Gui.setVisible(false);
         //c.setVisible(true);
         
    }

    void setVisible(boolean b) {
        b = false;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
                    }

