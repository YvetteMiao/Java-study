package 二十一点游戏;

import java.awt.Container;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class CardManager {
	public Card[] cards = new Card[52];
	//初始化一副52张纸牌
	public void initCards() {
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= 13; j++) {
				cards[(i - 1)*13 + j - 1] = new Card(i, j);
			}
		}
	}
	
	//随机打乱这52张纸牌
	public void randomCards() {
		Card temp = null;
		//随机生成牌号
		for (int i = 0; i < 52; i++) {
			int a = (int)(Math.random()*52);
			int b = (int)(Math.random()*52);
			temp = cards[a];
			cards[a] = cards[b];
			cards[b] = temp;
		}
	}

	
	//显示纸牌图片
	public void gameStart(JLabel game[], Container c) {
		//在容器中删除标签组件
		if (game[0] != null) {
			for (int i = 0; i < 52; i++) {
				c.remove(game[i]);
			}
			c.repaint();
		}
		//在容器中放置52个标签组件用于放置图片
		for (int i = 0; i < 52; i++) {
			game[i] = new JLabel();
			game[i].setBorder(javax.swing.BorderFactory.createEtchedBorder());
			game[i].setBounds(new Rectangle(100 + i*10, 10, 101, 150));
			c.add(game[i]);
		}
		//设置标签组件的图片为rear.jpg，即牌的背面
		for (int i = 0; i < 52; i++) {
			game[i].setIcon(new ImageIcon("images/rear.jpg"));
		}
	}
}
