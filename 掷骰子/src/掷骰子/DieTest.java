package 掷骰子;

public class DieTest {
	public static void main(String[] args) {
		DieGame dieGame = new DieGame();
		if (dieGame.play()) {
			System.out.println("你赢了！");
		} else {
			System.out.println("你输了，再接再厉！");
		}
	}
}
