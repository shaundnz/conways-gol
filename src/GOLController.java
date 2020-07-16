import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GOLController implements ActionListener {

    Timer timer = new Timer(100, this);
    private GOLOptionView golOptionView;
    private GOLBoardView golBoardView;
    private GOLModel golModel;


    public GOLController(GOLOptionView golOptionView, GOLBoardView golBoardView,  GOLModel golModel){
        this.golOptionView = golOptionView;
        this.golBoardView = golBoardView;
        this.golModel = golModel;
        timer.start();
    }

    // Update the view every 100 milliseconds (0.1s)
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        int rows = golModel.getRows();
        int cols = golModel.getCols();
        golBoardView.setGrid(rows, cols);
        golBoardView.repaint();
    }

}
