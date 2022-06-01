package game;

public class LightBoard {

    private boolean[][] _board;

    public LightBoard(int row, int col) {
        _board = new boolean[row][col];
        turnOff();
    }

    public boolean[][] getBoard() { return _board;}

    public void turnOff() {
        for(int r = 0; r < _board.length; r++) {
            for (int c = 0; c < _board[r].length; c++) {
                _board[r][c] = false;
            }
        }
    }

    public void turnOn() {
        for(int r = 0; r < _board.length; r++) {
            for (int c = 0; c < _board[r].length; c++) {
                _board[r][c] = true;
            }
        }
    }

    public void turnRowOff(int row) {

        for(int r = row; r < row + 1; r++) {
            for (int c = 0; c < _board[r].length; c++) {
                _board[r][c] = false;
            }
        }
    }

    public void turnRowOn(int row) {
        for(int r = row; r < row + 1; r++) {
            for (int c = 0; c < _board[r].length; c++) {
                _board[r][c] = true;
            }
        }
    }

    public void turnColOff(int col) {
        for(int r = 0; r < _board.length; r++) {
            _board[r][col] = false;
        }
    }

    public void turnColOn(int col) {
        for(int r = 0; r < _board.length; r++) {
            _board[r][col] = true;
        }
    }

    public void turnGridOff(int sRow, int sCol, int eRow, int eCol) {
        for(int r = sRow; r <= eRow; r++) {
            for (int c = sCol; c <= eCol; c++) {
                _board[r][c] = false;
            }
        }
    }

    public void turnGridOn(int sRow, int sCol, int eRow, int eCol) {
        for(int r = sRow; r <= eRow; r++) {
            for (int c = sCol; c <= eCol; c++) {
                _board[r][c] = true;
            }
        }
    }

    public void randomize() {
        for(int r = 0; r < _board.length; r++) {
            for (int c = 0; c < _board[r].length; c++) {
                int sus = (int)(101 * Math.random());
                if(sus < 50)
                    _board[r][c] = true;
                else
                    _board[r][c] = false;
            }
        }
    }
}
