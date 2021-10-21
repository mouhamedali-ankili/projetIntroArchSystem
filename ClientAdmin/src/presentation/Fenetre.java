package presentation;

import java.awt.CardLayout;
import java.awt.Container;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Fenetre extends JFrame {
	private static final long serialVersionUID = 1L;
	protected static CardLayout cl;
	protected static Container c;
	static Connexion connexion;

	public Fenetre() {
		this.setTitle("User Management App");
		this.setSize(1000, 600);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		try {
			this.setIconImage(ImageIO.read(Fenetre.class.getResource("/administrator.png")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		cl = new CardLayout();
		c = new Container();
		c.setLayout(cl);
		this.setContentPane(c);
		connexion = new Connexion();
		c.add("ACCUEIL", connexion);

	}

}
