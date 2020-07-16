import javax.swing.*;
import java.awt.*;

public class GOLBoardView extends JPanel {
    int rows;
    int cols;
    private final int BOARD_WIDTH = 600;
    private final int BOARD_HEIGHT = 600;


    public GOLBoardView(int rows, int cols){
        this.rows = rows;
        this.cols = cols;
        setPreferredSize(new Dimension(BOARD_WIDTH,BOARD_HEIGHT));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    public void paintGrid(Graphics g){
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

    public void setGrid(int rows, int cols){
        this.rows = rows;
        this.cols = cols;
    }
}
