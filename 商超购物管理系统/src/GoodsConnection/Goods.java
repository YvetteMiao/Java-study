package GoodsConnection;


//储存数据的实体类
public class Goods {
	private int GID;
	private String GNAME;
	private double GPRICE;
	private int GNUM;
	public int getGID() {
		return GID;
	}
	public void setGID(int GID) {
		this.GID = GID;
	}
	public String getGNAME() {
		return GNAME;
	}
	public void setGNAME(String GNAME) {
		this.GNAME = GNAME;
	}
	public double getGPRICE() {
		return GPRICE;
	}
	public void setGPRICE(double GPRICE) {
		this.GPRICE = GPRICE;
	}
	public int getGNUM() {
		return GNUM;
	}
	public void setGNUM(int GNUM) {
		this.GNUM = GNUM;
	}
}
