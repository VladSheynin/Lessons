import javax.swing.*;

/**
 * Класс реализующие графику и логику работы с ней
 * взято с <a href="https://gist.github.com/CoolXaleX/2a0c1edffb48860ef07abb4c66e93eba">...</a>
 * не изменялось
 */
public class PlayGame {
    public static void main(String[] args) {
        JFrame game = new JFrame();
        game.setTitle("2048 Game");
        game.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        game.setSize(350, 380);
        game.setResizable(false);
        game.add(new Game2048Panel());
        game.setLocationRelativeTo(null);
        game.setVisible(true);
    }
}