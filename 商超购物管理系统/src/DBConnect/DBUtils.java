package DBConnect;

import java.sql.*;
import java.util.Vector;

import javax.swing.JOptionPane;

import GoodsConnection.Goods;

//连接数据库的代码
public class DBUtils {
	private static final String URL = "jdbc:mysql://localhost:3306/market?serverTimezone=GMT&useSSL=false";
	private static final String NAME = "root";
	private static final String PASSWORD = "songjie";
	private static Connection conn=null;
	//静态代码块（将加载驱动、连接数据库放入静态块中）
    static{
        try {
            //1.加载驱动程序
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.获得数据库的连接
            conn = DriverManager.getConnection(URL, NAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //对外提供一个方法来获取数据库连接
    public static Connection getConnection(){
        return conn;
    }
    
  //关闭方法
    public  static void close(ResultSet rs, Statement stat, Connection conn) throws SQLException{
        if(rs!=null){
        	rs.close();
        }
        if(stat!=null){
            stat.close();
        }
        if(conn!=null){
            conn.close();
        }
    }
}
