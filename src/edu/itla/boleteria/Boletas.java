package edu.itla.boleteria;

public class Boletas {
	
	private String tipoBoleta;
	private int cantidadBoleta;
	private String precio;
	
	public Boletas(String tipoBoleta, int cantidadBoleta, String precio) {
		this.tipoBoleta = tipoBoleta;
		this.cantidadBoleta = cantidadBoleta;
		this.precio = precio;
	}
	public String getPrecio() {
		return precio;
	}
	public void setPrecio(String precio) {
		this.precio = precio;
	}
	public String getTipoBoleta() {
		return tipoBoleta;
	}
	public void setTipoBoleta(String tipoBoleta) {
		this.tipoBoleta = tipoBoleta;
	}
	public int getCantidadBoleta() {
		return cantidadBoleta;
	}
	public void setCantidadBoleta(int cantidadBoleta) {
		this.cantidadBoleta = cantidadBoleta;
	}
	
	
}
