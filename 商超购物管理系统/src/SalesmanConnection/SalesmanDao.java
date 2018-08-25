package SalesmanConnection;

import java.sql.*;
import java.util.*;

import javax.swing.JOptionPane;

import DBConnect.DBUtils;
import GoodsConnection.Goods;
import GoodsConnection.GoodsDao;

//进行数据操作的类
public class SalesmanDao {
	private Connection conn=null;
    private PreparedStatement ps=null;
    private ResultSet rs=null;
    GoodsDao goodsDao = new GoodsDao();
    //售货员列表
    public List<Salesman> allSalesman() {
		List<Salesman> list = new ArrayList<Salesman>();
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement("select * from salesman");
			rs = ps.executeQuery();
			while (rs.next()) {
				Salesman salesman = new Salesman();
				salesman.setSID(rs.getInt(1));
				salesman.setSNAME(rs.getString(2));
				salesman.setSPASSWORD(rs.getString(3));
				list.add(salesman);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
    
    //登录验证(当输入用户名不存在的，还会抛出异常，程序终止)
    public String Login(String sname) {
    	String pw = null;
    	List<Salesman> list = allSalesman();
    	for (Salesman salesman : list) {
			if (salesman.getSNAME().equals(sname)) {
				pw = salesman.getSPASSWORD();
			}
		}
    	return pw;
    }
    
    //获取放入购物车中商品的单价
    public int searchGoods(String name) {
    	int infodata = 0;
		List<Goods> list = goodsDao.allGoods();
		for (Goods goods : list) {
			if (goods.getGNAME().equals(name)) {
				infodata = (int)goods.getGPRICE();
			}
		}
		return infodata;
	}
}
