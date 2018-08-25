package MainFrame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.tree.DefaultMutableTreeNode;

import GoodsConnection.Goods;
import GoodsConnection.GoodsDao;
import SalesmanConnection.SalesmanDao;



public class InternalFrame extends JInternalFrame{
	public JLabel label1 = new JLabel("添加商品名称:");
	public JLabel label2 = new JLabel("添加商品价格:");
	public JLabel label3 = new JLabel("添加商品数量:");
	public JLabel label4 = new JLabel("更改商品名称:");
	public JLabel label5 = new JLabel("更改商品价格:");
	public JLabel label6 = new JLabel("更改商品数量:");
	public JLabel label7 = new JLabel("删除商品名称:");
	public JLabel label8 = new JLabel("查询商品名称:");
	public JLabel label9 = new JLabel("所查商品数量:");
	public JLabel label10 = new JLabel("所查商品价格:");
	public JLabel label11 = new JLabel("请输入用户名:");
	public JLabel label12 = new JLabel("请输入密码:");
	public JLabel label13 = new JLabel("请输入商品数量:");
	public JLabel label15 = new JLabel("总计:");
	public JLabel label16 = new JLabel("请输入实际交费金额:");
	public JLabel label17 = new JLabel("找零:");
	public JLabel label18 = new JLabel("添加售货员姓名:");
	public JLabel label19 = new JLabel("添加售货员密码:");
	public JLabel label20 = new JLabel("请输入更改售货员的姓名:");
	public JLabel label21 = new JLabel("确认更改密码:");
	public JLabel label22 = new JLabel("删除售货员姓名:");
	public JLabel label23 = new JLabel("确认密码:");
	public JLabel label24 = new JLabel("查询售货员姓名:");
	public JLabel label25 = new JLabel("密码:");
	public JLabel label26 = new JLabel("商品录入");
	public JLabel label27 = new JLabel("输入商品名称:");
	public JTextField textField1 = new JTextField();  //添加商品名称
	public JTextField textField2 = new JTextField();  //添加商品价格
	public JTextField textField3 = new JTextField();  //更改商品名称
	public JTextField textField4 = new JTextField();  //更改商品价格
	public DigitOnlyField textField5 = new DigitOnlyField(1);  //更改商品数量
	public JTextField textField6 = new JTextField();  //删除商品名称
	public JTextField textField7 = new JTextField();  //查询商品名称
	public JTextField textField8 = new JTextField();  //所查商品数量
	public JTextField textField9 = new JTextField();  //所查商品价格
	public JTextField textField10 = new JTextField();  //输入用户名
	public JPasswordField textField11 = new JPasswordField();  //输入密码
	public JTextField textField12 = new JTextField();  //添加售货员姓名
	public JTextField textField13 = new JTextField();  //添加售货员密码
	public JTextField textField14 = new JTextField();  //更改售货员的姓名
	public JTextField textField15 = new JTextField();  //确认更改密码
	public JTextField textField16 = new JTextField();  //删除售货员的姓名
	public JTextField textField17 = new JTextField();  //确认删除密码
	public JTextField textField18 = new JTextField();  //查询售货员的姓名
	public JTextField textField19 = new JTextField();  //显示密码
	public DigitOnlyField textField20 = new DigitOnlyField(1);  //添加商品数量
	public JTextField textField21 = new JTextField();  //商品总价显示
	private JToolBar toolBar = new JToolBar();
	private JTable table;  //支持查询功能
	private Object head[] = null;  //商品列表表头
	private DefaultTableModel defaultTableModel = null;
	private JTextArea textArea = new JTextArea(3, 2);
	public JPanel panel = new JPanel();
	private JButton button1 = new JButton("商品添加");
	private JButton button2 = new JButton("商品更改");
	private JButton button3 = new JButton("商品删除");
	private JButton button4 = new JButton("商品列表");
	private JButton button5 = new JButton("商品查询");
	private JButton button6 = new JButton("前台登陆");
	private JButton button8 = new JButton("销售列表");
	private JButton button9 = new JButton("售货员管理");
	private JButton button10 = new JButton("退出");
	private JButton button11 = new JButton("添加");
	private JButton button12 = new JButton("更改");
	private JButton button13 = new JButton("删除");
	private JButton button14 = new JButton("查询");
	private JButton button15 = new JButton("登录");
	private JButton button16 = new JButton("继续添加商品");
	private JButton button17 = new JButton("结账");
	private JButton button18 = new JButton("添加售货员");
	private JButton button19 = new JButton("更改信息");
	private JButton button20 = new JButton("确认删除");
	private JButton button21 = new JButton("查询售货员信息");
	public JButton label14 = new JButton("商品总价:");
	public Box box = Box.createVerticalBox();
	private JTextArea searchcomboBox = new JTextArea();    //输入商品关键字
	public DigitOnlyField digitOnlyField = new DigitOnlyField(1);  //每件商品的数量
	public double i = 0;  //单个商品总价
	public double all = 0;  //结算时商品总价
	public double pay = 0;  //找零
	private JTable selltable = new JTable(1, 5);  //当日销售列表
	private JTable infotable = new JTable(1, 2);  //售货员列表
	private DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("售货员管理");
	private DefaultMutableTreeNode add = new DefaultMutableTreeNode("添加售货员");
	private DefaultMutableTreeNode edit = new DefaultMutableTreeNode("更改售货员");
	private DefaultMutableTreeNode del = new DefaultMutableTreeNode("删除售货员");
	private DefaultMutableTreeNode show = new DefaultMutableTreeNode("显示所有售货员");
	private DefaultMutableTreeNode find = new DefaultMutableTreeNode("查询售货员");
	private JTree tree = new JTree(rootNode);
	private Object [][] data=null;
	private GoodsDao goodsDao = new GoodsDao();  //商品表连接实例化
	private SalesmanDao salesnamDao = new SalesmanDao();  //售货员表连接实例化
	public InternalFrame(String title) {
		super();
		setTitle(title);
		setResizable(true);
		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
		this.add(toolBar, BorderLayout.PAGE_START);
		this.add(panel);
		button10.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		//判断点击的菜单栏项
		if (title == "商品维护") {
			product();
		}
		if (title == "前台收银") {
			counter();
		}
		if (title == "商品管理") {
			productmanager();
		}
		//添加图标
		/*URL resource = this.getClass().getResource("caption.png");
        ImageIcon icon = new ImageIcon(resource);
        setFrameIcon(icon);*/
	}
	
