package SalesmanConnection;


//储存数据的实体类
public class Salesman {
	private int SID;
	private String SNAME;
	private String SPASSWORD;
	public int getSID() {
		return SID;
	}
	public void setSID(int sID) {
		SID = sID;
	}
	public String getSNAME() {
		return SNAME;
	}
	public void setSNAME(String sNAME) {
		SNAME = sNAME;
	}
	public String getSPASSWORD() {
		return SPASSWORD;
	}
	public void setSPASSWORD(String sPASSWORD) {
		SPASSWORD = sPASSWORD;
	}
}
