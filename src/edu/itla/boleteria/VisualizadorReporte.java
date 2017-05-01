package edu.itla.boleteria;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class VisualizadorReporte extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	public VisualizadorReporte(String datos) {
		
		setTitle("Reporte");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		JTextArea txtAreaReporte = new JTextArea();
		txtAreaReporte.setText(datos);
		txtAreaReporte.setEditable(false);
		
		JScrollPane scrollPane = new JScrollPane(txtAreaReporte);
		scrollPane.setBounds(10, 11, 474, 419);
		contentPane.add(scrollPane);
	}
}
