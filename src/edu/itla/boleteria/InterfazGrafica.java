package edu.itla.boleteria;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class InterfazGrafica extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox<String> cbRutas;
	private JComboBox<String> cbCantidad;
	private JComboBox<String> cbTipo;
	Rutas ruta1 = new Rutas("Santo Domingo - Santiago", new Boletas("Estandar", 10, "50"),
			new Boletas("Especial", 10, "100"), new Boletas("VIP", 10, "150"));
	Rutas ruta2 = new Rutas("Santo Domingo - Punta Cana", new Boletas("Estandar", 10, "50"),
			new Boletas("Especial", 10, "100"), new Boletas("VIP", 10, "150"));
	Rutas ruta3 = new Rutas("Santo Domingo - Puerto Plata", new Boletas("Estandar", 10, "50"),
			new Boletas("Especial", 10, "100"), new Boletas("VIP", 10, "150"));
	
	public InterfazGrafica() {
		
		setTitle("Sistema de Boleteria");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 635, 181);
		setResizable(false);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnReporte = new JMenu("Reporte");
		menuBar.add(mnReporte);
		
		JMenuItem mntmVerReporte = new JMenuItem("Ver reporte");
		mntmVerReporte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String datos;
				int boletasVendidas;
				
				datos = ruta1.getNombre() + "\n\n";
				boletasVendidas = 10 - ruta1.getTipo1().getCantidadBoleta();
				datos = datos + "Tipo Boleta \t Boletas Vendidas \t Total Vendido\n";
				datos = datos + ruta1.getTipo1().getTipoBoleta() + "\t\t" + boletasVendidas + "\t\t\t" + (boletasVendidas * Integer.parseInt(ruta1.getTipo1().getPrecio())) + "\n"; 
				boletasVendidas = 10 - ruta1.getTipo2().getCantidadBoleta();
				datos = datos + ruta1.getTipo2().getTipoBoleta() + "\t\t" + boletasVendidas + "\t\t\t" + (boletasVendidas * Integer.parseInt(ruta1.getTipo2().getPrecio())) + "\n"; 
				boletasVendidas = 10 - ruta1.getTipo3().getCantidadBoleta();
				datos = datos + ruta1.getTipo3().getTipoBoleta() + "\t\t\t" + boletasVendidas + "\t\t\t" + (boletasVendidas * Integer.parseInt(ruta1.getTipo3().getPrecio())) + "\n\n";
				datos = datos + ruta2.getNombre() + "\n\n";
				datos = datos + "Tipo Boleta \t Boletas Vendidas \t Total Vendido\n";
				boletasVendidas = 10 - ruta2.getTipo1().getCantidadBoleta();
				datos = datos + ruta2.getTipo1().getTipoBoleta() + "\t\t" + boletasVendidas + "\t\t\t" + (boletasVendidas * Integer.parseInt(ruta2.getTipo1().getPrecio())) + "\n";
				boletasVendidas = 10 - ruta2.getTipo2().getCantidadBoleta();
				datos = datos + ruta2.getTipo2().getTipoBoleta() + "\t\t" + boletasVendidas + "\t\t\t" + (boletasVendidas * Integer.parseInt(ruta2.getTipo2().getPrecio())) + "\n";
				boletasVendidas = 10 - ruta2.getTipo3().getCantidadBoleta();
				datos = datos + ruta2.getTipo3().getTipoBoleta() + "\t\t\t" + boletasVendidas + "\t\t\t" + (boletasVendidas * Integer.parseInt(ruta2.getTipo3().getPrecio())) + "\n\n";
				datos = datos + ruta3.getNombre() + "\n\n";
				datos = datos + "Tipo Boleta \t Boletas Vendidas \t Total Vendido\n";
				boletasVendidas = 10 - ruta3.getTipo1().getCantidadBoleta();
				datos = datos + ruta3.getTipo1().getTipoBoleta() + "\t\t" + boletasVendidas + "\t\t\t" + (boletasVendidas * Integer.parseInt(ruta3.getTipo1().getPrecio())) + "\n";
				boletasVendidas = 10 - ruta3.getTipo2().getCantidadBoleta();
				datos = datos + ruta3.getTipo2().getTipoBoleta() + "\t\t" + boletasVendidas + "\t\t\t" + (boletasVendidas * Integer.parseInt(ruta3.getTipo2().getPrecio())) + "\n";
				boletasVendidas = 10 - ruta3.getTipo3().getCantidadBoleta();
				datos = datos + ruta3.getTipo3().getTipoBoleta() + "\t\t\t" + boletasVendidas + "\t\t\t" + (boletasVendidas * Integer.parseInt(ruta3.getTipo3().getPrecio())) + "\n\n";
				new Impresora().imprimirReporte(datos);
				new VisualizadorReporte(datos).setVisible(true);
			}
		});
		mnReporte.add(mntmVerReporte);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRutas = new JLabel("Rutas");
		lblRutas.setBounds(10, 37, 46, 14);
		contentPane.add(lblRutas);
		
		String[] rutas = {"Seleccione", ruta1.getNombre(), ruta2.getNombre(), ruta3.getNombre()};
		DefaultComboBoxModel<String> modelocbRutas = new DefaultComboBoxModel<String>(rutas);
		cbRutas = new JComboBox<String>(modelocbRutas);
		cbRutas.setBounds(10, 62, 192, 20);
		contentPane.add(cbRutas);
		
		JLabel lblPrecioDeBolestas = new JLabel("Cantidad de Boletas");
		lblPrecioDeBolestas.setBounds(364, 37, 107, 14);
		contentPane.add(lblPrecioDeBolestas);
		
		String[] cantidad = {"Seleccione", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
		DefaultComboBoxModel<String> modelocbCantidad = new DefaultComboBoxModel<String>(cantidad);
		cbCantidad = new JComboBox<String>(modelocbCantidad);
		cbCantidad.setBounds(364, 62, 94, 20);
		contentPane.add(cbCantidad);
		
		JButton btnComprar = new JButton("Comprar");
		btnComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int indiceRuta = cbRutas.getSelectedIndex();
				int indiceCantidad = cbCantidad.getSelectedIndex();
				int indiceTipo = cbTipo.getSelectedIndex();
				
				if (indiceRuta == 0) {
					JOptionPane.showMessageDialog(InterfazGrafica.this, "Seleccione una ruta", 
							"Advertencia", JOptionPane.WARNING_MESSAGE);
					return;
				} else if (indiceCantidad == 0) {
					JOptionPane.showMessageDialog(InterfazGrafica.this, "Seleccione una cantidad", 
							"Advertencia", JOptionPane.WARNING_MESSAGE);
					return;
				} else if (indiceTipo == 0) {
					JOptionPane.showMessageDialog(InterfazGrafica.this, "Seleccione un tipo", 
							"Advertencia", JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				switch(indiceRuta) {
				case 1:
					switch(indiceTipo) {
					case 1:
						if (ruta1.getTipo1().getCantidadBoleta() == 0) {
							JOptionPane.showMessageDialog(InterfazGrafica.this, "Boletas Agotadas", 
									"Información", JOptionPane.INFORMATION_MESSAGE);
							return;
						} else if((ruta1.getTipo1().getCantidadBoleta() - indiceCantidad) < 0) {
							JOptionPane.showMessageDialog(InterfazGrafica.this, "Solo hay disponibles " + ruta1.getTipo1().getCantidadBoleta() + " boletas", 
									"Información", JOptionPane.INFORMATION_MESSAGE);
							return;
						}
						ruta1.getTipo1().setCantidadBoleta((ruta1.getTipo1().getCantidadBoleta() - indiceCantidad));
						JOptionPane.showMessageDialog(InterfazGrafica.this, "Transaccion Realizada Correctamente", 
								"Información", JOptionPane.INFORMATION_MESSAGE);
						break;
					case 2:
						if (ruta1.getTipo2().getCantidadBoleta() == 0) {
							JOptionPane.showMessageDialog(InterfazGrafica.this, "Boletas Agotadas", 
									"Información", JOptionPane.INFORMATION_MESSAGE);
							return;
						} else if((ruta1.getTipo2().getCantidadBoleta() - indiceCantidad) < 0) {
							JOptionPane.showMessageDialog(InterfazGrafica.this, "Solo hay disponibles " + ruta1.getTipo2().getCantidadBoleta() + " boletas", 
									"Información", JOptionPane.INFORMATION_MESSAGE);
							return;
						}
						ruta1.getTipo2().setCantidadBoleta((ruta1.getTipo2().getCantidadBoleta() - indiceCantidad));
						JOptionPane.showMessageDialog(InterfazGrafica.this, "Transaccion Realizada Correctamente", 
								"Información", JOptionPane.INFORMATION_MESSAGE);
						break;
					case 3:
						if (ruta1.getTipo3().getCantidadBoleta() == 0) {
							JOptionPane.showMessageDialog(InterfazGrafica.this, "Boletas Agotadas", 
									"Información", JOptionPane.INFORMATION_MESSAGE);
							return;
						} else if((ruta1.getTipo3().getCantidadBoleta() - indiceCantidad) < 0) {
							JOptionPane.showMessageDialog(InterfazGrafica.this, "Solo hay disponibles " + ruta1.getTipo3().getCantidadBoleta() + " boletas", 
									"Información", JOptionPane.INFORMATION_MESSAGE);
							return;
						}
						ruta1.getTipo3().setCantidadBoleta((ruta1.getTipo3().getCantidadBoleta() - indiceCantidad));
						JOptionPane.showMessageDialog(InterfazGrafica.this, "Transaccion Realizada Correctamente", 
								"Información", JOptionPane.INFORMATION_MESSAGE);
						break;
					}
					break;
				case 2:
					switch(indiceTipo) {
					case 1:
						if (ruta2.getTipo1().getCantidadBoleta() == 0) {
							JOptionPane.showMessageDialog(InterfazGrafica.this, "Boletas Agotadas", 
									"Información", JOptionPane.INFORMATION_MESSAGE);
							return;
						} else if((ruta2.getTipo1().getCantidadBoleta() - indiceCantidad) < 0) {
							JOptionPane.showMessageDialog(InterfazGrafica.this, "Solo hay disponibles " + ruta2.getTipo1().getCantidadBoleta() + " boletas", 
									"Información", JOptionPane.INFORMATION_MESSAGE);
							return;
						}
						ruta2.getTipo1().setCantidadBoleta((ruta2.getTipo1().getCantidadBoleta() - indiceCantidad));
						JOptionPane.showMessageDialog(InterfazGrafica.this, "Transaccion Realizada Correctamente", 
								"Información", JOptionPane.INFORMATION_MESSAGE);
						break;
					case 2:
						if (ruta2.getTipo2().getCantidadBoleta() == 0) {
							JOptionPane.showMessageDialog(InterfazGrafica.this, "Boletas Agotadas", 
									"Información", JOptionPane.INFORMATION_MESSAGE);
							return;
						} else if((ruta2.getTipo2().getCantidadBoleta() - indiceCantidad) < 0) {
							JOptionPane.showMessageDialog(InterfazGrafica.this, "Solo hay disponibles " + ruta2.getTipo2().getCantidadBoleta() + " boletas", 
									"Información", JOptionPane.INFORMATION_MESSAGE);
							return;
						}
						ruta2.getTipo2().setCantidadBoleta((ruta2.getTipo2().getCantidadBoleta() - indiceCantidad));
						JOptionPane.showMessageDialog(InterfazGrafica.this, "Transaccion Realizada Correctamente", 
								"Información", JOptionPane.INFORMATION_MESSAGE);
						break;
					case 3:
						if (ruta2.getTipo3().getCantidadBoleta() == 0) {
							JOptionPane.showMessageDialog(InterfazGrafica.this, "Boletas Agotadas", 
									"Información", JOptionPane.INFORMATION_MESSAGE);
							return;
						} else if((ruta2.getTipo3().getCantidadBoleta() - indiceCantidad) < 0) {
							JOptionPane.showMessageDialog(InterfazGrafica.this, "Solo hay disponibles " + ruta2.getTipo3().getCantidadBoleta() + " boletas", 
									"Información", JOptionPane.INFORMATION_MESSAGE);
							return;
						}
						ruta2.getTipo3().setCantidadBoleta((ruta2.getTipo3().getCantidadBoleta() - indiceCantidad));
						JOptionPane.showMessageDialog(InterfazGrafica.this, "Transaccion Realizada Correctamente", 
								"Información", JOptionPane.INFORMATION_MESSAGE);
						break;
					}
					break;
				case 3:
					switch(indiceTipo) {
					case 1:
						if (ruta3.getTipo1().getCantidadBoleta() == 0) {
							JOptionPane.showMessageDialog(InterfazGrafica.this, "Boletas Agotadas", 
									"Información", JOptionPane.INFORMATION_MESSAGE);
							return;
						} else if((ruta3.getTipo1().getCantidadBoleta() - indiceCantidad) < 0) {
							JOptionPane.showMessageDialog(InterfazGrafica.this, "Solo hay disponibles " + ruta3.getTipo1().getCantidadBoleta() + " boletas", 
									"Información", JOptionPane.INFORMATION_MESSAGE);
							return;
						}
						ruta3.getTipo1().setCantidadBoleta((ruta3.getTipo1().getCantidadBoleta() - indiceCantidad));
						JOptionPane.showMessageDialog(InterfazGrafica.this, "Transaccion Realizada Correctamente", 
								"Información", JOptionPane.INFORMATION_MESSAGE);
						break;
					case 2:
						if (ruta3.getTipo2().getCantidadBoleta() == 0) {
							JOptionPane.showMessageDialog(InterfazGrafica.this, "Boletas Agotadas", 
									"Información", JOptionPane.INFORMATION_MESSAGE);
							return;
						} else if((ruta3.getTipo2().getCantidadBoleta() - indiceCantidad) < 0) {
							JOptionPane.showMessageDialog(InterfazGrafica.this, "Solo hay disponibles " + ruta3.getTipo2().getCantidadBoleta() + " boletas", 
									"Información", JOptionPane.INFORMATION_MESSAGE);
							return;
						}
						ruta3.getTipo2().setCantidadBoleta((ruta3.getTipo2().getCantidadBoleta() - indiceCantidad));
						JOptionPane.showMessageDialog(InterfazGrafica.this, "Transaccion Realizada Correctamente", 
								"Información", JOptionPane.INFORMATION_MESSAGE);
						break;
					case 3:
						if (ruta3.getTipo3().getCantidadBoleta() == 0) {
							JOptionPane.showMessageDialog(InterfazGrafica.this, "Boletas Agotadas", 
									"Información", JOptionPane.INFORMATION_MESSAGE);
							return;
						} else if((ruta3.getTipo3().getCantidadBoleta() - indiceCantidad) < 0) {
							JOptionPane.showMessageDialog(InterfazGrafica.this, "Solo hay disponibles " + ruta3.getTipo3().getCantidadBoleta() + " boletas", 
									"Información", JOptionPane.INFORMATION_MESSAGE);
							return;
						}
						ruta3.getTipo3().setCantidadBoleta((ruta3.getTipo3().getCantidadBoleta() - indiceCantidad));
						JOptionPane.showMessageDialog(InterfazGrafica.this, "Transaccion Realizada Correctamente", 
								"Información", JOptionPane.INFORMATION_MESSAGE);
						break;
					}
					break;
				}
			}
		});
		btnComprar.setBounds(520, 61, 89, 23);
		contentPane.add(btnComprar);
		
		JLabel lblTipoDeBoleta = new JLabel("Tipo de boleta");
		lblTipoDeBoleta.setBounds(228, 37, 95, 14);
		contentPane.add(lblTipoDeBoleta);
		
		String[] tipoBoleta = {"Seleccione", ruta1.getTipo1().getTipoBoleta(), ruta1.getTipo2().getTipoBoleta(), ruta1.getTipo3().getTipoBoleta()};
		DefaultComboBoxModel<String> modelocbBoleta = new DefaultComboBoxModel<String>(tipoBoleta);
		cbTipo = new JComboBox<String>(modelocbBoleta);
		cbTipo.setBounds(228, 62, 95, 20);
		contentPane.add(cbTipo);
	}
}
