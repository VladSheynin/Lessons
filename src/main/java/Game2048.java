import java.util.List;
import java.util.Random;

/**
 * Задание по разработке - класс SquareBoard
 *
 * @author Sheynin Vladislav
 */

public class Game2048 implements Game {

    GameHelper helper = new GameHelper();
    Board board;
    Random random = new Random();

    public Game2048(Board board) {
        this.board = board;
    }

    @Override
    public void init() {
    }

    @Override
    public boolean canMove() {
        return false;
    }

    @Override
    public void move(Direction direction) {
    }

    @Override
    public void addItem() {
    }

    @Override
    public Board getGameBoard() {
        return null;
    }

    @Override
    public boolean hasWin() {
        return false;
    }
}
