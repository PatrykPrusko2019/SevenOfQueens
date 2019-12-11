public class Help {

        private int[][] chessBoardTemp;
        private int row;
        private int column;

    public Help() {
        this.chessBoardTemp = new int[8][8];
    }

    public int[][] getChessBoardTemp() {
        return chessBoardTemp;
    }
    public void setChessBoardTemp(int[][] chessBoardTemp) {
        this.chessBoardTemp = chessBoardTemp;
    }
    public int getRow() {
        return row;
    }
    public void setRow(int row) {
        this.row = row;
    }
    public int getColumn() {
        return column;
    }
    public void setColumn(int column) {
        this.column = column;
    }

    //completes the fields occupied by the queen, horizontally, vertically, diagonally
    public int[][] fillTheBusyFieldsInArray(int rows, int columns, int[][] queenJumpTest) {
        setRow(rows);
        setColumn(columns);
        setChessBoardTemp(queenJumpTest);

        horizontally();
        vertical();
        diagonal();

        queenJumpTest = getChessBoardTemp();

        return queenJumpTest;
    }

    public void fillTheBusyFieldsInArray() {

        horizontally();
        vertical();
        diagonal();
    }

    private void diagonal() {
        if(getRow() - 1 >= 0) {
            fillNegativeRows(); //supplements negative rows
        }

        if(getRow() + 1 < getChessBoardTemp().length) {// supplements positive rows
            fillPositiveRows();
        }
    }

    //get down diagonal
    private void fillPositiveRows() {
        for(int i = getRow() + 1, counter = 1; i < getChessBoardTemp().length; i++, counter++ ) {
            for(int j = getColumn(); j == getColumn(); j++) {
                if( checkTheValueIsEmpty(i, j + counter) ) {
                    getChessBoardTemp()[i][j+counter] = 1;
                }
                if( checkTheValueIsEmpty(i, j - counter) ) {
                    getChessBoardTemp()[i][j-counter] = 1;
                }
            }
        }
    }

    //get up diagonal
    private void fillNegativeRows() {
        for(int i = getRow() - 1, counter = 1; i >= 0; i--, counter++) {
            for(int j = getColumn(); j == getColumn(); j++) {

                if( checkTheValueIsEmpty(i, j + counter) ) {
                    getChessBoardTemp()[i][j+counter] = 1;
                }

                if (checkTheValueIsEmpty(i, j - counter)) {
                    getChessBoardTemp()[i][j-counter] = 1;
                }

            }
        }
    }

    private void vertical() {
        for(int i = 0; i < getChessBoardTemp().length; i++) { //rows
            for(int j = getColumn(); j == getColumn(); j++) {

                if(checkTheValueIsEmpty(i, j)) {
                    getChessBoardTemp()[i][j] = 1; //occupied field

                }
            }
        }
    }

    private void horizontally() { //poziomo
        for(int i = getRow(); i == getRow(); i++) {
            for(int j = 0; j < getChessBoardTemp()[i].length; j++) {

                if(checkTheValueIsEmpty(i, j) ) { //jak 0 to zamien na zajete pole
                    getChessBoardTemp()[i][j] = 1;
                }

            }
        }
    }

    private boolean checkTheValueIsEmpty(int i, int j) {
        if( (i >= 0 && j >= 0) && (i < getChessBoardTemp().length && j < getChessBoardTemp().length) ) {
            if (getChessBoardTemp()[i][j] == 0) {
                return true;
            }
        }
        return false;

    }

}
