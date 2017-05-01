package edu.itla.boleteria;

public class Rutas {
	
	private String nombre;
	private Boletas tipo1;
	private Boletas tipo2;
	private Boletas tipo3;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Rutas(String nombre, Boletas tipo1, Boletas tipo2, Boletas tipo3) {
		this.nombre = nombre;
		this.tipo1 = tipo1;
		this.tipo2 = tipo2;
		this.tipo3 = tipo3;
	}
	public Boletas getTipo1() {
		return tipo1;
	}
	public void setTipo1(Boletas tipo1) {
		this.tipo1 = tipo1;
	}
	public Boletas getTipo2() {
		return tipo2;
	}
	public void setTipo2(Boletas tipo2) {
		this.tipo2 = tipo2;
	}
	public Boletas getTipo3() {
		return tipo3;
	}
	public void setTipo3(Boletas tipo3) {
		this.tipo3 = tipo3;
	}
	
}
