import java.util.Random;
/**
 The program shows in 63 attempts how many times the Queen's figure can appear on the chessboard,
 so that none can capture another Queen's figure.

 Queen figure -> 8
 the area the queen can move in -> 1
 free fields -> 0

 Example of two pieces on a chessboard:

 8 1 1 1 1 1 1 1
 1 1 0 0 0 0 0 0
 1 0 1 0 0 0 0 0
 1 0 0 1 0 0 0 0
 1 0 0 0 1 0 0 0
 1 0 0 0 0 1 0 0
 1 0 0 0 0 0 1 0
 1 0 0 0 0 0 0 1

 The queen's field on the board is [0] [0] = 8.
 Number of fields the queen can move on -> 22

 next queen on the chessboard:

 8 1 1 1 1 1 1 1
 1 1 1 1 1 1 8 1
 1 0 1 0 0 1 1 1
 1 0 0 1 1 0 1 0
 1 0 0 1 1 0 1 0
 1 0 1 0 0 1 1 0
 1 1 0 0 0 0 1 0
 1 0 0 0 0 0 1 1


 The queen's field on the board is [1] [6] = 8.
 Number of fields the queen can move on -> 24

 It starts with a random field, and then searches according to the algorithm for
 the field that has the lowest number of moves for a given queen, e.g. 22 number.
 Then, every attempt attempts to select all boxes 1 or 8. e.g .:

 8 1 1 1 1 1 1 1
 1 1 1 1 8 1 1 1
 1 1 1 1 1 1 1 8
 1 1 1 1 1 1 1 1
 1 1 1 1 1 1 8 1
 1 1 8 1 1 1 1 1
 1 1 1 1 1 8 1 1
 1 8 1 1 1 1 1 1
 */
public class SevenOfQueens {

     private int[][] arrayOfBusyFields;
     private int[][] chessBoard;
     private int[][] queenJumpTest;
     private int row;
     private int column;
     private Random rand;
     private Help help;

    public SevenOfQueens() {
        this.arrayOfBusyFields = new int[8][8]; //number of moves
        this.chessBoard  = new int[8][8]; // chess board
        this.queenJumpTest = new int[8][8]; //tests for interfering with other queens on the board
        this.row = 0;
        this.column = 0;
        this.rand = new Random();
        this.help = new Help();
    }

    public int[][] getArrayOfBusyFields() {
        return arrayOfBusyFields;
    }

    public int[][] getChessBoard() {
        return chessBoard;
    }

