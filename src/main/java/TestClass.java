import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class TestClass {
    public static void main(String[] args) {

        //Board board = new SquareBoard(4);
        Game game2048 = new Game2048();
        System.out.println(game2048.canMove());

    }
}
