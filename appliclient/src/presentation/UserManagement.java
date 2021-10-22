package presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class UserManagement extends JPanel {
	private static final long serialVersionUID = 1L;
	JLabel label,text,searchIcon;
	JButton addUser,logOut,search;
	JPanel fill;
	Table table;
	JTextField fillSearch;
	public UserManagement() {
		
		setLayout(new BorderLayout(20,30));
		setBackground(Color.WHITE);
		label = new JLabel("<HTML><U>USER MANAGEMENT</U></HTML>");
		label.setFont(new Font("Roboto", Font.ITALIC, 14));
		label.setForeground(Color.WHITE);

		
		Box box=Box.createHorizontalBox();
		fill=new JPanel();
		fill.add(box);
		fill.setPreferredSize(new Dimension(1000,40));
		fill.setBackground(Color.decode("#0A05FF"));
		
		add(fill,BorderLayout.NORTH);
		box.add(label);
		box.add(Box.createHorizontalStrut(70));
		
		fillSearch=new JTextField();
		fillSearch.getDocument().addDocumentListener(dl);
		fillSearch.setFont(new Font("Roboto", Font.ITALIC, 14));
		fillSearch.setLayout(new FlowLayout(FlowLayout.RIGHT,0,0));
		fillSearch.setBackground(Color.WHITE);
		
		
		
		box.add(Box.createGlue());
		try {
			searchIcon = new JLabel(new ImageIcon(ImageIO.read(getClass().getResource("/search20.png"))));
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		
		fillSearch.add(searchIcon);
		
		box.add(fillSearch);
		fillSearch.setPreferredSize(new Dimension(300,30));

		box.add(Box.createHorizontalStrut(70));
	
	
		addUser =new JButton("ADD USER");
		logOut=new JButton("LOG OUT");
		
		
		addUser.addActionListener(ac);
		addUser.setForeground(Color.WHITE);
		addUser.setFont(new Font("Roboto", Font.ITALIC, 14));
		addUser.setBackground(Color.decode("#0359FF"));
		
		
		logOut.setForeground(Color.WHITE);
		logOut.setFont(new Font("Roboto", Font.ITALIC, 14));
		logOut.addActionListener(ac);
		logOut.setBackground(Color.decode("#0359FF"));
		
		box.add(addUser);
		box.add(Box.createHorizontalStrut(30));
		box.add(logOut);
		
	
		
		
		table = new Table(this);
		add(table,BorderLayout.CENTER);
		
		
		
		
	}
	DocumentListener dl = new DocumentListener() {
		
		  @Override
	        public void insertUpdate(DocumentEvent e) {
			  if(fillSearch.getText().trim().length()!=0)
				  table.insert(fillSearch.getText());
	        }

	        @Override
	        public void removeUpdate(DocumentEvent e) {
	            table.update(fillSearch.getText());
	            
	        }

	        @Override
	        public void changedUpdate(DocumentEvent e) {
	            table.changed();
	        }
	};

      public void cleanFillSearch(){
    	  fillSearch.setText(""); 
      }
      public void refreshFocus() {
    	  requestFocusInWindow();
    	  requestFocus();
    	  table.requestFocus();
      }
     public void actionLogOut() {
    	 SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				fillSearch.setText("");
				table.update("");
				
			}
		});
     }
     
	ActionListener ac = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==logOut) {
				actionLogOut();
				refreshFocus();
				Fenetre.cl.previous(Fenetre.c);
				Fenetre.connexion.actionLogOut();
			}
			if(e.getSource()==addUser) {
				Fenetre.c.add("Add User", new AddUser(table));
				Fenetre.cl.next(Fenetre.c);
			}
			
		}
	};
	
	

}
