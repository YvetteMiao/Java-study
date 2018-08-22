package calculator;

public class CheckData {
	public CheckData() {
	}
	
	public boolean check(String s) {
		//判断数字是否合法
		Double a;
		try {
			a = Double.parseDouble(s);
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		return true;
	}
}
