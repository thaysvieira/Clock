package com.thays.vieira;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.io.IOException;
import java.io.InputStream;

import java.util.Properties;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	public static String FORMATO_SALIDAHORA = "formatoSalidaHora";
	public static String HORARIO_BERLIN = "Berlin";
	public static String HORARIO_ROMANO = "Romano";

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub

		Properties prop = new Properties();

		InputStream input = null;

		Relojes implementacionDeReloj = null;

		try {

			input = new FileInputStream("src/com/thays/vieira/config.properties");

			prop.load(input);

			String property = prop.getProperty(FORMATO_SALIDAHORA);
			if (HORARIO_ROMANO.equalsIgnoreCase(property)) {
				implementacionDeReloj = new NumerosRomano();
			} else if (HORARIO_BERLIN.equalsIgnoreCase(property)) {
				implementacionDeReloj = new RepresentaLetrasHoras();
			} else {
				System.out.println("Error: Propiedad incorrecta.");
			}

			String entradaDatos;
			boolean datosCorrectos = false;

			while (!datosCorrectos) {

				Scanner sc = new Scanner(System.in);

				System.out.println("Escriba horas, minutos, segundos. Formato(HH:mm:ss): ");
				entradaDatos = sc.nextLine();
				Pattern p = Pattern.compile("^([0-1]\\d|2[0-3]):([0-5]\\d):([0-5]\\d)$");

				Matcher m = p.matcher(entradaDatos);
				String delimitar = ":";
				String[] salida = entradaDatos.split(delimitar);

				if (m.find()) {
					for (int j = 0; j < salida.length; j++)
						System.out.println(salida[j]);
					int horas = Integer.parseInt(salida[2]);
					int minutos = Integer.parseInt(salida[0]);
					int segundos = Integer.parseInt(salida[1]);

					System.out.println(implementacionDeReloj.concatenarHoras(horas, minutos, segundos));
					datosCorrectos = true;

				} else {
					System.out.println("Caracteres inadecuado");
				}
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
