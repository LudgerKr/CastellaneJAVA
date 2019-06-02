package vue;

import java.awt.Color;

import javax.swing.JPanel;

public class PanelCentral extends JPanel {
	
	public PanelCentral() {
		this.setBounds(250, 40, 450, 250);
		this.setBackground(Color.cyan);
		this.setLayout(null);
		
		this.setVisible(false);
	}
}