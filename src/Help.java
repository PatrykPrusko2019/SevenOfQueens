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
        if(row - 1 >= 0) {
            fillNegativeRows(); //supplements negative rows
        }

        if(row + 1 < chessBoardTemp.length) {// supplements positive rows
            fillPositiveRows();
        }
    }

    //get down diagonal
    private void fillPositiveRows() {
        for(int i = row + 1, counter = 1; i < chessBoardTemp.length; i++, counter++ ) {
            for(int j = column; j == column; j++) {
                if( checkTheValueIsEmpty(i, j + counter) ) {
                    chessBoardTemp[i][j+counter] = 1;
                }
                if( checkTheValueIsEmpty(i, j - counter) ) {
                    chessBoardTemp[i][j-counter] = 1;
                }
            }
        }
    }

    //get up diagonal
    private void fillNegativeRows() {
        for(int i = row - 1, counter = 1; i >= 0; i--, counter++) {
            for(int j = column; j == column; j++) {

                if( checkTheValueIsEmpty(i, j + counter) ) {
                    chessBoardTemp[i][j+counter] = 1;
                }

                if (checkTheValueIsEmpty(i, j - counter)) {
                    chessBoardTemp[i][j-counter] = 1;
                }

            }
        }
    }

    private void vertical() {
        for(int i = 0; i < chessBoardTemp.length; i++) { //rows
            for(int j = column; j == column; j++) {

                if(checkTheValueIsEmpty(i, j)) {
                    chessBoardTemp[i][j] = 1; //occupied field

                }
            }
        }
    }

    private void horizontally() { //poziomo
        for(int i = row; i == row; i++) {
            for(int j = 0; j < chessBoardTemp[i].length; j++) {

                if(checkTheValueIsEmpty(i, j) ) { //jak 0 to zamien na zajete pole
                    chessBoardTemp[i][j] = 1;
                }

            }
        }
    }

    private boolean checkTheValueIsEmpty(int i, int j) {
        if( (i >= 0 && j >= 0) && (i < chessBoardTemp.length && j < chessBoardTemp.length) ) {
            if (chessBoardTemp[i][j] == 0) {
                return true;
            }
        }
        return false;

    }

}
