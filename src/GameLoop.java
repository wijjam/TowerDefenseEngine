import javax.swing.*;

public class GameLoop {

    LogicController logicController;
    GameBoard gameBoard;

    public GameLoop(LogicController logicController, GameBoard gameBoard) {
        this.logicController = logicController;
        this.gameBoard = gameBoard;
    }

    public void start() {
        Timer timer = new Timer(25, e -> {
            logicController.updateGame();
            gameBoard.repaint();
        });
        timer.start();
    }
}
