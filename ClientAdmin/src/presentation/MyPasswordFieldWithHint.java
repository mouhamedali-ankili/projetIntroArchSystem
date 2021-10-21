
package presentation;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class MyPasswordFieldWithHint extends  JPasswordField {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3702470477548324288L;
	JTextField style;
	String ph;
	public MyPasswordFieldWithHint(final String ph) {
		super(7);
		this.ph = ph;
		setEchoChar('\0');
		setText(this.ph);
		setForeground(Color.decode("#9E9E9E"));
		this.style = new JTextField();

		addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {

				if (getPassword().length == 0) {
					setEchoChar('\0');
					setForeground(Color.decode("#9E9E9E"));
					setText(ph);
				}

			}

			@Override
			public void focusGained(FocusEvent e) {
				
				if (getPassword().length !=0 && String.valueOf(getPassword()).equals(ph)) {
					setEchoChar('\u25CF');
					setForeground(getStyle());
					setText("");
				}

			}
		});
		
	}

	public Color getStyle() {
		getParent().add(style);
		return this.style.getForeground();
	}
	
	
	public String getPlaceHolder() {
		return this.ph;
	}

}
