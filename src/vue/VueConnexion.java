package vue;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.RenderingHints.Key;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controleur.Castellane;
 
public class VueConnexion extends JFrame implements ActionListener, KeyListener
{
	private JPanel unPanel = new JPanel ();  
	private JTextField txtEmail = new JTextField(); 
	private JPasswordField txtMdp = new JPasswordField(); 
	private ImageIcon annuler = new ImageIcon("src/images/cancel.png");
	private JButton btAnnuler = new JButton(annuler);
	private ImageIcon seconnecter = new ImageIcon("src/images/login.jpg");
	private JButton btSeconnecter = new JButton(seconnecter);
	
	public VueConnexion()
	{
		this.setTitle("Connexion de la bdd Catellane ");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(200, 200, 800, 300);
		this.setLayout(null);
		this.getContentPane().setBackground(Color.gray);
		this.setResizable(false);
		
		//construction du Panel 
		this.unPanel.setBounds(350, 40, 400, 200);
		this.unPanel.setBackground(Color.LIGHT_GRAY);
		this.unPanel.setLayout(new GridLayout(3, 3));
		this.unPanel.add(new JLabel("Email : "));
		this.unPanel.add(this.txtEmail); 
		this.unPanel.add(new JLabel("MDP : ")); 
		this.unPanel.add(this.txtMdp); 
		this.unPanel.add(this.btAnnuler); 
		this.unPanel.add(this.btSeconnecter);
		
		this.add(this.unPanel);
		
		//changement de la police 
		Font unePolice = new Font("Arial", Font.ITALIC, 18); 
		for (int i =0; i <this.unPanel.getComponentCount(); i++)
		{
			this.unPanel.getComponent(i).setFont(unePolice);
		}
		//insertion du Logo 
		ImageIcon uneImage = new ImageIcon("src/images/logoCastellane.png"); 
		JLabel monImage = new JLabel(uneImage); 
		monImage.setBounds(40, 40, 260, 200);
		this.add(monImage);
		
		//rendre les deux boutons cliquables 
		this.btAnnuler.addActionListener(this);
		this.btSeconnecter.addActionListener(this);
		
		//rendre les Text champs ecoutables 
		this.txtEmail.addKeyListener(this);
		this.txtMdp.addKeyListener(this);
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btAnnuler) {
			this.txtEmail.setText("");
			this.txtMdp.setText("");
			} else if (e.getSource() == this.btSeconnecter) {
				this.SeConnecter();
			}
		}
	
	public void SeConnecter() {
		String email = this.txtEmail.getText(); 
		String mdp = new String (this.txtMdp.getPassword());
		//v�rifier la connexion : 
		Castellane.verifConnexion (email, mdp);
		this.txtEmail.setText("");
		this.txtMdp.setText("");
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER)
		{
			this.SeConnecter();
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}














