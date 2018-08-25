package MainFrame;

import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

//设置文本框只允许输入数字
public class DigitOnlyField extends JTextField {
	private static final long serialVersionUID = 8384787369612949227L;

	public DigitOnlyField(int cols) {
		// super() 可以被自动调用，但是有参构造方法并不能被自动调用，只能依赖
		// super关键字显示地调用父类的构造方法
       super(cols);
   }

   protected Document createDefaultModel() {
       return new UpperCaseDocument();
   }

   static class UpperCaseDocument extends PlainDocument {

       /**
		 * 
		 */
		private static final long serialVersionUID = -4170536906715361215L;

		public void insertString(int offs, String str, AttributeSet a)
           throws BadLocationException {

           if (str == null) {
               return;
           }
           char[] upper = str.toCharArray();
           String filtered = "";
           for (int i = 0; i < upper.length; i++) {
           	if (Character.isDigit(Character.codePointAt(upper, i))){
           		filtered += upper[i];
           	}
           }
           super.insertString(offs, filtered, a);
       }
   }
}
