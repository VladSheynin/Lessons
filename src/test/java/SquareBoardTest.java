import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

class SquareBoardTest {

    private final Board<Key, Integer> squareBard = new SquareBoard<>(2);

    @Test
    void initTest() {
        squareBard.fillBoard(asList(1, 2, 3, 4));
        Assertions.assertEquals(3, squareBard.getValue(squareBard.getKey(1, 0)));
    }

    @Test
    void addItemTest() {
        squareBard.fillBoard(asList(0, 0, 0, null));
        squareBard.addItem(new Key(1, 1), 2);
        Assertions.assertEquals(2, squareBard.getValue(new Key(1, 1)));
    }

    @Test
    void availableSpaceTest() {
        squareBard.fillBoard(asList(0, 0, 0, null));
        List<Key> availableList = squareBard.availableSpace();
        Assertions.assertEquals(1, availableList.size());
    }

    @Test
    void fillBoardRuntimeErrorTest() {
        Assertions.assertThrows(RuntimeException.class, () -> squareBard.fillBoard(asList(1, 2, 3, 4, 5)));
    }

    @Test
    void hesValueTest() {
        squareBard.fillBoard(asList(0, 0, 0, 3));
        Assertions.assertEquals(true, squareBard.hasValue(3));
    }

    @Test
    void getValuesTest() {
        squareBard.fillBoard(asList(0, 1, 2, 3));
        Assertions.assertEquals(Arrays.asList(0, 3), squareBard.getValues(Arrays.asList(new Key(0, 0), new Key(1, 1))));
    }

    @Test
    void getColumnTest() {
        squareBard.fillBoard(asList(0, 1, 2, 3));
        Assertions.assertEquals(asList(new Key(0, 1), new Key(1, 1)), squareBard.getColumn(1));
    }

    @Test
    void getRowTest() {
        squareBard.fillBoard(asList(0, 1, 2, 3));
        Assertions.assertEquals(asList(new Key(0, 0), new Key(0, 1)), squareBard.getRow(0));
    }

    @Test
    void getKeyIfNullTest() {
        squareBard.fillBoard(asList(0, 1, 2, 3));
        Assertions.assertNull(squareBard.getKey(2, 2));
    }

    @Test
    void getValueIfNullTest() {
        squareBard.fillBoard(asList(0, 1, 2, 3));
        Assertions.assertNull(squareBard.getValue(new Key(2, 2)));
    }

    @Test
    void toStringTest() {
        //фактически заглушка так как смысла в тестировании нет, но хочется Coverage 100% :)
        squareBard.fillBoard(asList(0, 1, 2, 3));
        Assertions.assertEquals("0--1--\n2--3--\n", squareBard.toString());
    }

}