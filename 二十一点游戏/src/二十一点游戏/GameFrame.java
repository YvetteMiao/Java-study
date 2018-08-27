package 二十一点游戏;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.*;

public class GameFrame  extends JFrame implements ActionListener{
	JButton clear_btn = new JButton("洗牌");
	JButton compute_btn = new JButton("开始游戏");
	JButton game_btn = new JButton("玩家抓牌");
	JButton gameover_btn = new JButton("本轮结束");
	CardManager cm = new CardManager();
	JLabel game[] = new JLabel[52];  //放置52张扑克牌的标签
	int i = 0;  //定义抓牌数
	int computer_dot = 0;  //定义电脑点数
	int game_dot = 0;  //定义玩家点数
	Vector v = new Vector();  //存储电脑抓的纸牌
	JLabel jLabel1 = new JLabel("电脑显示牌区");
	JLabel jLabel2 = new JLabel("玩家显示牌区");
	public GameFrame() {
		getContentPane().setLayout(null);
		this.setTitle("二十一点游戏");
		this.setSize(800, 500);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();  //获得屏幕的宽和高
		Dimension frameSize = this.getSize();  //获得当前窗体的宽和高
		//设置窗体居中
		if (frameSize.height > screenSize.height) {
			frameSize.height = screenSize.height;
		}
		if (frameSize.width > screenSize.width) {
			frameSize.width = screenSize.width;
		}
		this.setLocation((screenSize.width-frameSize.width)/2, (screenSize.height-frameSize.height)/2);
		clear_btn.setBounds(new Rectangle(78, 388, 73, 31));
		clear_btn.addActionListener(this);
		compute_btn.setBounds(new Rectangle(233, 388, 86, 31));
		compute_btn.setEnabled(false);
		compute_btn.addActionListener(this);
		game_btn.setBounds(new Rectangle(413, 389, 91, 32));
		game_btn.setEnabled(false);
		game_btn.addActionListener(this);
		gameover_btn.setBounds(new Rectangle(625, 390, 91, 32));
		gameover_btn.setEnabled(false);
		gameover_btn.addActionListener(this);
		JMenuBar menuBar = new JMenuBar();
		JMenu file = new JMenu("文件");
		JMenu help = new JMenu("帮助");
		JMenuItem fileExit = new JMenuItem("退出");
		JMenuItem helpAbout = new JMenuItem("关于");
		this.setJMenuBar(menuBar);
		menuBar.add(file);
		menuBar.add(help);
		file.add(fileExit);
		fileExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		help.add(helpAbout);
		helpAbout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new AboutFrame();
			}
		});
		jLabel1.setBounds(new Rectangle(104, 343, 95, 38));
		jLabel2.setBounds(new Rectangle(499, 343, 92, 33));
		this.getContentPane().add(jLabel1);
		this.getContentPane().add(jLabel2);
		this.getContentPane().add(clear_btn);
		this.getContentPane().add(compute_btn);
		this.getContentPane().add(game_btn);
		this.getContentPane().add(gameover_btn);
		this.setVisible(true);
		this.setResizable(false);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//洗牌按钮
		if (arg0.getSource() == clear_btn) {
			//关闭和开启相应的按钮
			compute_btn.setEnabled(true);
			clear_btn.setEnabled(false);
			//对记牌器、电脑点数和玩家点数进行初始化
			i = 0;
			computer_dot = 0;
			game_dot = 0;
			//把标签框控件数组放入窗体窗格中
			cm.gameStart(game, this.getContentPane());
			//初始化纸牌
			cm.initCards();
			//随机打乱纸牌
			cm.randomCards();
		}
		
		//开始游戏按钮
		if (arg0.getSource() == compute_btn) {
			//关闭和开启相应的按钮
			compute_btn.setEnabled(false);
			game_btn.setEnabled(true);
			//电脑抓牌
			for (int k = 0; k < 20; k++) {
				game[i].setIcon(new ImageIcon("images/rear.jpg"));
				game[i].setBounds(new Rectangle(50 + i*20, 200, 101, 150));
				getContentPane().setComponentZOrder(game[i], 1);
				if (cm.cards[i].getValue() == 10) {
					computer_dot = computer_dot + 1;
				}else {
					computer_dot = computer_dot + cm.cards[i].getValue();
				}
				v.add(cm.cards[i]);
				getContentPane().repaint();
				i = i + 1;
				//如果面值总数大于15停止抓牌
				if (computer_dot >= 15) {
					return;
				}
			}
		}
		
		//玩家抓牌按钮
		if (arg0.getSource() == game_btn) {
			//提示
			if (game_dot >= 10) {
				int a = JOptionPane.showConfirmDialog(null, "现在点数为:"+game_dot+"是否再抓牌", "提示", JOptionPane.YES_NO_OPTION);
				if (a == JOptionPane.NO_OPTION) {
					game_btn.setEnabled(false);
					gameover_btn.setEnabled(true);
					return;
				}
			}
			//设置标签框力里显示抓到的纸牌
			game[i].setIcon(new ImageIcon("images/"+cm.cards[i].getType()+"-"+cm.cards[i].getValue()+".jpg"));
			game[i].setBounds(new Rectangle(350 + i*20, 200, 101, 150));
			this.getContentPane().setComponentZOrder(game[i], 1);
			//计算抓到的纸牌面值
			if (cm.cards[i].getValue() > 10) {
				game_dot = game_dot + 1;
			}else {
				game_dot = game_dot + cm.cards[i].getValue();
			}
			i = i + 1;
			//面值大于21停止抓牌，关闭和开启相应按钮
			if (game_dot > 21) {
				game_btn.setEnabled(false);
				gameover_btn.setEnabled(true);
				return;
			}
		}
		
		//本轮游戏结束按钮
		if (arg0.getSource() == gameover_btn) {
			for (int i = 0; i < v.size(); i++) {
				Card card = (Card)v.get(i);
				game[i].setIcon(new ImageIcon("images/"+card.getType()+"-"+card.getValue()+".jpg"));
				game[i].setBounds(new Rectangle(50 + i*20, 200, 101, 150));
				this.getContentPane().setComponentZOrder(game[i], 1);
			}
			//计算胜负
			String game_over = "";
			if (game_dot > 21 && computer_dot <= 21) {
				game_over = "电脑获胜";
			} else if (game_dot <= 21 && computer_dot > 21) {
				game_over = "玩家获胜";
			}else if (game_dot >= 21 & computer_dot >= 21) {
				game_over = "平局";
			}else if (game_dot > computer_dot) {
				game_over = "玩家获胜";
			}else if (game_dot < computer_dot) {
				game_over = "电脑获胜";
			}else if (game_dot == computer_dot) {
				game_over = "平局";
			}
			//以对话框的方式显示胜负
			String message = "游戏结果\n";
			message = message + "电脑点数:" + String.valueOf(computer_dot) + "\n";
			message = message + "玩家点数:" + String.valueOf(game_dot) + "\n";
			message = message + "游戏结果:" + game_over;
			JOptionPane.showMessageDialog(null, message, "本轮游戏结果", JOptionPane.INFORMATION_MESSAGE);
			//设置命令按钮可操作
			clear_btn.setEnabled(true);
			compute_btn.setEnabled(true);
			game_btn.setEnabled(true);
			gameover_btn.setEnabled(true);
		}
	}
	
	public static void main(String[] args) {
		GameFrame gameFrame = new GameFrame();
	}
}
