/**
 * Задание по разработке - интерфейс Game
 *
 * @author Sheynin Vladislav
 */

public interface Game {

    void init();

    boolean canMove();

    boolean move(Direction direction);

    void addItem(Key key, Integer value);

    Board getGameBoard();

    boolean hasWin();
}
