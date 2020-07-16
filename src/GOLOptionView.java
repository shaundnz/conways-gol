import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class GOLOptionView extends JPanel {

    private boolean isRunning = false;
    private JButton startStopButton, resetButton;
    private JLabel rowsLabel, colsLabel;
    private JTextField rowsField, colsField;


    public GOLOptionView(){
        buildOptionsPanel();
    }

    private void buildOptionsPanel(){
        setLayout(new FlowLayout(FlowLayout.LEFT));
        setBackground(Color.LIGHT_GRAY);
        setPreferredSize(new Dimension());

        startStopButton = new JButton("Start");
        resetButton = new JButton("Reset");
        rowsLabel = new JLabel("Rows:");
        colsLabel = new JLabel("Columns:");
        rowsField = new JTextField(5);
        colsField = new JTextField(5);

        add(startStopButton);
        add(resetButton);
        add(rowsLabel);
        add(rowsField);
        add(colsLabel);
        add(colsField);

        setPreferredSize(new Dimension(600,35));
    }

    public boolean getIsRunning() {
        return isRunning;
    }

    public void setIsRunning(boolean running){
        isRunning = running;
    }

}