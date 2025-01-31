/**
 * Задание по разработке - класс Board
 *
 * @author Sheynin Vladislav
 */

import java.util.*;

public abstract class Board<K,V> {
    private int weigh;
    private int height;

    public Map<K, V> board = new HashMap<>();

    public Board(int weight, int height) {
        this.weigh = weight;
        this.height = height;
    }

    public int getWeigh() {
        return weigh;
    }

    public int getHeight() {
        return height;
    }

    public abstract void fillBoard(List<V> list);

    public abstract List<K> availableSpace();

    public abstract void addItem(K key, V value);

    public abstract K getKey(int i, int j);

    public abstract V getValue(K key);

    public abstract List<K> getColumn(int j);

    public abstract List<K> getRow(int i);

    public abstract boolean hasValue(V value);

    public abstract List<V> getValues(List<K> keys);
}
