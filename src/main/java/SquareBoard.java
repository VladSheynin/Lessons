import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Задание по разработке - класс SquareBoard
 *
 * @author Sheynin Vladislav
 */

public class SquareBoard<V> extends Board<Key, V> {

    public SquareBoard(int size) {
        super(size, size);
    }

    /**
     * Заполнение доски значениями из списка. Остаток добивается null-ами
     * вызов getWeiht используется для получения глубины доски (так как ширина и глубина одинаковые)
     *
     * @param list список значений для заполнения
     */
    @Override
    public void fillBoard(List<V> list) {
        board.clear();
        if (list.size() > (this.getWidth() * this.getWidth()))
            throw new RuntimeException("Ошибка инициализации приложения - слишком длинный список (больше размера доски)"); //run-time exceptions если входной список длиннее чем размер доски (квадрат ширины)
        int counter = 0;
        for (int i = 0; i < this.getWidth(); i++) {
            for (int j = 0; j < this.getWidth(); j++) {
                if (counter >= list.size()) board.put(new Key(i, j), null);
                else {
                    board.put(new Key(i, j), list.get(counter));
                    counter++;
                }
            }
        }
    }

    /**
     * Возвращает список свободных ячеек
     *
     * @return keys - список ключей значение элементов которых равно null
     */
    @Override
    public List<Key> availableSpace() {
        List<Key> keys = new ArrayList<Key>();
        for (Map.Entry<Key, V> item : board.entrySet()) {
            if (item.getValue() == null) keys.add(item.getKey());
        }
        return keys;
    }

    /**
     * Устанавливает значение по ключу Key
     *
     * @param key   - ключ для установки значения
     * @param value - устанавливаемое значение
     */
    @Override
    public void addItem(Key key, V value) {
        board.put(key, value);
    }

    /**
     * Ищем и возвращаем ключ Key из заполненного board у которого параметры i и j
     *
     * @param i - строка
     * @param j - столбец
     * @return ключ Key если такой найден или null если не найден
     */
    @Override
    public Key getKey(int i, int j) {
        for (Map.Entry<Key, V> item : board.entrySet()) {
            if (item.getKey().getI() == i && item.getKey().getJ() == j) return item.getKey();
        }
        return null; //возвращаем null сли ключа с такими параметрами нет
    }

    /**
     * Получение значения поля по ключу
     *
     * @param key - ключ для поиска
     * @return значение или null если такого ключа нет
     */
    @Override
    public V getValue(Key key) {
        if (board.get(key) == null)
            return null;
        else
            return board.get(key);
    }

    /**
     * Возврат всех ключей в столбце
     * вызов getWeiht используется для получения глубины доски (так как ширина и глубина одинаковые)
     *
     * @param j - столбец для поиска
     * @return список ключей по столбцу j
     */
    @Override
    public List<Key> getColumn(int j) {
        List<Key> resultColumns = new ArrayList<>();
        for (int i = 0; i < this.getWidth(); i++) {
            resultColumns.add(this.getKey(i, j));
        }
        return resultColumns;
    }

    /**
     * Возврат всех ключей в строке
     * вызов getWeiht используется для получения глубины доски (так как ширина и глубина одинаковые)
     *
     * @param i - строка для поиска
     * @return лист ключей из строки i
     */
    @Override
    public List<Key> getRow(int i) {
        List<Key> resultRows = new ArrayList<>();
        for (int j = 0; j < this.getWidth(); j++) {
            resultRows.add(this.getKey(i, j));
        }
        return resultRows;
    }

    /**
     * Возвращает true если в коллекции есть значение value
     *
     * @param value - значение, которое ищется
     * @return true/false
     */
    @Override
    public boolean hasValue(V value) {
        return board.containsValue(value);
    }

    /**
     * Возвращает список значений по списку ключей
     *
     * @param keys - список ключей
     * @return returnValue - список значений указанных ключей
     */
    @Override
    public List<V> getValues(List<Key> keys) {
        List<V> returnValues = new ArrayList<V>();
        for (Key item : keys) {
            returnValues.add(this.getValue(item));
        }
        return returnValues;
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < this.getWidth(); i++) {
            for (V element : this.getValues(getRow(i))) {
                str = str + element + "--";
            }
            str = str + "\n";
        }
        return str;
    }

}
