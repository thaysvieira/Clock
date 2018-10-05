package com.thays.vieira;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import java.util.Arrays;

import java.util.Collections;

import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RelojeService implements Relojes {

	Relojes implementacionDeReloj = null;
	static Scanner sc = new Scanner(System.in);
	// public static String entradaDatos;

	private void cargarArchivoProperties() throws FileNotFoundException {

		Properties prop = new Properties();

		InputStream input = null;

		input = new FileInputStream("src/com/thays/vieira/config.properties");

		try {
			prop.load(input);

			String property = prop.getProperty(FORMATO_SALIDAHORA);
			if (HORARIO_ROMANO.equalsIgnoreCase(property)) {
				implementacionDeReloj = new NumerosRomano();
			} else if (HORARIO_BERLIN.equalsIgnoreCase(property)) {
				implementacionDeReloj = new RepresentaLetrasHoras();
			} else {
				System.out.println("Error: Propiedad incorrecta.");
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

	public boolean verificarFormatoHoras(String entradaDatos) throws FileNotFoundException {

		try {

			cargarArchivoProperties();
			List<String> horarios = Arrays.asList(entradaDatos.split("\\|"));
			Pattern p = Pattern.compile("^(([0-1]?[0-9])|([2][0-3])):([0-5]?[0-9])(:([0-5]?[0-9]))?$");

			for (String verificar : horarios) {
				Matcher m = p.matcher(verificar);

				if (!m.matches()) {
					System.out.println("Dato  incorrecto ");
				}

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean comprobarBusqueda(String entradaDatos) throws FileNotFoundException {
		cargarArchivoProperties();

		List<String> horarios = Arrays.asList(entradaDatos.split("\\|"));

		return Arrays.asList(horarios).contains(entradaDatos);
	}

	public String ordenar(String dato, String orden) throws FileNotFoundException {
		cargarArchivoProperties();

		String salida[] = dato.split("\\|");

		switch (orden) {
		case "asc":
			for (int a = 0; a < salida.length; a++) {
				if (orden.contains("asc"))
					Arrays.sort(salida);
				System.out.println(salida[a]);
			}
			break;
		case "desc":
			for (int a = 0; a < salida.length; a++) {
				if (orden.contains("desc"))
					Arrays.sort(salida, Collections.reverseOrder());
				System.out.println(salida[a]);
			}
			break;
		default:
			System.out.println("No has ingresado el valor correcto");

		}
		return orden;

	}

	public void imprimirHoras(String dato) throws FileNotFoundException {
		try {

			cargarArchivoProperties();
			List<String> horarios = Arrays.asList(dato.split("\\|"));
			int horas, minutos, segundos;
			String delimitar = "[:]";
			String salida[] = dato.split(delimitar);

			horas = Integer.parseInt(salida[2]);
			minutos = Integer.parseInt(salida[0]);
			segundos = Integer.parseInt(salida[1]);

			System.out.println(implementacionDeReloj.concatenarHoras(horas, minutos, segundos));

		} catch (ArrayIndexOutOfBoundsException exception) {
			// Output expected ArrayIndexOutOfBoundsException.

		} catch (Exception exception) {
			// Output unexpected Exceptions.

		}
	}

	@Override
	public String concatenarHoras(int segundos, int hora, int minutos) {
		// TODO Auto-generated method stub
		return null;
	}

}
