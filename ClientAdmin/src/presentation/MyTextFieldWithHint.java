package presentation;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

public class MyTextFieldWithHint extends JTextField {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3702470477548324288L;
	JTextField style;
	private String ph;
	public MyTextFieldWithHint(final String ph) {
		this.ph = ph;
		setText(ph);
		setForeground(Color.decode("#9E9E9E"));
		this.style = new JTextField();
		
		addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {

				if (getText().length() == 0) {
					setForeground(Color.decode("#9E9E9E"));
					setText(ph);
				}

			}

			@Override
			public void focusGained(FocusEvent e) {
				
				if (getText().length() != 0 && getText().equals(ph)) {
					setForeground(getStyle());
					setText("");
				}
				
			}
		});
	}
	
	public void setPlaceHolder(String ph) {
		this.ph=ph;
	}
	public Color getStyle() {
		getParent().add(style);
		return this.style.getForeground();
	}
	
	public String getPlaceHolder() {
		return this.ph;
	}

}
