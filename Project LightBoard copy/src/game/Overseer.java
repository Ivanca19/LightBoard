package game;

import javax.swing.*;

// The Overseer class creates my Overseer which oversees the interaction between the User the view and the LightBoard.
public class Overseer {

    private LightBoard _board;
    private View _map;

    public Overseer(int row, int col) {
        _board = new LightBoard(row, col);
        _map = new View(_board);


    }

    public static int opt(Object[] options, String msg, String title) {
        return JOptionPane.showOptionDialog(null, msg, title, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, 0);
    }

    public static int yNC(String msg, String title) {
        return JOptionPane.showOptionDialog(null, msg, title, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, 0);
    }

    public static int yN(String msg, String title) {
        return JOptionPane.showOptionDialog(null, msg, title, JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, 0);
    }

    // The menu method essentially creates an interactive system where the user can directly interact with the Lightboard. The boolean will determine
    // if the user has desided to end the program.
    public boolean menu() {

        String[] options = {"Turn on/off", "Turn bulb on/off", "Turn Grid on/off", "Turn on/off row/col", "random", "exit"};
        String[] onOff = {"On", "Off", "Cancel"};
        String[] rCOptions = {"row", "col"};
        int x = -1;
        int opt = opt(options, getMap(), "What would you like to do? ");
        if(opt == 0) {
            x = opt(onOff, getMap(), "Would you like to turn on/off?");
            if(x == 0) {
                _board.turnOn();
            }
            else if(x == 1) {
                _board.turnOff();
            }
        }
        else if(opt == 1) {

            int sus = yN(getMap(), "On or off?");

            String row = JOptionPane.showInputDialog("Please choose row");
            int iSRow = Integer.parseInt(row) - 1;

            String col = JOptionPane.showInputDialog("Please choose col");
            int iSCol = Integer.parseInt(col) - 1 ;

            if(sus == 0){
                _board.getBoard()[iSRow][iSCol] = true;
            }
            else if(sus == 1) {
                _board.getBoard()[iSRow][iSCol] = false;
            }



        }
        else if(opt == 2){
            x = yN(getMap(), "Would you like to turn a grid on/off?");
            if(x == 0) {
                String sRow = JOptionPane.showInputDialog("Please choose start row");
                int iSRow = Integer.parseInt(sRow) - 1;
                String eRow = JOptionPane.showInputDialog("Please choose end row");
                int iERow = Integer.parseInt(eRow) - 1;
                String sCol = JOptionPane.showInputDialog("Please choose start col");
                int iSCol = Integer.parseInt(sCol) - 1 ;
                String eCol = JOptionPane.showInputDialog("Please choose end col");
                int iECol = Integer.parseInt(eCol) - 1;

                x = opt(onOff, getMap(), "Would you like to turn on/off?");
                if(x == 0)
                    _board.turnGridOn(iSRow, iSCol, iERow, iECol);

                else
                    _board.turnGridOff(iSRow, iSCol, iERow, iECol);
            }
        }
        else if(opt == 3) {
            x = yN(getMap(), "Are you sure?");
            if(x == 0) {

                int y = opt(rCOptions,getMap(), "Row or col?");
                String sRow = "";

                if(y==0) {
                    sRow = JOptionPane.showInputDialog("Please choose the row");
                }
                else if(y==1) {
                    sRow = JOptionPane.showInputDialog("Please choose the col");
                }
                int iSRow = Integer.parseInt(sRow) - 1;

                int z = opt(onOff, getMap(), "Would you like to turn on/off?");

                if((z == 0)&&(y == 0)) {
                    _board.turnRowOn(iSRow);
                }
                else if((z == 1)&&(y == 0)) {
                    _board.turnRowOff(iSRow);
                }
                else if((z == 0)&&(y == 1)) {
                    _board.turnColOn(iSRow);
                }
                else if((z == 1)&&(y == 1)) {
                    _board.turnColOff(iSRow);
                }
            }
        }
        else if(opt == 4) {
            x = yN(getMap(), "Would you like to Randomize?");
            if(x==0) {
                _board.randomize();
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Thank you. Goodbye :)");
            return false;
        }
        return true;
    }

    public String getMap(){
        return _map.drawView();
    }

    // This method generates a random number from 0 - 100
    public int Light() {
        int x = (int)(101 * Math.random());
        return x;
    }

    // This method will light up the board via lighting up each light where a light has a 40% chance of being lit.
    public void startBoard() {
        for(int r = 0; r < _board.getBoard().length ; r++) {
            for(int c = 0; c < _board.getBoard()[r].length ; c++) {

                if(Light() < 40)
                    _board.getBoard()[r][c] = true;

            }
        }
    }

}
