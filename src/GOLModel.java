import java.util.Arrays;

public class GOLModel {

    private int[][] boardModel;
    public static final int DEFAULTSIZE = 50;
    private int rows, cols;

    public GOLModel(){
        this.boardModel = new int[DEFAULTSIZE][DEFAULTSIZE];
        this.rows = DEFAULTSIZE;
        this.cols = DEFAULTSIZE;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public int[][] getBoardModel() {
        return boardModel;
    }

    public void setCols(int cols) {
        this.cols = cols;
        resetBoard(rows, cols);
    }

    public void setRows(int rows) {
        this.rows = rows;
        resetBoard(rows, cols);
    }

    public void setCell(int i, int j){
        if (boardModel[i][j] == 1){
            boardModel[i][j] = 0;
        }
        else {
            boardModel[i][j] = 1;
        }
    }

    public void setCell(int i, int j, int newValue){
        boardModel[i][j] = newValue;
    }

    public void resetBoard(){
        boardModel = new int[rows][cols];
    }

    public void resetBoard(int rows, int cols){
        boardModel = new int[rows][cols];
    }

    // TODO Get next game board
    public void nextBoardState(){
        int[][] nextBoard = new int[cols][rows];
        for (int i = 0; i < rows; i ++){
            for (int j = 0; j < cols; j ++){
                nextBoard[i][j] = nextCellState(i, j);
            }
        }
        boardModel = nextBoard;
    }

    private int nextCellState(int i, int j){
        int aliveNeighbours = 0;
        int cellValue = boardModel[i][j];

        for (int iCord = -1; iCord < 2; iCord++){
            for (int jCord = -1; jCord < 2; jCord ++){
                aliveNeighbours += boardModel[modulus(i + iCord, cols )][modulus(j + jCord, cols)];
            }
        }

        aliveNeighbours = aliveNeighbours - cellValue;

        if (cellValue == 1){
            if (aliveNeighbours < 2){
                return 0;
            }
            else if (aliveNeighbours == 2 || aliveNeighbours == 3) {
                return 1;
            }
            else {
                return 0;
            }
        }
        else {
            if (aliveNeighbours == 3){
                return 1;
            }
        }
        return 0;
    }

    private int modulus(int a, int b){
        return ((a % b + b) % b);
    }

}
