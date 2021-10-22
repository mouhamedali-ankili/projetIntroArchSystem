package presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class UserAccount extends JPanel {
	private static final long serialVersionUID = 1L;
	JLabel text, email, currentPassword, newPassword, function, password;
	JTextField fillEmail;
	JPasswordField fillPassword;
	JComboBox<String> comboboxFunction;
	Table table;

	public UserAccount(Table table) {
		this.table = table;
		setLayout(new BorderLayout());
		JPanel header = new JPanel(new FlowLayout());
		header.setBackground(Color.decode("#33D1FF"));
		text = new JLabel("USER ACCOUNT");
		text.setForeground(Color.WHITE);
		text.setFont(new Font("Roboto", Font.ITALIC, 14));
		header.add(text);
		add(header, BorderLayout.NORTH);
		GridLayout gl = new GridLayout(6, 1);
		JPanel body = new JPanel(gl);
		body.setBackground(Color.decode("#33D1FF"));
		email = new JLabel("EMAIL");
		email.setForeground(Color.WHITE);
		email.setFont(new Font("Roboto", Font.ITALIC, 12));
		body.add(email);

		fillEmail = new JTextField();
		fillEmail.setPreferredSize(new Dimension(307, 30));
		body.add(fillEmail);

		password = new JLabel("MOT DE PASSE");
		password.setForeground(Color.WHITE);
		password.setFont(new Font("Roboto", Font.ITALIC, 12));
		body.add(password);

		fillPassword = new JPasswordField();
		body.add(fillPassword);

		function = new JLabel("FONCTION");
		function.setForeground(Color.WHITE);
		function.setFont(new Font("Roboto", Font.ITALIC, 12));
		body.add(function);

		comboboxFunction = new JComboBox<String>(new String[] { "visiteur simple",
				"editeur", "administrateur" });
		comboboxFunction.setFont(new Font("Roboto", Font.ITALIC, 12));
		body.add(comboboxFunction);

		add(body, BorderLayout.CENTER);

	}

	public void reset() {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				fillEmail.setText("");
				fillPassword.setText("");
				comboboxFunction.setSelectedIndex(0);

			}
		});
		this.repaint();
		this.revalidate();
	}

	@SuppressWarnings("deprecation")
	public boolean check(Validator validator) {
		if (validator.emailValidator(fillEmail.getText()) & validator.validPassword(fillPassword.getText())) {
			if (Table.checkDuplicateEmail(fillEmail.getText(), table.userList) == true) {
				validator.addError(validator.errorDuplicateEmail);
				return false;
			} else
				return true;
		}
		return false;

	}

}
