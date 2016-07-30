import java.util.Scanner;

import javax.naming.InitialContext;

public class GameManager {

	public static void main(String[] args) {
		Game game = new Game();
		game.init();
		game.start();
		game.showPlane();
	}
}
