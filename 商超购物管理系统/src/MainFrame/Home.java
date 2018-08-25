package MainFrame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.io.File;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Home extends JFrame{
	private JMenuBar menuBar = new JMenuBar();
	private JMenu menu1 = new JMenu("商品维护(F)");
	private JMenu menu2 = new JMenu("前台收银(S)");
	private JMenu menu3 = new JMenu("商品管理(N)");
	private JMenuItem menuItem1 = new JMenuItem("打开");
	private JMenuItem menuItem2 = new JMenuItem("打开");
	private JMenuItem menuItem3 = new JMenuItem("打开");
	InternalFrame productinfo;
	InternalFrame counter;
	InternalFrame productmanager;
	private MyActionListener actionListener1 = new MyActionListener(productinfo, "商品维护");
	private MyActionListener actionListener2 = new MyActionListener(counter, "前台收银");
	private MyActionListener actionListener3 = new MyActionListener(productmanager, "商品管理");
	JDesktopPane desktopPane = new JDesktopPane();    //桌面面板
	public Home() {
		super("商超购物管理系统");
		setVisible(true);
		setSize(800, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setJMenuBar(menuBar);
		desktopPane.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);  //设置内部窗体拖动模式
		getContentPane().add(desktopPane, BorderLayout.CENTER);
		menu1.setMnemonic('F');
		menu2.setMnemonic('S');
		menu3.setMnemonic('N');
		menuBar.add(menu1);
		menuBar.add(menu2);
		menuBar.add(menu3);
		menu1.add(menuItem1);
		menu2.add(menuItem2);
		menu3.add(menuItem3);
		menuItem1.addActionListener(actionListener1);
		menuItem2.addActionListener(actionListener2);
		menuItem3.addActionListener(actionListener3);
	}
	
	public static void main(String[] args) {
		new Home();
	}
	
	class MyActionListener implements ActionListener {
		InternalFrame internalFrame;
		String title;
		public MyActionListener(InternalFrame internalFrame, String title) {
			// TODO Auto-generated constructor stub
			this.internalFrame = internalFrame;
			this.title = title;
		}
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			//初始化子窗口
			if(internalFrame ==null || internalFrame.isClosed()){
                JInternalFrame[] allFrames = desktopPane.getAllFrames();
                int titleBarHight = 30 * allFrames.length;
                int x= 10 + titleBarHight, y = x;
                internalFrame = new InternalFrame(title);
                internalFrame.setBounds(x, y, 480, 300);//设置位置与大小 
                internalFrame.setVisible(true);   //可见
                desktopPane.add(internalFrame);   //添加到桌面面板
            }
            try
            {
            	internalFrame.setSelected(true);
            }catch(PropertyVetoException propertyVetoE){
                propertyVetoE.printStackTrace();
            }
		}
		
	}
}