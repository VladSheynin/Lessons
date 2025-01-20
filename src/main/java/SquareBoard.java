import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;
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

    /**
     * @param list
     */
    @Override
    public void fillBoard(List<Integer> list) {

    board.putAll();
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

    /**
     * @param i
     * @param j
     * @return
     */
    @Override
    public Key getKey(int i, int j) {
        return null;
    }

    /**
     * @param key
     * @return
     */
    @Override
    public Integer getValue(Key key) {
        return board.get(key);
    }

    /**
     * @param j
     * @return
     */
    @Override
    public List<Key> getColumn(int j) {
        return List.of();
    }

    /**
     * @param i
     * @return
     */
    @Override
    public List<Key> getRow(int i) {
        return List.of();
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