	public void product() {
		toolBar.add(button1);
		toolBar.add(button2);
		toolBar.add(button3);
		toolBar.add(button4);
		toolBar.add(button5);
		toolBar.add(button10);
		
		button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel.removeAll();
				box.removeAll();
				panel.add(box);
				box.add(label1);
				box.add(textField1);
				box.add(label2);
				box.add(textField2);
				box.add(label3);
				box.add(textField20);
				box.add(button11);
				button11.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						try {
							goodsDao.addGoods(textField1.getText(), Double.parseDouble(textField2.getText()), Integer.valueOf(textField20.getText()).intValue());
						} catch (NumberFormatException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						textField1.setText("");
						textField2.setText("");
						textField20.setText("");
					}
				});
				//解决点击按钮没有反应需要最小化来刷新的问题
				panel.validate();
				panel.repaint();
			}
		});
		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				panel.removeAll();
				box.removeAll();
				panel.add(box);
				box.add(label4);
				box.add(textField3);
				box.add(label5);
				box.add(textField4);
				box.add(label6);
				box.add(textField5);
				box.add(button12);
				button12.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						try {
							goodsDao.updateGoods(textField3.getText(), Double.parseDouble(textField4.getText()), Integer.valueOf(textField5.getText()).intValue());
						} catch (NumberFormatException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						textField3.setText("");
						textField4.setText("");
						textField5.setText("");
					}
				});
				panel.validate();
				panel.repaint();
			}
		});
		button3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				panel.removeAll();
				box.removeAll();
				panel.add(box);	
				box.add(label7);
				box.add(textField6);
				box.add(button13);
				button13.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						try {
							goodsDao.delGoods(textField6.getText());
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						textField6.setText("");
					}
				});
				panel.validate();
				panel.repaint();
			}
		});
		button4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				panel.removeAll();
				box.removeAll();
				head = new Object[] {"商品编号", "商品名称", "商品价格", "商品数量"};
				defaultTableModel = new DefaultTableModel(queryData(),head){
		            public boolean isCellEditable(int row, int column)
		            {
		                return false;
		            }
		        };
		        table = new JTable(defaultTableModel);
				JScrollPane s = new JScrollPane(table);
				panel.add(s);
				panel.validate();
				panel.repaint();
			}
			private Object[][] queryData() {
				// TODO Auto-generated method stub
				List<Goods> list = goodsDao.allGoods();
				data = new Object[list.size()][head.length];
				for(int i=0;i<list.size();i++){
		            for(int j=0;j<head.length;j++){
		                data[i][0]=list.get(i).getGID();
		                data[i][1]=list.get(i).getGNAME();
		                data[i][2]=list.get(i).getGPRICE();
		                data[i][3]=list.get(i).getGNUM();
		            }
		        }
				return data;
			}
		});
		button5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				textField8.setEditable(false);
				textField9.setEditable(false);
				panel.removeAll();
				box.removeAll();
				panel.add(box);
				box.add(label8);
				box.add(textField7);
				box.add(button14);
				box.add(label9);
				box.add(textField8);
				box.add(label10);
				box.add(textField9);
				button14.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						textField8.setText(goodsDao.searchGoods(textField7.getText())[1]);
						textField9.setText(goodsDao.searchGoods(textField7.getText())[0]);
					}
				});
				panel.validate();
				panel.repaint();
			}
		});
	}
	
	public void counter() {
		toolBar.add(button6);
		toolBar.add(button10);
		button6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				panel.removeAll();
				box.removeAll();
				box.add(label11);
				box.add(textField10);
				box.add(label12);
				box.add(textField11);
				box.add(button15);
				button15.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						String pw = salesnamDao.Login(textField10.getText());
						String inputpw = textField11.getText();
						if (pw.equals(inputpw)) {
							JOptionPane.showMessageDialog(null,"登录成功！");
							toolBar.remove(button6);
							toolBar.remove(button10);
							toolBar.add(label26);
							panel.removeAll();
							box.removeAll();
							box.add(label27);
							box.add(searchcomboBox);							
							box.add(label13);
							box.add(digitOnlyField);
							box.add(label14);
							label14.addActionListener(new ActionListener() {
								
								@Override
								public void actionPerformed(ActionEvent arg0) {
									// TODO Auto-generated method stub
									i = getData() * Integer.valueOf(digitOnlyField.getText()).intValue();
									textField21.setText(String.valueOf(i));
								}

								private Double getData() {
									// TODO Auto-generated method stub
									double productdata = salesnamDao.searchGoods(searchcomboBox.getText());
									return productdata;
								}
							});
							box.add(textField21);
							textField21.setEditable(false);
							box.add(button16);
							//textArea.setEditable(false);
							box.add(button17);
							button16.addActionListener(new ActionListener() {
								@Override
								public void actionPerformed(ActionEvent arg0) {
									// TODO Auto-generated method stub
									if (false) {
										//所选商品不存在时
										JOptionPane.showMessageDialog(null,"该商品不存在！");
									} else {
										all += getData() * Integer.valueOf(digitOnlyField.getText()).intValue();
										searchcomboBox.setText("");
										digitOnlyField.setText("");
										textField21.setText("");
									}
								}
								
								//将单价转换为double型
								private Double getData() {
									// TODO Auto-generated method stub
									double productdata = salesnamDao.searchGoods(searchcomboBox.getText());
									return productdata;
								}
							});
							button17.addActionListener(new ActionListener() {
								
								@Override
								public void actionPerformed(ActionEvent arg0) {
									// TODO Auto-generated method stub
									String input = JOptionPane.showInputDialog("请输入实际交费金额:");
									all += getData() * Integer.valueOf(digitOnlyField.getText()).intValue();
									pay = Double.parseDouble(input) - all;
									JOptionPane.showMessageDialog(InternalFrame.this, "找零"+pay+"元");
								}

								//将单价转换为double型
								private Double getData() {
									// TODO Auto-generated method stub
									double productdata = salesnamDao.searchGoods(searchcomboBox.getText());
									return productdata;
								}
								
							});
							panel.add(box);
							panel.validate();
							panel.repaint();
							toolBar.validate();
							toolBar.repaint();
						}else {
							JOptionPane.showMessageDialog(null,"登录失败，请重新输入");
						}
						textField10.setText("");
						textField11.setText("");
					}
				});
				panel.add(box);
				panel.validate();
				panel.repaint();
			}
		});
	}
	
	public void productmanager() {
		toolBar.add(button8);
		toolBar.add(button9);
		toolBar.add(button10);
		button8.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				panel.removeAll();
				box.removeAll();
				box.add(selltable);
				panel.add(box);
				panel.validate();
				panel.repaint();
			}
		});
		button9.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				panel.removeAll();
				rootNode.add(add);
				rootNode.add(del);
				rootNode.add(edit);
				rootNode.add(find);
				rootNode.add(show);
				panel.add(tree);
				tree.addTreeSelectionListener(new TreeSelectionListener() {
					
					@Override
					public void valueChanged(TreeSelectionEvent e) {
						// TODO Auto-generated method stub
						// 获取当前选择的第一个结点中的最后一个路径组件
			            DefaultMutableTreeNode dmt = (DefaultMutableTreeNode) ((JTree) e.getSource()).getLastSelectedPathComponent();
			            // 如果是叶子结点
			            if (dmt.isLeaf()) {
			                String str = dmt.toString();// 叶子结点的字符串
			                // 判断
			                if (str.equals("添加售货员")) {
			                	//添加售货员界面
			                	panel.removeAll();
			                	box.removeAll();
			                	box.add(label18);
			                	box.add(textField12);
			                	box.add(label19);
			                	box.add(textField13);
			                	box.add(button18);
			                	panel.add(box);
			                	panel.validate();
			    				panel.repaint();
			                } else if (str.equals("更改售货员")) {
			                	//更改售货员界面
			                	panel.removeAll();
			                	box.removeAll();
			                	box.add(label20);
			                	box.add(textField14);
			                	box.add(label21);
			                	box.add(textField15);
			                	box.add(button19);
			                	panel.add(box);
			                	panel.validate();
			    				panel.repaint();
			                } else if (str.equals("删除售货员")) {
			                	//删除售货员界面
			                	panel.removeAll();
			                	box.removeAll();
			                	box.add(label22);
			                	box.add(textField16);
			                	box.add(label23);
			                	box.add(textField17);
			                	box.add(button20);
			                	panel.add(box);
			                	panel.validate();
			    				panel.repaint();
			                } else if (str.equals("显示所有售货员")) {
								//显示所有售货员界面
			                	panel.removeAll();
			                	panel.add(infotable);
			                	panel.validate();
			    				panel.repaint();
							} else if (str.equals("查询售货员")) {
								//查询售货员界面
								panel.removeAll();
			                	box.removeAll();
			                	box.add(label24);
			                	box.add(textField18);
			                	box.add(button21);
			                	box.add(label25);
			                	textField19.setEditable(false);
			                	box.add(textField19);
			                	panel.add(box);
			                	panel.validate();
			    				panel.repaint();
							}
			            }
					}
				});
				panel.validate();
				panel.repaint();
			}
		});
	}
}
