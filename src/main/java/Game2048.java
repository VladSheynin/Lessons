import java.util.List;
import java.util.Random;

/**
 * Задание по разработке - класс SquareBoard
 *
 * @author Sheynin Vladislav
 */

public class Game2048 implements Game {

    public static final int GAME_SIZE = 4;
    private final Board<Key, Integer> board = new SquareBoard<>(GAME_SIZE);
    private final int percentForValue =10;

    GameHelper helper = new GameHelper();
    Random random = new Random();


    /*
    Board board;
    public Game2048(Board board) {
        this.board = board;
    }
    */

    public Game2048()
    {
        this.init();
    }

    @Override
    public void init() {
        Integer value = this.getValue();
        Key key = this.newRandomKey();
        this.addItem(key, value);

        value = this.getValue();
        key = this.newRandomKey();
        this.addItem(key, value);
    }

    /**
     * Метод возвращает 2 или 4. Вероятность выпадения 4 -10%, 2 - 90%
     * процент вероятности считается по меньшей величине и хранится в константе percentForValue
     *
     * @return значение для поля
     */
    private Integer getValue() {
        if (random.nextInt(1, 101) <= percentForValue) return 4;
        else return 2;
    }

    /**
     * Создает новый случайный ключ
     *
     * @return новый ключ
     */
    private Key newRandomKey()
    {
        int x, y;
        x= random.nextInt(4);
        y= random.nextInt(4);
        return new Key(x,y);
    }

    /**
     * Проверяем наличие свободных ячеек
     *
     * @return true если свободные ячейки есть
     */
    @Override
    public boolean canMove() {
        // если в board есть пустые ячейки
        if (!board.availableSpace().isEmpty())
            return true;
        else
            return false;
    }

    @Override
    public void move(Direction direction) {
    }

    @Override
    public void addItem(Key key, Integer value) {
        board.addItem(key,value);
        board.toString();
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
