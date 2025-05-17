import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    Board board = new SquareBoard(4);

    @Test
    void getWidth() {
        assertEquals(4, board.getWidth(),"Успех");
    }

    @Test
    void getHeight() {
        assertEquals(4, board.getHeight(),"Успех");
    }
}