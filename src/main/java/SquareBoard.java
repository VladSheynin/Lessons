import java.security.Key;
import java.util.List;

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

    }

    /**
     * @return
     */
    @Override
    public List<Key> availableSpace() {
        return List.of();
    }

    /**
     * @param key
     * @param value
     */
    @Override
    public void addItem(Key key, Integer value) {

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
        return 0;
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

    /**
     * @param value
     * @return
     */
    @Override
    public boolean hasValue(Integer value) {
        return false;
    }

    /**
     * @param keys
     * @return
     */
    @Override
    public List<Integer> getValues(List<Key> keys) {
        return List.of();
    }
}
