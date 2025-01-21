/**
 * Задание по разработке - класс Board
 * @author Sheynin Vladislav
 */
import java.util.*;

public abstract class Board {
    int weigh;
    int height;
    Map<Key, Integer> board = new HashMap<>();

    public Board(int weight, int height){this.weigh=weight;this.height=height;}

    public abstract void fillBoard(List<Integer> list);

    public abstract List<Key> availableSpace();

    public abstract void addItem(Key key, Integer value);

    public abstract Key getKey(int i, int j);

    public abstract Integer getValue(Key key);

    public abstract List<Key> getColumn(int j);

    public abstract List<Key> getRow(int i);

    public abstract boolean hasValue(Integer value);

    public abstract List<Integer> getValues(List<Key> keys);
}
