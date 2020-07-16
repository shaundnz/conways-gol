public class MVCGameOfLife {

    public static void main(String[] args){
        // Create model, views and controller
        GOLOptionView golOptionView = new GOLOptionView();
        GOLBoardView golBoardView = new GOLBoardView();
        GOLModel golModel = new GOLModel();

        // Connect model and views to controller
        GOLController golController = new GOLController(golOptionView, golBoardView, golModel);

        // Start the game
        GameOfLife gol = new GameOfLife(golOptionView, golBoardView);
    }
}
