package game;

import javax.swing.*;

// My main class contains my main method and is the class that is run to run my program.
public class Main {
    
    // This method allows the user to choose how large they want to make their lightboard as long as it is within the parameters.
    public static void main(String[] args) {

        JOptionPane.showMessageDialog(null,"Welcome to my Light Board.");
        int x = 0;
        int iRow = 0;
        while( x == 0) {
            String pRow = JOptionPane.showInputDialog("Please choose how many rows you would like on your Light board. (Minimum is 6).");
            iRow = Integer.parseInt(pRow);
            if(iRow >= 6)
                x++;
        }
        x = 0;
        int iCol = 0;
        while( x == 0) {
            String pCol = JOptionPane.showInputDialog("Please choose how many columns you would like on your Light board. (Minimum is 6).");
            iCol = Integer.parseInt(pCol);
            if(iCol >= 6)
                x++;
        }

        x = 0;
        Overseer board = new Overseer(iRow, iCol);
        board.startBoard();
        while(x == 0) {
            if(board.menu() == false) {
                x++;
            }
        }

    }
}
