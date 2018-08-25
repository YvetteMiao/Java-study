package 掷骰子;

import java.util.Random;

public class Die {
	private int faceValue;
	public void roll() {
		Random random = new Random();
		this.faceValue = Math.abs(random.nextInt()) % 6 + 1;  //取1~6间任意整数
	}
	
	public int getFaceValue() {
		return this.faceValue;
	}
}
