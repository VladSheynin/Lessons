import java.util.ArrayList;
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
    private final int percentForValue = 10;

    GameHelper helper = new GameHelper();
    Random random = new Random();


    /*
    Board board;
    public Game2048(Board board) {
        this.board = board;
    }
    */

    public Game2048() {
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
    private Key newRandomKey() {
        int x, y;
        x = random.nextInt(4);
        y = random.nextInt(4);
        return new Key(x, y);
    }

    /**
     * Проверяем наличие свободных ячеек по всей доске
     *
     * @return true если свободные ячейки есть
     */
    @Override
    public boolean canMove() {
        // если в board есть пустые ячейки
        if (!board.availableSpace().isEmpty()) return true;
        else return false;
    }

    /**
     * Обрабатывает нажатие кнопки Direction и проводит слияние методом moveAndMergeEqual
     *
     * @param direction - направление, нажата соответствующая кнопка
     */
    @Override
    public void move(Direction direction) {
        List<Key> keysForMerge = new ArrayList<>(); //список ключей для сопоставления ключ-значение при отправке и получении списка значений в метод moveAndMergeEqual
        List<Integer> valuesForMerge = new ArrayList<>(); //список значений для отправки в метод moveAndMergeEqual
        switch (direction) {
            case Direction.UP: //получить ключи по столбцу и преобразовать их в обратном порядке для перебора снизу вверх, затем отправить в метод moveAndMergeEqual, потом залить значения на доску
            {
                for (int i = 0; i < board.getHeight(); i++) {
                    keysForMerge = List.copyOf(board.getColumn(i));
                    keysForMerge = this.reverseKeys(keysForMerge);
                    valuesForMerge = board.getValues(keysForMerge);
                    valuesForMerge = helper.moveAndMergeEqual(valuesForMerge);
                    this.updateLine(keysForMerge, valuesForMerge);
                }
            }
            case Direction.DOWN: {//получить ключи по столбцу, затем отправить в метод moveAndMergeEqual, потом залить значения на доску
                for (int i = 0; i < board.getHeight(); i++) {
                    keysForMerge = List.copyOf(board.getColumn(i));
                    valuesForMerge = board.getValues(keysForMerge);
                    valuesForMerge = helper.moveAndMergeEqual(valuesForMerge);
                    this.updateLine(keysForMerge, valuesForMerge);
                }
            }
            case Direction.LEFT: {//получить ключи по строке и преобразовать их в обратном порядке ...
                for (int i = 0; i < board.getWidth(); i++) {
                    keysForMerge = List.copyOf(board.getRow(i));
                    keysForMerge = this.reverseKeys(keysForMerge);
                    valuesForMerge = board.getValues(keysForMerge);
                    valuesForMerge = helper.moveAndMergeEqual(valuesForMerge);
                    this.updateLine(keysForMerge, valuesForMerge);
                }
            }
            case Direction.RIGHT: {//получить ключи по строке ...
                for (int i = 0; i < board.getWidth(); i++) {
                    keysForMerge = List.copyOf(board.getRow(i));
                    valuesForMerge = board.getValues(keysForMerge);
                    valuesForMerge = helper.moveAndMergeEqual(valuesForMerge);
                    this.updateLine(keysForMerge, valuesForMerge);
                }
            }
        }
    }

    /**
     * Обновление доски по паре ключ/значение
     *
     * @param keys
     * @param values
     */
    private void updateLine(List<Key> keys, List<Integer> values) {
        int i = 0;
        for (Key key : keys) {
            board.addItem(key, values.get(i));
            i++;
        }
    }

    /**
     * Метод реверсирует список ключей (когда направление обхода меняется, например, склевать нужно снизу вверх)
     *
     * @param keys список исходных ключей
     * @return список ключей в обратном порядке
     */
    private List<Key> reverseKeys(List<Key> keys) {
        List<Key> resultList = new ArrayList<>();
        for (int i = keys.size() - 1; i < 0; i++) {
            resultList.add(keys.get(i));
        }
        return resultList;
    }

    @Override
    public void addItem(Key key, Integer value) {
        board.addItem(key, value);
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
