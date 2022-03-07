/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sssn
 */
public class Connect4 {
   // public static void main(String[] args)
    //int state = 0;
        //boolean useGui = true;

  // public  void check()
  public static void main (String[] args){
        int state = 0;
        boolean useGui = true;

        if (useGui) {
            Gui Gui = new Gui();
            while (state != -1) {//COLUNM SHS NKI
                switch (state) {
                    case 0:
                        Gui.updateBoard();
                        if (Gui.getHasWon()) {
                            state = 1;
                        } else if (Gui.getHasDraw()) {
                            state = 2;
                        } else if (Gui.getNewGame()) {
                            Gui = new Gui();
                            state = 0;
                        }
                        break;
                    case 1://endgame 
                        Gui.showWon();
                        if (Gui.getQuit()) {
                            state = -1;
                        } else  if (Gui.getNewGame()) {
                            Gui = new Gui();
                            state = 0;
                        }
                        break;
                    case 2:
                        Gui.showDraw();
                        if (Gui.getQuit()) {
                            state = -1;
                        } else if (Gui.getNewGame()) {
                            Gui = new Gui();
                            state = 0;
                        }
                        break;
                }
            }
        } else {
            Cli Cli = new Cli();
            while (state != -1) {//checks  quitting stage
                switch (state) {
                    case 0:
                        Cli.runtime();
                        if (Cli.getHasWon()) {
                            state = 1;
                        } else if (Cli.getHasDraw()) {
                            state = 2;
                        }
                        break;
                    case 1://prints endgame with winner
                        Cli.showWin();
                        if (Cli.getQuit()) {
                            state = -1;
                        } else if (Cli.getNewGame()) {
                            Cli = new Cli();
                            state = 0;
                        }
                        break;
                    case 2:// end game eith draw game
                        Cli.showDraw();
                        if (Cli.getQuit()) {
                            state = -1;
                        } else if (Cli.getNewGame()) {
                            Cli = new Cli();
                            state = 0;
                        }
                        break;
                }
            }
        }
    }
/*public static void main(String[] args)
{
    new Connect4();
}*/
    void setVisible(boolean b) {
        b = false; //To change body of generated methods, choose Tools | Templates.
    }
}
