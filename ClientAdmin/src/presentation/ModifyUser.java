package presentation;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.HashSet;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import metier.Traitement;

public class ModifyUser extends JDialog {
	private static final long serialVersionUID = 1L;
	JLabel id, name, surname, address, cel, email, function;
	JTextField seeId, fillName, fillSurname, fillAddress, fillCel, fillEmail;
	@SuppressWarnings("rawtypes")
	JComboBox fillFunction;
	JButton save, cancel;
	JTable table;
	int rowSelected;
	Traitement traitement = new Traitement();
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ModifyUser(JTable table, int rowSelected) {
		this.rowSelected = rowSelected;
		this.table = table;
		this.setTitle("Modifier Utilisateur");
		this.setAlwaysOnTop(true);
		this.setModal(true);
		this.setSize(new Dimension(400, 400));
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		JPanel data = new JPanel();
		this.add(data, BorderLayout.CENTER);
		data.setLayout(new GridLayout(12, 1));
		name = new JLabel("NOM");
		data.add(name);
		fillName = new JTextField(table.getValueAt(rowSelected, 0).toString());
		data.add(fillName);
		surname = new JLabel("PRENOM");
		data.add(surname);
		fillSurname = new JTextField(table.getValueAt(rowSelected, 1)
				.toString());
		data.add(fillSurname);
		address = new JLabel("ADDRESSE");
		data.add(address);
		fillAddress = new JTextField(table.getValueAt(rowSelected, 2)
				.toString());
		data.add(fillAddress);
		cel = new JLabel("TELEPHONE");
		data.add(cel);
		fillCel = new JTextField(table.getValueAt(rowSelected, 3).toString());
		data.add(fillCel);
		email = new JLabel("EMAIL");
		data.add(email);
		fillEmail = new JTextField(table.getValueAt(rowSelected, 4).toString());
		data.add(fillEmail);
		function = new JLabel("FONCTION");
		data.add(function);

		HashSet<String> values = new HashSet<String>();
		values.add(table.getModel().getValueAt(rowSelected, 5).toString());
		values.add("editeur");
		values.add("administrateur");
		values.add("visiteur simple");

		fillFunction = new JComboBox(values.toArray());

		fillFunction.setSelectedItem(table.getValueAt(rowSelected, 5)
				.toString());
		;
		data.add(fillFunction);
		JPanel control = new JPanel();
		this.add(control, BorderLayout.SOUTH);
		FlowLayout fl = new FlowLayout();
		control.setLayout(fl);
		fl.setVgap(20);
		cancel = new JButton("ANNULER");
		cancel.addActionListener(ac);
		control.add(cancel);
		save = new JButton("MODIFIER");
		save.addActionListener(ac);
		control.add(save);
		this.setVisible(true);
	}

	ActionListener ac = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == cancel) {
				setVisible(false);
			}
			if (e.getSource() == save) {
				if (validator()) {
					setVisible(false);
					try {
						
						int id= Integer.parseInt(String.valueOf(table.getModel().getValueAt(rowSelected, 7).toString()));
						System.err.println(id);
						String name = String.valueOf(fillName.getText());
						System.err.println(name);
						String surname=String.valueOf(fillSurname.getText());
						System.err.println(surname);
						String address =String.valueOf(fillAddress.getText());
						System.err.println(address);
						long cel =Long.parseLong(fillCel.getText());
						System.err.println(cel);
						String email=String.valueOf(fillEmail.getText());
						System.err.println(email);
						String function=String.valueOf(fillFunction.getSelectedItem().toString());
						System.err.println(function);
						String password=String.valueOf(table.getModel().getValueAt(rowSelected, 6));
						System.err.println(password);
						if (traitement.modifyUser(id, name, surname, address, cel, email, password, function)== true)
						{
							JOptionPane.showMessageDialog(null,
									"MODIFICATION REUSSIE !", "Modifier",
									JOptionPane.INFORMATION_MESSAGE);
							table.setValueAt(fillName.getText(), rowSelected, 0);
							table.setValueAt(fillSurname.getText(),
									rowSelected, 1);
							table.setValueAt(fillAddress.getText(),
									rowSelected, 2);
							table.setValueAt(fillCel.getText(), rowSelected, 3);
							table.setValueAt(fillEmail.getText(), rowSelected,
									4);
							table.setValueAt(fillFunction.getSelectedItem(),
									rowSelected, 5);
							System.out.println(modified());
							
						}
						else{
							JOptionPane.showMessageDialog(null,"Erreur lors de la modification \n Veuillez réessayer ! ","ECHEC",JOptionPane.ERROR_MESSAGE);
						}
					} catch (NumberFormatException | HeadlessException
							| RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}

			}
		}
	};

	public String modified() {
		return "MODIFICATION EN COURS...\n\tNOM :" + fillName.getText()
				+ "\n\tPRENOM :" + fillSurname.getText() + "\n\tADDRESSE :"
				+ fillAddress.getText() + "\n\tTELEPHONE :" + fillCel.getText()
				+ "\n\tEMAIL :" + fillEmail.getText() + "\n\tFONCTION :"
				+ fillFunction.getSelectedItem().toString() + "\n\n";
	}

	private boolean validator() {
		boolean validate = true;
		Validator validator = new Validator();
		validate = validator.emailValidator(fillEmail.getText());
		if (Table.checkDuplicateEmail(fillEmail.getText(), rowSelected, table)) {
			validator
					.addError("Email déja Utilisé ,veuillez Choisir un autre \n");
		}
		if (!validator.validData(fillName.getText(), "Le nom"))
			validate = false;
		if (!validator.validData(fillSurname.getText(), "Le prenom"))
			validate = false;
		if (!validator.validData(fillAddress.getText(), "l'adresse"))
			validate = false;
		if (!validator.celValidator(fillCel.getText()))
			validate = false;

		if (!validate) {
			JOptionPane.showMessageDialog(this, validator.getError(),
					"SAISIES INCORRECTES", JOptionPane.ERROR_MESSAGE);
		}
		validator.init();
		return validate;
	}

}
