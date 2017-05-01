package edu.itla.boleteria;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class Impresora {
	
public void imprimirReporte(String datos) {
		
		try {
			FileOutputStream fos = new FileOutputStream("reporte.txt");
			PrintWriter pw = new PrintWriter(fos);
			pw.println(datos);
			pw.flush();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
