package presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import metier.Traitement;


public class AddUser extends JPanel {
	private static final long serialVersionUID = 1L;
	JPanel fill;
	JButton userManagement, logOut;
	JLabel addUser;
	JButton addUserButton, cancel;
	UserAccount ua;
	UserInformation ui;
	Table table;
	Traitement traitement = new Traitement();
	public AddUser(Table table) {
		this.table=table;
		setLayout(new BorderLayout(10, 10));
		setBackground(Color.WHITE);

		fill = new JPanel();
		fill.setPreferredSize(new Dimension(1000, 40));
		Box box = Box.createHorizontalBox();
		fill.add(box);
		fill.setBackground(Color.decode("#0A05FF"));
		add(fill, BorderLayout.NORTH);

		addUser = new JLabel("<HTML><U>ADD USER</U></HTML>");
		addUser.setForeground(Color.WHITE);
		addUser.setFont(new Font("Roboto", Font.ITALIC, 14));
		box.add(addUser);
		box.add(Box.createHorizontalStrut(500));
		userManagement = new JButton("USER MANAGEMENT");
		userManagement.setBackground(Color.decode("#0359FF"));
		userManagement.setForeground(Color.WHITE);
		logOut = new JButton("DECONNEXION");
		logOut.setForeground(Color.WHITE);
		logOut.setBackground(Color.decode("#0359FF"));
		userManagement.addActionListener(ac);
		logOut.addActionListener(ac);
		userManagement.setFont(new Font("Roboto", Font.ITALIC, 12));
		logOut.setFont(new Font("Roboto", Font.ITALIC, 12));
		userManagement.setMinimumSize(new Dimension(150, 30));
		userManagement.setMaximumSize(new Dimension(150, 30));
		userManagement.setPreferredSize(new Dimension(150, 30));
		logOut.setMinimumSize(new Dimension(150, 30));
		logOut.setPreferredSize(new Dimension(150, 30));
		logOut.setMaximumSize(new Dimension(150, 30));
		box.add(userManagement);
		box.add(Box.createVerticalGlue());
		box.add(Box.createHorizontalStrut(40));
		box.add(logOut);
		
		
		
		JPanel account =new JPanel();
		add(account,BorderLayout.CENTER);
		account.setLayout(new GridLayout(1,2));

		FlowLayout flow = new FlowLayout();
		flow.setHgap(40);
		flow.setVgap(20);
		JPanel west = new JPanel(flow);
		west.setBackground(Color.WHITE);
		west.setPreferredSize(new Dimension(500, 500));

		JPanel childWest = new JPanel();
		childWest.setPreferredSize(new Dimension(400, 400));
		childWest.setBackground(Color.decode("#33D1FF"));
		west.add(childWest);
		ui = new UserInformation();
		ui.setPreferredSize(new Dimension(300, 375));
		childWest.add(ui);
		account.add(west);

		JPanel east = new JPanel(flow);
		east.setBackground(Color.WHITE);
		east.setPreferredSize(new Dimension(500, 500));

		JPanel childEast = new JPanel();
		childEast.setPreferredSize(new Dimension(400, 300));
		childEast.setBackground(Color.decode("#33D1FF"));
		east.add(childEast);
		ua = new UserAccount(table);
		ua.setPreferredSize(new Dimension(300, 250));
		childEast.add(ua);
		account.add(east);

		addUserButton = new JButton("ADD USER");
		addUserButton.setForeground(Color.WHITE);
		addUser.setForeground(Color.WHITE);
		addUserButton.setBackground(Color.decode("#0359FF"));
		addUserButton.setFont(new Font("Roboto", Font.ITALIC, 12));
		addUserButton.setPreferredSize(new Dimension(100, 30));
		addUserButton.addActionListener(ac);
		east.add(addUserButton);

		cancel = new JButton("ANNULER");
		cancel.setForeground(Color.WHITE);
		cancel.setBackground(Color.decode("#0359FF"));
		cancel.setFont(new Font("Roboto", Font.ITALIC, 12));
		cancel.setPreferredSize(new Dimension(100, 30));
		cancel.addActionListener(ac);
		east.add(cancel);

	}

	ActionListener ac = new ActionListener() {

		@SuppressWarnings("deprecation")
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == userManagement) {
				init();
				Fenetre.cl.previous(Fenetre.c);
			}
			if (e.getSource() == logOut) {
				init();
				Fenetre.cl.first(Fenetre.c);
				Fenetre.connexion.actionLogOut();
			}
			if (e.getSource() == cancel) {
				init();
			}
			if (e.getSource() == addUserButton) {
				Validator validator = new Validator();
				if (ua.check(validator) & ui.check(validator)) {
					try {
						if(traitement.addUser(ui.fillName.getText(),ui.fillSurname.getText(),ui.fillAddress.getText(),Long.parseLong(String.valueOf(ui.fillCel.getText())),ua.fillEmail.getText(),ua.fillPassword.getText(),ua.comboboxFunction.getSelectedItem().toString())){			
							JOptionPane.showMessageDialog(null,"Ajout Effectuée avec Succes !","Ajout Reussi",JOptionPane.INFORMATION_MESSAGE);
							System.out.println(okAddUser());
							table.model.addRow(new Object[]{ui.fillName.getText(),ui.fillSurname.getText(),ui.fillAddress.getText(),ui.fillCel.getText(),ua.fillEmail.getText(),ua.comboboxFunction.getSelectedItem()});
							table.repaint();
							table.revalidate();
							
							ua.reset();
							ui.reset();
							table.refreshTable();
						}
						else
							JOptionPane.showMessageDialog(null,"Erreur lors de l'ajout , \n veuillez réessayer ","ECHEC !",JOptionPane.ERROR_MESSAGE);
					} catch (NumberFormatException | HeadlessException
							| RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	
				}
					else {
					JOptionPane.showMessageDialog(null,validator.getError(),"SAISIES ERRONEES",JOptionPane.ERROR_MESSAGE);

				}
				
			validator.init();
			}
		}
	};
	@SuppressWarnings("deprecation")
	public String okAddUser() {
		
		return "AJOUT D'UN UTILISATEUR...\n\tNOM: "+ui.fillName.getText()+"\n\tPRENOM: "+ui.fillSurname.getText()+"\n\tPASSWORD: "+ua.fillPassword.getText()+"\n\tADDRESSE: "+ui.fillAddress.getText()+"\n\tEMAIL: "+ua.fillEmail.getText()+"\n\tFONCTION: "+ua.comboboxFunction.toString()+"\n\tTELEPHONE: "+ui.fillCel.getText()+"\n\n";
	}
	
	private void init() {
		ua.reset();
		ui.reset();
		repaint();
		revalidate();

	}
}
