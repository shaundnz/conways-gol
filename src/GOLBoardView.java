import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class GOLBoardView extends JPanel {
    int rows;
    int cols;
    int[][] boardState;
    public static final int BOARD_WIDTH = 800;
    public static final int BOARD_HEIGHT = 600;


    public GOLBoardView(){
        this.rows = GOLModel.DEFAULTSIZE;
        this.cols = GOLModel.DEFAULTSIZE;
        this.boardState = new int[rows][cols];
        setPreferredSize(new Dimension(BOARD_WIDTH,BOARD_HEIGHT));
        setBorder(BorderFactory.createLineBorder(Color.lightGray));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        paintGrid(g);
        paintCells(g);
    }

    private void paintGrid(Graphics g){
        g.setColor(Color.lightGray);
        // Paint rows
        int rowHeight = BOARD_HEIGHT / rows;
        int yRow = rowHeight;
        for (int r = 0; r < rows - 1; r ++){
            g.drawLine(0, yRow, BOARD_WIDTH, yRow);
            yRow += rowHeight;
        }
        // Paint cols
        int colWidth = BOARD_WIDTH / cols;
        int xCol = colWidth;
        for (int c = 0; c < cols - 1; c ++){
            g.drawLine(xCol, 0, xCol, BOARD_HEIGHT);
            xCol += colWidth;
        }
    }

    private void paintCells(Graphics g){
        int cellWidth = BOARD_WIDTH / cols;
        int cellHeight = BOARD_HEIGHT / rows;
        g.setColor(Color.YELLOW);
        for (int i = 0; i < rows; i ++){
            for(int j = 0; j < cols; j ++){
                if(boardState[i][j] == 1) {
                    g.fillRect(cellWidth * j, cellHeight * i, cellWidth, cellHeight);
                }
            }
        }
    }

    public void updateColumns(int cols){
        this.cols = cols;
    }

    public void updateRows(int rows){
        this.rows = rows;
    }

    public void updateBoardState(int[][] newBoardState){
        this.boardState = newBoardState;
    }

}
