package presentation;

import integration.Utilisateur;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.rmi.RemoteException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import metier.Traitement;

public class Connexion extends JPanel {
	private static final long serialVersionUID = 1L;
	MyRoundedPanel cadre;
	JLabel texte, iconeEmail, iconePassword;
	MyTextFieldWithHint email;
	MyPasswordFieldWithHint password;
	JButton connexion, invisible, effacer;
	int compteurDeClick = 0;
	Traitement traitement;
	public Connexion() {
		cadre = new MyRoundedPanel(530, 250);
		cadre.setBackground(Color.WHITE);
		cadre.setLayout(null);

		texte = new JLabel("<HTML><U>WELCOME TO USER MANAGEMENT APP</U></HTML>");
		texte.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		texte.setFont(new Font("Roboto", Font.ITALIC, 26));
		texte.setForeground(Color.WHITE);

		setLayout(null);
		texte.setBounds(122, 60, 470, 80);
		cadre.setBounds(350, 210, 530, 250);
		add(texte);
		add(cadre);

		email = new MyTextFieldWithHint("LOGIN");
		email.setFont(new Font("Roboto", Font.ITALIC, 14));
		email.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode("#3387FF")));

		password = new MyPasswordFieldWithHint("PASSWORD");
		password.setFont(new Font("Roboto", Font.ITALIC, 14));
		password.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode("#3387FF")));

		email.setBounds(64, 50, 400, 20);
		password.setBounds(64, 100, 400, 20);
		cadre.add(email);
		cadre.add(password);

		connexion = new JButton("CONNEXION");
		effacer = new JButton("EFFACER");
		connexion.addActionListener(ac);
		effacer.addActionListener(ac);
		connexion.setForeground(Color.WHITE);
		effacer.setForeground(Color.WHITE);
		connexion.setFont(new Font("Roboto", Font.ITALIC, 14));
		effacer.setFont(new Font("Roboto", Font.ITALIC, 14));
		connexion.setBackground(Color.decode("#0359FF"));
		effacer.setBackground(Color.decode("#0359FF"));
		effacer.setBounds(212, 170, 125, 30);
		connexion.setBounds(342, 170, 125, 30);
		cadre.add(connexion);
		cadre.add(effacer);

		try {
			iconeEmail = new JLabel(new ImageIcon(ImageIO.read(getClass().getResource("/email.jpg"))));
			iconePassword = new JLabel(new ImageIcon(ImageIO.read(getClass().getResource("/password.png"))));
			invisible = new JButton(new ImageIcon(ImageIO.read(getClass().getResource("/invisible.png"))));
		} catch (IOException e) {
			e.printStackTrace();
		}

		iconeEmail.setBounds(28, 46, 30, 30);
		iconePassword.setBounds(28, 95, 30, 30);
		invisible.setBounds(450, 100, 50, 20);
		invisible.setBorder(null);
		invisible.addActionListener(ac);
		cadre.add(iconeEmail);
		cadre.add(iconePassword);
		cadre.add(invisible);

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				requestFocus();

			}
		});
	}

	@Override
	protected void paintComponent(Graphics g) {
		g.setColor(Color.decode("#3387FF"));
		g.fillRect(0, 0, 500, 600);
		g.setColor(Color.decode("#038D1FF"));
		g.fillRect(500, 0, 500, 600);

	}

	ActionListener ac = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == invisible) {
				if (compteurDeClick % 2 == 0) {

					try {
						invisible.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/visible.png"))));
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					password.setEchoChar((char) 0);

				} else {
					try {
						invisible.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/invisible.png"))));
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					password.setEchoChar('\u25CF');

				}
				compteurDeClick++;
			}

			if (e.getSource() == connexion) {
				Validator validator = new Validator();
				traitement = new Traitement();
				if (!checkUser(validator))
					JOptionPane.showMessageDialog(cadre,validator.getError(), "Identifiants incorrects",
							JOptionPane.ERROR_MESSAGE);
				else {
					try {
						@SuppressWarnings("deprecation")
						Utilisateur user = traitement.authentification(email.getText(), password.getText());
						if(user != null){
								System.out.println(connected());
								Fenetre.c.add("User Management", new UserManagement());
								Fenetre.cl.next(Fenetre.c);
								}
						else{
							JOptionPane.showMessageDialog(cadre,"Identifiants Incorrects !","erreur",JOptionPane.ERROR_MESSAGE);
						}
					} catch (HeadlessException | RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					}
			
			validator.init();
			}
			if (e.getSource() == effacer) {
				email.setText("");
				password.setText("");
			}

		}

	};
	
	@SuppressWarnings("deprecation")
	public String connected() {
		return "CONNEXION EN COURS...\n\tUTILISATEUR: "+email.getText()+"\n\tPASSWORD :"+password.getText()+"\n\n";
	}
	
	@SuppressWarnings("deprecation")
	private boolean checkUser(Validator validator) {
		if (validator.emailValidator(email.getText()) & validator.validPassword(password.getText()))
		{
			return true;
		} 
		else {
			return false;
		}
	}
	
	
	public void actionLogOut() {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				email.setText(email.getPlaceHolder());
				password.setText(password.getPlaceHolder());
				password.setEchoChar('\0');
			}
		});
	}
		
}
