package calculator;

public class Calculate {

	public double cal(double data1, double data2, String op) {
		// TODO Auto-generated method stub
		double rel = 0;
		switch (op) {
		case "+":
			rel = data1 + data2;
			break;

		case "-":
			rel = data1 - data2;
			break;
			
		case "*":
			rel = data1 * data2;
			break;
			
		case "/":
			rel = data1 / data2;
			break;
			
		default:
			break;
		}
		return rel;
	}

}
