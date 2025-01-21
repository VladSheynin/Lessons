import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Задание по разработке - класс SquareBoard
 * @author Sheynin Vladislav
 */

public class SquareBoard extends Board {

int size;

public SquareBoard(int size){
    super(size,size);
    this.size=size;}

    /**Заполнение доски значениями из списка. Остаток добивается null-ами
     * @param list список значений для заполнения
     */
    @Override
    public void fillBoard(List<Integer> list) {
        board.clear();
        int counter = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (counter >= list.size())
                    board.put(new Key(i, j), null);
                else
                {
                    board.put(new Key(i, j), list.get(counter));
                    counter++;
                }
            }
        }
    }

    /** Возвращает список свободных ячеек
     * @return keys - список ключей значение элементов которых равно null
     */
    @Override
    public List<Key> availableSpace() {
        List<Key> keys = new ArrayList<Key>();
        for(Map.Entry<Key, Integer> item : board.entrySet())
        {
            if (item.getValue()==null) keys.add(item.getKey());
        }
        return keys;
    }

    /** Устанавливает значение по ключу Key
     * @param key
     * @param value
     */
    @Override
    public void addItem(Key key, Integer value) {
        board.put(key,value);
    }

    /**Ищем и возвращаем ключ Key из заполненного board у которого параметры i и j
     * @param i
     * @param j
     * @return ключ Key если такой найден или null если не найден
     */
    @Override
    public Key getKey(int i, int j) {
        for(Map.Entry<Key, Integer> item : board.entrySet())
        {
            if (item.getKey().getI()==i&&item.getKey().getJ()==j)
                return item.getKey();
        }
        return null; //возвращаем null сли ключа с такими параметрами нет
    }

    /** Получение значения поля по ключу
     * @param key - ключ для поиска
     * @return значение или null если такого ключа нет
     */
    @Override
    public Integer getValue(Key key) {
        if (board.get(key)==null)
            return null;
        else
            return board.get(key);
    }

    /**Значения в столбце
     * @param j - столбец для поиска
     * @return список ключей по столбцу j
     */
    @Override
    public List<Key> getColumn(int j) {
        List<Key> resultColumns = new ArrayList<>();
        for(int i=0;i<size;i++)
        {
            resultColumns.add(this.getKey(i,j));
        }
        return resultColumns;
    }

    /**Значения в строке
     * @param i - строка для поиска
     * @return лист ключей из строки i
     */
    @Override
    public List<Key> getRow(int i) {
        List<Key> resultRows = new ArrayList<>();
        for(int j=0;j<size;j++)
        {
            resultRows.add(this.getKey(i,j));
        }
        return resultRows;
    }

    /** Возвращает true если в коллекции есть значение value
     * @param value
     * @return true/false
     */
    @Override
    public boolean hasValue(Integer value) {
        return board.containsValue(value);
    }

    /** Возвращает список значений по списку ключей
     * @param keys - список ключей
     * @return returnValue - список значений указанных ключей
     */
    @Override
    public List<Integer> getValues(List<Key> keys) {
        List<Integer> returnValues = new ArrayList<Integer>();
        for (Key item:keys)
        {   //Ошибка выдается если ключ не найден, в будущем переделать на throw exception
            Integer value=board.get(item);
            if (value==null)
                System.out.println("В методе getValues() ключ не найден!");
            else
                returnValues.add(value);
        }
        return returnValues;
    }
}
