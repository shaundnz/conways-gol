import javax.swing.*;
import java.awt.event.*;

public class GOLController implements ActionListener {

    Timer timer = new Timer(100, this);
    private GOLOptionView golOptionView;
    private GOLBoardView golBoardView;
    private GOLModel golModel;


    public GOLController(GOLOptionView golOptionView, GOLBoardView golBoardView, GOLModel golModel) {
        this.golOptionView = golOptionView;
        this.golBoardView = golBoardView;
        this.golModel = golModel;
        this.golOptionView.addTextPanelListener(new TextPanelListener());
        this.golOptionView.addStartStopActionListener(new StartStopButtonActionListener());
        this.golOptionView.addResetActionListener(new ResetButtonActionListener());
        this.golBoardView.addMouseListener(new BoardMouseListener());
        this.golBoardView.addMouseMotionListener(new BoardMouseListener());
        timer.start();
    }

    // Update the board view every 100 milliseconds (0.1s)
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == timer) {
            if (golOptionView.getIsRunning()) {
                golModel.nextBoardState();
                golBoardView.updateBoardState(golModel.getBoardModel());
                golBoardView.repaint();
            }
        }
    }


    // Listens for changed to the colsField and rowsField
    class TextPanelListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            try {
                if (actionEvent.getSource() == golOptionView.getColsField()) {
                    int cols = Integer.parseInt(golOptionView.getColsField().getText());
                    if (cols < 1 || cols > 500){
                        throw new NumberFormatException();
                    }
                    golModel.setCols(cols);
                    golBoardView.updateColumns(cols);
                } else if (actionEvent.getSource() == golOptionView.getRowsField()) {
                    int rows = Integer.parseInt(golOptionView.getRowsField().getText());
                    if (rows < 1 || rows > 500){
                        throw new NumberFormatException();
                    }
                    golModel.setRows(rows);
                    golBoardView.updateRows(rows);
                }
            }
            catch (NumberFormatException e){
                golOptionView.displayErrorMessage("Invalid number entered");
            }
        }
    }

    class StartStopButtonActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if (golOptionView.getIsRunning()){
                golOptionView.getStartStopButton().setText("Start");
                golOptionView.enableButtons();
                golOptionView.setIsRunning(false);
            }
            else{
                golOptionView.getStartStopButton().setText("Stop");
                golOptionView.disableButtons();
                golOptionView.setIsRunning(true);
            }
        }
    }

    class ResetButtonActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            golModel.resetBoard();
            golBoardView.updateBoardState(golModel.getBoardModel());
            golBoardView.repaint();
        }
    }

    class BoardMouseListener extends MouseAdapter{
        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            int[] cell = convertXYToCell(e);
            // Swap between dead and alive on cell click
            golModel.setCell(cell[1], cell[0]);
            golBoardView.updateBoardState(golModel.getBoardModel());
            golBoardView.repaint();
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            super.mouseDragged(e);
            int[] cell = convertXYToCell(e);
            // Place cells with left click
            if (SwingUtilities.isLeftMouseButton(e)) {
                golModel.setCell(cell[1], cell[0], 1);
            }
            // Delete cells with right click
            else if (SwingUtilities.isRightMouseButton(e)){
                golModel.setCell(cell[1], cell[0], 0);
            }
            golBoardView.updateBoardState(golModel.getBoardModel());
            golBoardView.repaint();
        }

        private int[] convertXYToCell(MouseEvent e){
            int[] cell = new int[2];
            cell[0] = e.getX() * golModel.getRows() / GOLBoardView.BOARD_WIDTH;
            cell[1] = e.getY() * golModel.getCols() / GOLBoardView.BOARD_HEIGHT;
            return cell;
        }
    }

}
