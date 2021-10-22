package presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class UserInformation extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel text,name,surname,address,cel;
	JTextField fillName,fillSurname,fillAddress,fillCel;
	public UserInformation() {
		setBackground(Color.decode("#33D1FF"));
		setLayout(new BorderLayout());

		
		JPanel header = new JPanel(new FlowLayout());
		header.setBackground(Color.decode("#33D1FF"));
		text=new JLabel("USER INFORMATION");
		text.setForeground(Color.WHITE);
		text.setFont(new Font("Roboto", Font.ITALIC, 14));
		header.add(text);
		add(header,BorderLayout.NORTH);
		
		
		
		JPanel body = new JPanel();
		body.setBackground(Color.decode("#33D1FF"));
		GridLayout gl = new GridLayout(8,1);
		body.setLayout(gl);
		name=new JLabel("NOM");
		name.setForeground(Color.WHITE);
		name.setFont(new Font("Roboto", Font.ITALIC, 12));
		body.add(name);
		
		
		fillName= new JTextField();
		fillName.setPreferredSize(new Dimension(307,30));
		body.add(fillName);
		
		gl.setVgap(5);
		gl.setHgap(20);
		surname=new JLabel("PRENOM");
		surname.setForeground(Color.WHITE);
		surname.setFont(new Font("Roboto", Font.ITALIC, 12));
		body.add(surname);
		
		fillSurname =new JTextField();
		body.add(fillSurname);
		address=new JLabel("ADRESSE");
		address.setForeground(Color.WHITE);
		address.setFont(new Font("Roboto", Font.ITALIC, 12));
		body.add(address);
		
		fillAddress = new JTextField();
		body.add(fillAddress);
		
		cel=new JLabel("TELEPHONE");
		cel.setForeground(Color.WHITE);
		cel.setFont(new Font("Roboto", Font.ITALIC, 12));
		body.add(cel);
		
		
		fillCel=new JTextField();
		body.add(fillCel);
		
		
		add(body,BorderLayout.CENTER);
	}
	public void reset() {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				fillName.setText("");
				fillSurname.setText("");
				fillAddress.setText("");
				fillCel.setText("");
				
			}
		});
		this.repaint();
		this.revalidate();

	}
	
	public boolean check(Validator validator) {	
		if(validator.validData(fillName.getText(),"Le nom ") & validator.validData(fillSurname.getText(),"Le prenom") & validator.validData(fillAddress.getText(),"L'adresse") & validator.celValidator(fillCel.getText()))
				return true;
		return false;
	}
}
