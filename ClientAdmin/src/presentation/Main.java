package presentation;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.formdev.flatlaf.FlatIntelliJLaf;

public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				try {
					UIManager.setLookAndFeel(new FlatIntelliJLaf());
				} catch (UnsupportedLookAndFeelException e) {
					e.printStackTrace();
				}
				Fenetre fenetre = new Fenetre();
				fenetre.getContentPane().requestFocusInWindow();
				fenetre.setVisible(true);

			}
		});
	}
}
