import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;

public class GOLOptionView extends JPanel {

    private boolean isRunning = false;
    private JButton startStopButton, resetButton;
    private JLabel rowsLabel, colsLabel;
    private JTextField rowsField, colsField;


    public GOLOptionView(){
        buildOptionsPanel();
    }

    private void buildOptionsPanel(){
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
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

        setPreferredSize(new Dimension(GOLBoardView.BOARD_WIDTH,35));
    }

    public boolean getIsRunning() {
        return isRunning;
    }

    public void setIsRunning(boolean running){
        isRunning = running;
    }

    public void addTextPanelListener(ActionListener listenForTextPanel){
        rowsField.addActionListener(listenForTextPanel);
        colsField.addActionListener(listenForTextPanel);
    }

    public void addStartStopActionListener(ActionListener actionListener){
        startStopButton.addActionListener(actionListener);
    }

    public void addResetActionListener(ActionListener actionListener){
        resetButton.addActionListener(actionListener);
    }

    public void displayErrorMessage(String message){
        JOptionPane.showMessageDialog(this, message);
    }

    public JTextField getRowsField(){
        return rowsField;
    }

    public JTextField getColsField(){
        return colsField;
    }

    public JButton getStartStopButton(){
        return startStopButton;
    }

    public JButton getResetButton(){
        return resetButton;
    }

    public void disableButtons(){
        resetButton.setEnabled(false);
        colsField.setEnabled(false);
        rowsField.setEnabled(false);
    }

    public void enableButtons(){
        resetButton.setEnabled(true);
        colsField.setEnabled(true);
        rowsField.setEnabled(true);
    }
}