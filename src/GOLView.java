import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class GOLView extends JFrame {

    private boolean isRunning = false;
    private JButton startStopButton, resetButton;
    private JLabel rowsLabel, colsLabel;
    private JTextField rowsField, colsField;
    private JPanel optionsPanel;
    private Board board;

    public GOLView(){
        setLayout(new BorderLayout());
        setTitle("Conway's Game of Life");
        buildOptionsPanel();
        Board board = new Board();
        add(board, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        pack();
        setVisible(true);
    }

    private void buildOptionsPanel(){
        optionsPanel = new JPanel();
        optionsPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        optionsPanel.setBackground(Color.LIGHT_GRAY);
        optionsPanel.setPreferredSize(new Dimension());

        startStopButton = new JButton("Start");
        resetButton = new JButton("Reset");
        rowsLabel = new JLabel("Rows:");
        colsLabel = new JLabel("Columns:");
        rowsField = new JTextField(5);
        colsField = new JTextField(5);

        optionsPanel.add(startStopButton);
        optionsPanel.add(resetButton);
        optionsPanel.add(rowsLabel);
        optionsPanel.add(rowsField);
        optionsPanel.add(colsLabel);
        optionsPanel.add(colsField);

        optionsPanel.setPreferredSize(new Dimension(600,35));

        add(optionsPanel, BorderLayout.PAGE_START);
    }

    private class Board extends JPanel{
        public Board(){
            setPreferredSize(new Dimension(600,600));
            setBorder(BorderFactory.createLineBorder(Color.BLACK));
        }
    }
}
