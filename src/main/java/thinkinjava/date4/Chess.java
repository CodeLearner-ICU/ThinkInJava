package thinkinjava.date4;

/**
 * 棋类游戏
 */
public class Chess extends BoardGame{
    Chess(int i) {
        super(i);
        System.out.println("Chess()");
    }

    public static void main(String[] args) {
        Chess c = new Chess(1);
    }
}

/**
 * 游戏
 */
class Game{
    Game(int i){
        System.out.println("Game("+i+")");
    }
}

/**
 * 木板类游戏
 */
class BoardGame extends Game{
    BoardGame(int i) {
        super(i);
        System.out.println("BoardGame()");
    }
}
