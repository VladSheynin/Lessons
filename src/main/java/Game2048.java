import java.util.*;

import static java.util.Arrays.asList;

/**
 * Задание по разработке - класс SquareBoard
 *
 * @author Sheynin Vladislav
 */

public class Game2048 implements Game {

    public static final int GAME_SIZE = 4;
    private final Board<Key, Integer> board = new SquareBoard<>(GAME_SIZE);
    private final int percentForValue = 10;

    private final GameHelper helper = new GameHelper();
    private final Random random = new Random();

    public Game2048() {
        //this.init();
    }

    @Override
    public void init() {
        board.fillBoard(asList(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null));
        this.addItem();
        this.addItem();
    }

    /**
     * Добавляет новый элемент по ключу, проверяя что в поле ключа значение не равно null
     * в случае если null в цикле ищет следующее пока не найдет подходящее
     */
    @Override
    public void addItem() {
        Integer value = this.initValue();
        Key key = null;
        while (true) {
            key = this.newRandomKey();
            if (board.getValue(key) == null) {
                this.addItem(key, value);
                break;
            }
        }
    }

    @Override
    public void addItem(Key key, Integer value) {
        board.addItem(key, value);
    }

    /**
     * Метод возвращает 2 или 4. Вероятность выпадения 4 -10%, 2 - 90%
     * процент вероятности считается по меньшей величине и хранится в константе percentForValue
     *
     * @return значение для поля
     */
    private Integer initValue() {
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
        boolean hasStep = false;
        if (!board.availableSpace().isEmpty()) return true; // если есть хоть одна свободная ячейка - вернуть true
        //если все ячейки заполнены - проверить нет ли в строке или столбце двух рядом стоящих одинаковых значений
        for (int i = 0; i < board.getHeight(); i++) {
            if (checkDoubles(board.getValues(List.copyOf(board.getColumn(i))))) return true;
            if (checkDoubles(board.getValues(List.copyOf(board.getRow(i))))) return true;
        }
        return false;
    }

    /**
     * Проверка есть ли рядом стоящие дубли
     *
     * @param list - список значений
     * @return -true/false в зависимости есть или нет дубли
     */
    public boolean checkDoubles(List<Integer> list) {
        Iterator<Integer> iterator = list.iterator();
        Integer element1 = iterator.next();
        Integer element2 = null;
        while (iterator.hasNext()) {
            element2 = iterator.next();
            if (Objects.equals(element2, element1)) return true;
            element1 = element2;
        }
        return false;
    }

    /**
     * Обрабатывает нажатие кнопки Direction и проводит слияние методом moveAndMergeEqual
     *
     * @param direction - направление, нажата соответствующая кнопка
     */
    @Override
    public boolean move(Direction direction) {
        List<Key> keysForMerge = new ArrayList<>(); //список ключей для сопоставления ключ-значение при отправке и получении списка значений в метод moveAndMergeEqual
        List<Integer> valuesForMerge = new ArrayList<>(); //список значений для отправки в метод moveAndMergeEqual
        List<Integer> valuesForMergeResult = new ArrayList<>(); //список полученный из метода moveAndMergeEqual
        int count = 0;
        //if (board.availableSpace().isEmpty()) return false;
        if (!this.canMove())
            return false; //если место на доске закончилось и нет доступных ходов (например если последний ход и есть дубли - нужно делать еще один ход) вернуть false

        switch (direction) {
            case Direction.DOWN: //получить ключи по столбцу и преобразовать их в обратном порядке для перебора снизу вверх, затем отправить в метод moveAndMergeEqual, потом залить значения на доску
            {
                for (int i = 0; i < board.getHeight(); i++) {
                    keysForMerge = List.copyOf(board.getColumn(i));
                    keysForMerge = this.reverseKeys(keysForMerge);
                    valuesForMerge = board.getValues(keysForMerge);
                    valuesForMergeResult = helper.moveAndMergeEqual(valuesForMerge);
                    if (!valuesForMerge.equals(valuesForMergeResult)) { //проверяем сделан ли ход, если списки не равны - сделан
                        this.updateLine(keysForMerge, valuesForMergeResult);
                        count++;
                    }
                }
                break;
            }
            case Direction.UP: //получить ключи по столбцу, затем отправить в метод moveAndMergeEqual, потом залить значения на доску
            {
                for (int i = 0; i < board.getHeight(); i++) {
                    keysForMerge = List.copyOf(board.getColumn(i));
                    valuesForMerge = board.getValues(keysForMerge);
                    valuesForMergeResult = helper.moveAndMergeEqual(valuesForMerge);
                    if (!valuesForMerge.equals(valuesForMergeResult)) { //проверяем сделан ли ход, если списки не равны - сделан
                        this.updateLine(keysForMerge, valuesForMergeResult);
                        count++;
                    }
                }
                break;
            }
            case Direction.RIGHT: //получить ключи по строке и преобразовать их в обратном порядке ...
            {
                for (int i = 0; i < board.getWidth(); i++) {
                    keysForMerge = List.copyOf(board.getRow(i));
                    keysForMerge = this.reverseKeys(keysForMerge);
                    valuesForMerge = board.getValues(keysForMerge);
                    valuesForMergeResult = helper.moveAndMergeEqual(valuesForMerge);
                    if (!valuesForMerge.equals(valuesForMergeResult)) { //проверяем сделан ли ход, если списки не равны - сделан
                        this.updateLine(keysForMerge, valuesForMergeResult);
                        count++;
                    }
                }
                break;
            }
            case Direction.LEFT: //получить ключи по строке ...
            {
                for (int i = 0; i < board.getWidth(); i++) {
                    keysForMerge = List.copyOf(board.getRow(i));
                    valuesForMerge = board.getValues(keysForMerge);
                    valuesForMergeResult = helper.moveAndMergeEqual(valuesForMerge);
                    if (!valuesForMerge.equals(valuesForMergeResult)) { //проверяем сделан ли ход, если списки не равны - сделан
                        this.updateLine(keysForMerge, valuesForMergeResult);
                        count++;
                    }
                }
                break;
            }

        }

        if (count != 0) { //если были изменения на доске (ход сделан) вернуть true и добавить элемент на доску
            this.addItem();
            return true;
        }
        return canMove();
    }

    /**
     * Обновление доски по паре ключ/значение
     *
     * @param keys   - список ключей для обновления значений
     * @param values - список значений, соответствующих по порядку, ключу
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
        for (int i = keys.size() - 1; i >= 0; i--) {
            resultList.add(keys.get(i));
        }
        return resultList;
    }

    @Override
    public Board getGameBoard() {
        return board;
    }

    /**
     * Победой считается наличие хотя бы одного поля со значением 2048
     *
     * @return true если победа
     */
    @Override
    public boolean hasWin() {
        return board.hasValue(2048);
    }
}
