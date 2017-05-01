package edu.itla.boleteria;

import javax.swing.UIManager;

public class Sistema {
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		new InterfazGrafica().setVisible(true);
	}
}