    public int[][] getQueenJumpTest() {
        return queenJumpTest;
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

    public Help getHelp() {
        return help;
    }


    public static void main(String[] args) {

        SevenOfQueens startApp = new SevenOfQueens();

        startApp.beginsToSearchForTheRightFieldsForTheQueenFigure();
    }

    //start
    private void beginsToSearchForTheRightFieldsForTheQueenFigure() {
        System.out.println("welcome to the game eight queens :\n- number eight -> QUEEN" +
                "\n- number one -> FIELD OCCUPIED\n- number zero -> FREE FIELD ");

        int counterFinishGame = 1;
        //63 trials
        while(counterFinishGame < 64) {

            completeTheArrayOfBusyFields(); //sets the occupancy of the queen's fields again
            completingArrayWithZeros(getChessBoard());
            randomNumber();  //first queen assigned -> 1 at random

            startGameEightOfQueens(counterFinishGame);
            counterFinishGame++;
        }
    }

    //first jump of queen
    private void randomNumber() {
        int firstJumpOfTheQueen = rand.nextInt(64) + 1; //1-64 items on the board
        int counter = 1;
        for(int i = 0; i < getChessBoard().length; i++) {
            for(int j = 0; j < getChessBoard()[i].length; j++) {
                if(firstJumpOfTheQueen == counter) {
                    setRow(i);
                    setColumn(j);
                    getChessBoard()[i][j] = 8;
                }
                counter++;
            }
        }
    }

    //in sequence
    private int jumpFirst(int counterStartJump) {
        int count = 0;
        for(int i = 0; i < getChessBoard().length; i++) {
            for(int j = 0; j < getChessBoard().length; j++) {
                if(counterStartJump == count) {
                    setRow(i);
                    setColumn(j);
                    getChessBoard()[i][j] = 8;
                    return 0;
                }
                count++;
            }
        }
        return 1;
    }

    private void startGameEightOfQueens(int counterFinishGame) {
        boolean noExit = true;
        int counterJumpQueen = 0;

        while (noExit) {

            //next jump queen
                fillTheBusyFieldsInArray();
                fillTheZerosInArray();

                counterJumpQueen++;

            noExit = foundMinValueForQueenByJump(); //if true is the next queen, if false then quit !!!
        }

        showArray(getChessBoard(), counterFinishGame);
        System.out.println("\nthe queen's figure appears on the chessboard " + counterJumpQueen + " times -> " +
                "\nQUEEN -> 8" +
                "\nFIELD OCCUPIED -> 1" +
                "\nfinish !!!!");
    }

    //completes the fields that are occupied by Queen
    private void fillTheBusyFieldsInArray() {
        help.setChessBoardTemp(getChessBoard());
        help.setRow(getRow());
        help.setColumn(getColumn());
        help.fillTheBusyFieldsInArray();
    }

    //removes values ​​from the arrayOfBusyFields array where the field in the chessBoard is already occupied
     public void fillTheZerosInArray() {

        for(int i = 0; i < getChessBoard().length; i++){
            for(int j = 0; j < getChessBoard()[i].length; j++) {

                if(getChessBoard()[i][j] != 0) {
                    getArrayOfBusyFields()[i][j] = 0;
                }
            }
        }

    }

    //Search algorithm:
    //looking for the least busy queen on the given board / table
    private boolean foundMinValueForQueenByJump() {
        int minValue = 0;
        for(int i = 0; i < getArrayOfBusyFields().length; i++) {
            for(int j = 0; j < getArrayOfBusyFields()[i].length; j++) {

                switch ( getArrayOfBusyFields()[i][j] ) {
                    case 22: {
                        minValue = getArrayOfBusyFields()[i][j];
                        break;
                    }
                    case 24: {
                        minValue = getArrayOfBusyFields()[i][j];
                        if(! checkMinValue(minValue) ) {
                            minValue = 0;
                        }
                        break;
                    }
                    case 26: {
                        minValue = getArrayOfBusyFields()[i][j];
                        if(! checkMinValue(minValue) ) {
                            minValue = 0;
                        }
                        break;
                    }
                    case 28: {
                        minValue = getArrayOfBusyFields()[i][j];
                        if(! checkMinValue(minValue) ) {
                            minValue = 0;
                        }
                        break;
                    }
                }
                if(minValue != 0) {
                    if(checkIfYouCanSetTheQueenOnArray(i, j) ) {//first checks to see if it collides with another queen on the boardy
                        setRow(i); //next Queen field
                        setColumn(j);
                        getChessBoard()[i][j] = 8;
                        return true;
                    }
                }

            }
        }

            return false;

    }

    //checks to see if it's the queen's least occupation
    private boolean checkMinValue(int minValue) {
        for(int i = 0; i < getArrayOfBusyFields().length; i++) {
            for(int j = 0; j < getArrayOfBusyFields()[i].length; j++) {

                if( (minValue > getArrayOfBusyFields()[i][j]) && (getArrayOfBusyFields()[i][j] != 0) ) { //example: 24 > 22 && 22 != 0 -> true
                    return false; //there is even less value
                }
            }
        }
        return true;
    }

    private boolean checkIfYouCanSetTheQueenOnArray(int row, int column) {
        completingArrayWithZeros( getQueenJumpTest() );
        getQueenJumpTest()[row][column] = 8; //assign a test to the next queen field
        queenJumpTest = getHelp().fillTheBusyFieldsInArray(row, column, getQueenJumpTest()); //completes occupied fields with a given Queen's test positionn

        if( checkTheArrayToJump(row, column) ) {
            return true;
        } else {
            return false;
        }

    }

    //checks if the new Queen's test item is appropriate
    private boolean checkTheArrayToJump(int rowJumpQueenNext, int columnJumpQueenNext) {
        if( (chessBoard[rowJumpQueenNext][columnJumpQueenNext] == 1) || (chessBoard[rowJumpQueenNext][columnJumpQueenNext] == 8) ) {
            return false;
        }
        return true;
    }

    //resets the game boards
    private void completingArrayWithZeros(int[][] chessBoard) {
        for(int i = 0; i < chessBoard.length; i++) {
            for(int j = 0; j < chessBoard[i].length; j++) {
                chessBoard[i][j] = 0;
            }
        }
    }

    public void showArray(int[][] tab, int counterJumpQueen) {

        System.out.println("********************************");
        System.out.println("TRIAL: " + counterJumpQueen);
        for(int i = 0; i < tab.length; i++) {
            for(int j = 0; j < tab[i].length; j++) {
                System.out.printf("%4d", tab[i][j]);
            }
            System.out.println();
        }

    }

    //specified how many possible fields a given queen has to use from a given field on the board
    private void completeTheArrayOfBusyFields() {

        for(int i = 0; i < getArrayOfBusyFields().length; i++) {
            switch (i) {
                case 0: case 7: {
                    getArrayOfBusyFields()[i] = new int[] {22, 22, 22, 22, 22, 22, 22, 22};
                    break;
                }
                case 1: case 6: {
                    getArrayOfBusyFields()[i] = new int[] {22, 24, 24, 24, 24, 24, 24, 22};
                    break;
                }
                case 2: case 5: {
                    getArrayOfBusyFields()[i] = new int[] {22, 24, 26, 26, 26, 26, 24, 22};
                    break;
                }
                case 3: case 4: {
                    getArrayOfBusyFields()[i] = new int[] {22, 24, 26, 28, 28, 26, 24, 22};
                    break;
                }

            }
        }

    }

}
