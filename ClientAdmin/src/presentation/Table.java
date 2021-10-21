package presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.rmi.RemoteException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import metier.Traitement;

public class Table extends JPanel {
	private static final long serialVersionUID = 1L;
	JButton modify, delete, cancel, searchButton;
	JLabel searchIcon;
	JTable userList;
	JTextField tf;
	JPanel panelUsersList;
	DefaultTableModel model;
	TableRowSorter<TableModel> rowSorter;
	UserManagement um;
	Traitement traitement = new Traitement();
	integration.Utilisateur[] users = null;
	String title[] = {"NOM", "PRENOM", "ADRESSE", "TELEPHONE",
			"EMAIL", "FONCTION","PASSWORD","ID" };

	public Table(UserManagement um) {
		this.um = um;
		setBackground(Color.WHITE);
		setLayout(new BorderLayout(20, 30));

		JPanel control = new JPanel(new FlowLayout(FlowLayout.RIGHT, 50, 0));
		control.setBackground(Color.WHITE);
		modify = new JButton("MODIFIER");

		modify.setBackground(Color.decode("#0359FF"));
		modify.setFont(new Font("Roboto", Font.ITALIC, 14));
		modify.setForeground(Color.WHITE);
		modify.addActionListener(ac);
		control.add(modify);

		cancel = new JButton("ANNULER");
		cancel.addActionListener(ac);
		cancel.setForeground(Color.WHITE);
		cancel.setFont(new Font("Roboto", Font.ITALIC, 14));
		cancel.setBackground(Color.decode("#0359FF"));
		cancel.addActionListener(ac);
		control.add(cancel);

		delete = new JButton("SUPPRIMER");
		delete.setForeground(Color.WHITE);
		delete.addActionListener(ac);
		delete.setFont(new Font("Roboto", Font.ITALIC, 14));
		delete.setBackground(Color.decode("#0359FF"));
		control.add(delete);
		add(control, BorderLayout.NORTH);
		panelUsersList = new JPanel();
		panelUsersList.setBounds(0, 55, 990, 428);
		panelUsersList.setLayout(new BorderLayout());
		add(panelUsersList, BorderLayout.CENTER);

		try {
			users = traitement.allUser();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Object[][] data = null;

		model = new DefaultTableModel(data, title);
		for (int i = 0; i < users.length; i++)
			model.addRow(new Object[] {  users[i].getNom(),
					users[i].getPrenom(), users[i].getAdresse(),
					users[i].getTelephone(), users[i].getEmail(),
					users[i].getFonction(),users[i].getMot_de_passe(),users[i].getId() });
		
		
		userList = new JTable(model) {
			@Override
			 public Component prepareRenderer(TableCellRenderer renderer, int
			 row, int column) {
			 Component comp = super.prepareRenderer(renderer, row, column);
			 Color alternateColor = Color.decode("#33D1FF");
			 Color whiteColor = Color.WHITE;
			 if (!comp.getBackground().equals(getSelectionBackground())) {
			 Color c, f;
			 if (row % 2 == 0) {
			 f=Color.WHITE;
			 c = alternateColor;			 
			 } else {
			 c = whiteColor;
			 f=Color.BLACK;
			 }
			 comp.setBackground(c);
			 comp.setForeground(f);
			 setFont(new Font("Roboto", Font.ITALIC, 12));
			 c = null;
			 }
			 return comp;
			 }

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return getModel().isCellEditable(row,
						convertColumnIndexToModel(column));
			}

		};
		rowSorter = new TableRowSorter<TableModel>(model);

		userList.setDefaultEditor(Object.class, null);
		userList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		userList.getTableHeader().setBackground(Color.decode("#0A05FF"));
		userList.getTableHeader().setForeground(Color.WHITE);
		userList.getTableHeader().setFont(new Font("Roboto", Font.ITALIC, 14));
		userList.setShowHorizontalLines(true);
		userList.setShowVerticalLines(true);
		userList.setBackground(Color.WHITE);
		panelUsersList.add(new JScrollPane(userList), BorderLayout.CENTER);
		userList.setRowSorter(rowSorter);
		userList.removeColumn(userList.getColumnModel().getColumn(userList.getModel().getColumnCount()-1));
		userList.removeColumn(userList.getColumnModel().getColumn(userList.getModel().getColumnCount()-2));
		
		
		//userList.setAutoCreateColumnsFromModel( false );
		
		
	}

	public void refreshTable(){

		model.setRowCount(0);

		try {
			users = traitement.allUser();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < users.length; i++)
			model.addRow(new Object[] {  users[i].getNom(),
					users[i].getPrenom(), users[i].getAdresse(),
					users[i].getTelephone(), users[i].getEmail(),
					users[i].getFonction(),users[i].getMot_de_passe(),users[i].getId() });
	
		

		
	}
	public static boolean checkDuplicateEmail(String email, int target,
			JTable table) {

		for (int i = 0; i < table.getRowCount(); i++) {
			if (i == target)
				continue;
			if (email.equals(table.getValueAt(i, 4).toString())) {
				return true;
			}
		}

		return false;
	}

	public static boolean checkDuplicateEmail(String email, JTable table) {

		for (int i = 0; i < table.getRowCount(); i++) {
			if (email.equals(table.getValueAt(i, 4).toString())) {
				return true;
			}
		}

		return false;
	}


	public void changed() {
		throw new UnsupportedOperationException("Non pris en charge");
	}

	public void insert(String text) {

		if (text.trim().length() == 0) {
			rowSorter.setRowFilter(null);
		} else {
			rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text, 1));
		}
	}

	public void update(String text) {
		if (text.trim().length() == 0) {
			rowSorter.setRowFilter(null);
		} else {
			rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
		}
	}

	ActionListener ac = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == modify) {
				if (userList.getSelectedRow() == -1) {
					// Aucun truc selectionné
				} else {
					@SuppressWarnings("unused")
					ModifyUser modifyUser = new ModifyUser(userList,
							userList.getSelectedRow());

				}
			}

			if (e.getSource() == cancel) {
				requestFocus();
				um.cleanFillSearch();

			}
			if (e.getSource() == delete) {
				int lineSelected = userList.getSelectedRow();
				if (lineSelected == -1) {
					// "Aucun truc selectionné pour supprimer;
				} else {
					int a = JOptionPane.showConfirmDialog(null,
							"Voulez vous supprimer cet utilisateur ?",
							"Supprimer Utilisateur",
							JOptionPane.YES_NO_CANCEL_OPTION);
					if (a == JOptionPane.YES_OPTION) {
						try {
							if (traitement.deleteUser(Integer.parseInt(userList.getModel()
									.getValueAt(lineSelected, 7).toString()))) {
								model.removeRow(lineSelected);
								try {
									JOptionPane
											.showMessageDialog(
													null,
													" Suppression effectuée avec succes ! ",
													"Suppression Utilisateur",
													JOptionPane.OK_OPTION,
													new ImageIcon(
															ImageIO.read(getClass()
																	.getResource(
																			"/remove.png"))));
								} catch (HeadlessException | IOException e1) {
									e1.printStackTrace();
								}

							}
							else
								JOptionPane.showMessageDialog(null,"Erreur lors de la suppression ,veuillez réessayer","ECHEC",JOptionPane.ERROR_MESSAGE);
						} catch (NumberFormatException | RemoteException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}

			}
		}

	};

}
