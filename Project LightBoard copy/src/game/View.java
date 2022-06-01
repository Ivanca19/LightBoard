package game;

import javax.swing.*;

public class View {

    private LightBoard _board;

    /*
    // Yes or No Option
	public static int yN(String msg, String title) {
		return JOptionPane.showOptionDialog(null, msg, title, JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, 0);
	}

	// Yes, No or Cancel Option
	public static int yNC(String msg, String title) {
		return JOptionPane.showOptionDialog(null, msg, title, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, 0);
	}

	// Custom Options
	// Note: Options can be String Arrays or
	// Image arrays or other things.
	public static int opt(Object[] options, String msg, String title) {
		return JOptionPane.showOptionDialog(null, msg, title, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, 0);
	}
     */

    public View(LightBoard iBoard) {
        _board = iBoard;
    }



    public String drawView() {

        String MAP = "";

        for(int r = 0; r < _board.getBoard().length; r++) {
            for (int c = 0; c < _board.getBoard()[r].length; c++) {
                if(_board.getBoard()[r][c] == true)
                    MAP += "  □  ";
                else
                    MAP += "  ■  ";
            }
            MAP += "\n";
        }

        return MAP;
    }

}
