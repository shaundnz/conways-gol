public class GOLModel {

    private int[][] boardModel;
    public static final int DEFAULTSIZE = 50;
    private int rows, cols;

    public GOLModel(){
        this.boardModel = new int[DEFAULTSIZE][DEFAULTSIZE];
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
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    // TODO Get next game board
    public int[][] boardState(){
        return null;
    }


}
