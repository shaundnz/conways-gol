import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class GameOfLife extends JFrame {

    public GameOfLife(GOLOptionView golOptionView, GOLBoardView golBoardView){
        setLayout(new BorderLayout());
        setTitle("Conway's Game of Life");

        add(golOptionView, BorderLayout.PAGE_START);
        add(golBoardView, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        pack();
        setVisible(true);
    }
}




























