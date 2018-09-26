package com.thays.vieira;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.io.IOException;
import java.io.InputStream;

import java.util.Properties;

public class Main {
	public static String FORMATO_SALIDAHORA = "formatoSalidaHora";
	public static String HORARIO_BERLIN = "Berlin";
	public static String HORARIO_ROMANO = "Romano";
	

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub

		Properties prop = new Properties();
		RepresentaLetrasHoras berlin = new RepresentaLetrasHoras();
		NumerosRomano romano = new NumerosRomano();

		InputStream input = null;

		try {

			input = new FileInputStream("src/com/thays/vieira/config.properties");
			
			// load a properties file
			prop.load(input);

			String property = prop.getProperty(FORMATO_SALIDAHORA);
			if (HORARIO_BERLIN.equalsIgnoreCase(property)) {

				berlin.introducirDatos();
			} else if (HORARIO_ROMANO.equalsIgnoreCase(property)) {

				romano.introducirDatos();
			} else {
				System.out.println("No lo ha encontrado");
			}

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
