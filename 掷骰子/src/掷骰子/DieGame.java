package 掷骰子;

public class DieGame {
	public Die die1 = new Die();
	public Die die2 = new Die();
	public boolean play() {
		boolean flag = false;
		die1.roll();
		die2.roll();
		System.out.println(die1.getFaceValue());
		System.out.println(die2.getFaceValue());  //输出本次掷的骰子数
		int num = die1.getFaceValue() + die2.getFaceValue();
		if (num == 7) {
			flag =true;
		} else {
			flag = false;
		}
		return flag;
	}
}
